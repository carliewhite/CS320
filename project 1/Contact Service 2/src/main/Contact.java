/**
 * 
 */
package main;

/**
 * @author carliewhite 
 * Version 1.0 
 * January 2022
 */
public class Contact {

	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	/*
	 * Check each entry to ensure that they meet the requirements. 
	 * If an entry is incorrect, an exception will be thrown. 
	 * Else, the value will be stored.
	 */
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {

		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("ERROR: ID must be less than 10 digits");
		}
		else {
			this.contactId = contactId;
		}

		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("ERROR: First Name must be less than 10 characters");
		}
		else {
			this.firstName = firstName;
		}

		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("ERROR: Last Name must be less than 10 characters");
		}
		else {
			this.lastName = lastName;
		}
		
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("ERROR: Invalid Phone Number length, must be 10 digits");
		}
		else {
			this.phoneNumber = phoneNumber;
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("ERROR: Address must not be longer than 20 characters.");
		}
		else {
			this.address = address;
		}
	}

	/**
	 * @return the contactId contactId doesn't have a setter because it will not be
	 *         modified
	 */
	public String getContactId() {
		return contactId;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}