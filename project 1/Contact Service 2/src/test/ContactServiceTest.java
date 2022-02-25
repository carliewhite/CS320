/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author carliewhite
 *
 */
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

class ContactServiceTest {

	/*
	 * This test ensures that new contacts are added properly
	 */
	@Test
	void testAddContact() {
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("03801", "firstName", "lastName", "0987654321", "address");
		contactService.createContact(testContact);

		assertTrue(contactService.info.containsKey(testContact.getContactId()));

		Exception duplicateException = assertThrows(IllegalArgumentException.class, () -> {
			contactService.createContact(testContact);
		});

		String duplicateExpectedMessage = " ERROR: This ID is already taken";
		String duplicateActualMessage = duplicateException.getMessage();

		assertTrue(duplicateExpectedMessage.equals(duplicateActualMessage));
	}

	/*
	 * This test ensures that contacts are removed properly
	 */
	@Test
	void testRemoveContact() {
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
		contactService.createContact(testContact);
		contactService.deleteContact(testContact.getContactId());

		assertFalse(contactService.info.containsKey(testContact.getContactId()));
	}

	/*
	 * THis test ensures that  each contact can be updated, other
	 * than the contactid which cannot be changed.
	 */
	@Test
	void testUpdateContact() {
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
		contactService.createContact(testContact);

		contactService.updateFirstName("1234", "newFirst");
		contactService.updateLastName("1234", "newLast");
		contactService.updatePhoneNumber("1234", "0987654321");
		contactService.updateAddress("1234", "newAddress");

		Contact updatedContact = contactService.info.get("1234");

		assertTrue(updatedContact.getFirstName().equals("newFirst"));
		assertTrue(updatedContact.getLastName().equals("newLast"));
		assertTrue(updatedContact.getPhoneNumber().equals("0987654321"));
		assertTrue(updatedContact.getAddress().equals("newAddress"));
	}

}
