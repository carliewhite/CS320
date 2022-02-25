package main;

import java.util.TreeMap;

/**
 * @author carliewhite 
 * Version 1.0 
 * January 2022
 */
public class ContactService {

	// Using a TreeMap will allow for us to search by key
	public TreeMap<String, Contact> info = new TreeMap<String, Contact>();

	// Create a new contact ID, throw exception if taken
	public void createContact(Contact contact) {

		if ((this.info.get(contact.getContactId()) == null)) {

			this.info.put(contact.getContactId(), contact);

		} else {

			throw new IllegalArgumentException("ERROR: This ID is already taken");

		}
	}

	// Delete a contact by the contactId
	public void deleteContact(String contactId) {
		this.info.remove(contactId);
	}

	// Update firstName using setter method from Contact.java
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = info.get(contactId);
		contact.setFirstName(firstName);
	}

	// Update lastName using setter method from Contact.java
	public void updateLastName(String contactId, String lastName) {
		Contact contact = info.get(contactId);
		contact.setLastName(lastName);
	}

	// Update phoneNumber using setter method from Contact.java
	public void updatePhoneNumber(String contactId, String phoneNumber) {
		Contact contact = info.get(contactId);
		contact.setPhoneNumber(phoneNumber);
	}

	// Update address using setter method from Contact.java
	public void updateAddress(String contactId, String address) {
		Contact contact = info.get(contactId);
		contact.setAddress(address);
	}
}
