package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Appointment;

/**
 * @author carliewhite
 *
 *         This program tests to see if the proper exceptions are thrown if the
 *         argument is null or invalid
 */
class AppointmentTest {

	// Initialize variables
	private String id, description;
	private String badID, badDesc;
	private Date date, badDate;

	// Set up variables for use in tests
	@BeforeEach
	void beforeEach() {
		id = "1234567890";
		badID = "qwertyuioplkjhgfdsazxcvbnm";
		description = "12345678900987654321";
		badDesc = "12334567890poiuytrewqqasdfghjklmnbvcxzabcdefghijklmnopqrstuvwxyz";
		date = new Date(2023, Calendar.AUGUST, 9);
		badDate = new Date(0);
	}

	// Test is the setId works properly
	@Test
	void testSetId() {
		Appointment appointment = new Appointment();
		appointment.setId(id);
		assertThrows(IllegalArgumentException.class, () -> appointment.setId(null));
		assertThrows(IllegalArgumentException.class, () -> appointment.setId(badID));
		assertEquals(id, appointment.getId());
	}

	// Test if getId works properly
	@Test
	void testGetId() {
		Appointment appointment = new Appointment(id);
		assertNotNull(appointment.getId());
		assertTrue(appointment.getId().length() == 10);
	}

	// Test if date works properly
	@Test
	void testDate() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class, () -> appointment.setDate(null));
		assertThrows(IllegalArgumentException.class, () -> appointment.setDate(badDate));
		appointment.setDate(date);
		assertEquals(date, appointment.getAppDate());
	}

	// Test if getDate works properly
	@Test
	void testGetDate() {
		Appointment appointment = new Appointment(id, date);
		assertNotNull(appointment.getAppDate());
		assertEquals(date, appointment.getAppDate());
	}

	// Test if setDescription works as intended
	@Test
	void testSetDesc() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class, () -> appointment.setDesc(null));
		assertThrows(IllegalArgumentException.class, () -> appointment.setDesc(badDesc));
		appointment.setDesc(description);
		assertEquals(description, appointment.getDesc());
	}

	// Test if getDesc works as intended
	@Test
	void testGetDesc() {
		Appointment appointment = new Appointment(id, date, description);
		assertNotNull(appointment.getDesc());
		assertTrue(appointment.getDesc().length() < 51);
		assertEquals(description, appointment.getDesc());
	}

}