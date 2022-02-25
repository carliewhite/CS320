package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

/**
 * @author carliewhite
 *
 */

class Appointmentbeans {
	private String id, desc, badDesc;
	private Date date, badDate;

	/*
	 * Initialize each variable to set up test scenarios
	 */
	@BeforeEach
	void beforeEach() {
		id = "1234567890";
		desc = "12345678900987654321";
		badDesc = "12334567890poiuytrewqqasdfghjklmnbvcxzabcdefghijklmnopqrstuvwxyz";
		date = new Date(2023, Calendar.AUGUST, 9);
		badDate = new Date(0);
	}

	/*
	 * Test each version of new appointment
	 */
	@Test
	void testNewAppointment() {
		// Instantiate new instance of AppointmentService
		AppointmentService beans = new AppointmentService();

		// Test the generation of a valid new appointment with ID
		beans.newAppointment();
		beans.newAppointment(date);
		beans.newAppointment(date, desc);
		
		// Test if each getId works
		assertNotNull(beans.getApps().get(0).getId());
		assertNotNull(beans.getApps().get(1).getId());
		assertNotNull(beans.getApps().get(2).getId());
		
		// Test if each getAppDate works
		assertNotNull(beans.getApps().get(0).getAppDate());
		assertNotNull(beans.getApps().get(1).getAppDate());
		assertNotNull(beans.getApps().get(2).getAppDate());
		
		// Test if each getDesc works
		assertNotNull(beans.getApps().get(0).getDesc());
		assertNotNull(beans.getApps().get(1).getDesc());
		assertNotNull(beans.getApps().get(2).getDesc());
	}

	/*
	 * Test if IDs are not repeated and if cancelAppointment works as intended
	 */
	@Test
	void duplication() throws Exception {
		AppointmentService beans = new AppointmentService();

		// Call three new appointments
		beans.newAppointment();
		beans.newAppointment();
		beans.newAppointment();

		// Create variables for each id of each new appointment
		String first = beans.getApps().get(0).getId();
		String second = beans.getApps().get(1).getId();
		String third = beans.getApps().get(2).getId();

		// Ensure that there are no duplicates
		assertNotEquals(id, first);
		assertNotEquals(id, second);
		assertNotEquals(id, third);
		assertNotEquals(first, second);
		assertNotEquals(first, third);
		assertNotEquals(second, third);

		// Cancel the firstId and ensure that it was cancelled
		beans.cancelAppointment(first);
		assertThrows(Exception.class, () -> beans.cancelAppointment(first));
		assertNotEquals(first, beans.getApps().get(0).getId());
	}
}