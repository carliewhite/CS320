/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author carliewhite
 *
 */
public class AppointmentService {

	// initialize list
	public List<Appointment> appointmentList = new ArrayList<>();

	// retrieve the list
	public List<Appointment> getApps() {
		return appointmentList;
	}

	// create new random IDs
	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, 10);
	}

	/*
	 * create a new appointment for each element for easier testing
	 */
	public void newAppointment() {
		Appointment appointment = new Appointment(newUniqueId());
		appointmentList.add(appointment);
	}

	/*
	 * create a new appointment for each element for easier testing
	 */
	public void newAppointment(Date date) {
		Appointment appointment = new Appointment(newUniqueId(), date);
		appointmentList.add(appointment);
	}

	/*
	 * create a new appointment for each element for easier testing
	 */
	public void newAppointment(Date date, String description) {
		Appointment appointment = new Appointment(newUniqueId(), date, description);
		appointmentList.add(appointment);
	}

	/*
	 * a method to remove an appoint from the list by id
	 */
	public void cancelAppointment(String id) throws Exception {
		appointmentList.remove(search(id));
	}

	/*
	 * search for appointment in list by id
	 */
	private Appointment search(String id) throws Exception {
		int index = 0;
		while (index < appointmentList.size()) {
			if (id.equals(appointmentList.get(index).getId())) {
				return appointmentList.get(index);
			}
			index++;
		}
		throw new Exception("The appointment does not exist!");
	}
}