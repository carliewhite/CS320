/**
 * 
 */
package main;

import java.util.Date;

/**
 * @author carliewhite
 *
 */
public class Appointment {

	// initialize variables
	private String id;
	private Date appDate;
	private String desc;

	// base constructor for appointment
	public Appointment() {
		Date today = new Date();
		id = "";
		appDate = today;
		desc = "";
	}

	// constructor for id
	public Appointment(String id) {
		Date today = new Date();
		setId(id);
		appDate = today;
		desc = "";
	}

	// constructor for date
	public Appointment(String id, Date date) {
		setId(id);
		setDate(date);
		desc = "";
	}

	// constructor for description
	public Appointment(String id, Date date, String desc) {
		setId(id);
		setDate(date);
		setDesc(desc);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param setid sets the appointment unless the id is null or is longer than 10
	 *              characters
	 */
	public void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ERROR: must have an ID");
		} else if (id.length() > 10) {
			throw new IllegalArgumentException("ERROR: ID can't be longer than 10 chars");
		} else {
			this.id = id;
		}
	}

	/**
	 * @return the appointment date
	 */
	public Date getAppDate() {
		return appDate;
	}

	/**
	 * @param set the date and throw exceptions if the date is before the current
	 *            date or the date is null. If there are no exceptions, then date =
	 *            date
	 */
	public void setDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("ERROR: date can't be null");
		} else if (date.before(new Date())) {
			throw new IllegalArgumentException("ERROR: date cannot be before the current date");
		} else {
			this.appDate = date;
		}
	}

	/**
	 * @return the description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param description the description to set
	 */
	public void setDesc(String desc) {
		if (desc == null) {
			throw new IllegalArgumentException("ERROR: description can't be null.");
		} else if (desc.length() > 50) {
			throw new IllegalArgumentException("ERROR: description can't be longer than 50 characters.");
		} else {
			this.desc = desc;
		}
	}

}