/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carliewhite
 *
 */
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	
	/*
	 * This test ensures that the contactId is not longer than 10
	 * characters and is not null
	 */

	@Test
	public void testContactId() {
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "firstName", "lastName", "1234567890", "address");
		});

		String nullExpectedMessage = "ERROR: ID must be less than 10 digits";
		String nullActualMessage = nullException.getMessage();

		assertTrue(nullActualMessage.equals(nullExpectedMessage));

		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "first", "last", "1234567890", "address");
		});

		String lengthExpectedMessage = "ERROR: ID must be less than 10 digits";
		String lengthActualMessage = lengthException.getMessage();

		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));

	}

	/*
	 * This test ensure that the firstName is not longer than 10
	 * characters and is not null
	 */
	@Test
	public void testFirstName() {
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "lastName", "1234567890", "address");
		});

		String nullExpectedMessage = "ERROR: First Name must be less than 10 characters";
		String nullActualMessage = nullException.getMessage();

		assertTrue(nullActualMessage.equals(nullExpectedMessage));

		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Carlie White", "lastName", "1234567890", "address");
		});

		String lengthExpectedMessage = "ERROR: First Name must be less than 10 characters";
		String lengthActualMessage = lengthException.getMessage();

		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}

	/*
	 * This test ensures that the lastName is not longer than 10
	 * characters and is not null
	 */
	@Test
	public void testLastName() {
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", null, "1234567890", "address");
		});

		String nullExpectedMessage = "ERROR: Last Name must be less than 10 characters";
		String nullActualMessage = nullException.getMessage();

		assertTrue(nullActualMessage.equals(nullExpectedMessage));

		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "Carlie White", "1234567890", "address");
		});

		String lengthExpectedMessage = "ERROR: Last Name must be less than 10 characters";
		String lengthActualMessage = lengthException.getMessage();

		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	/*
	 * This test ensures that the phone number is not longer than 10
	 * characters and is not null
	 */
	@Test
	public void testPhoneNumber() {
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", null, "address");
		});

		String nullExpectedMessage = "ERROR: Invalid Phone Number length, must be 10 digits";
		String nullActualMessage = nullException.getMessage();

		assertTrue(nullActualMessage.equals(nullExpectedMessage));

		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "12345678909876543321", "address");
		});

		String lengthExpectedMessage = "ERROR: Invalid Phone Number length, must be 10 digits";
		String lengthActualMessage = lengthException.getMessage();

		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}

	/*
	 * This test ensure that the address is not longer than 30
	 * characters and is not null
	 */
	@Test
	public void testAddress() {
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "1234567890", null);
		});

		String nullExpectedMessage = "ERROR: Address must not be longer than 20 characters.";
		String nullActualMessage = nullException.getMessage();

		assertTrue(nullActualMessage.equals(nullExpectedMessage));

		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "1234567890", "P Sherman, 42 Wallaby Way, Sydney");
		});

		String lengthExpectedMessage = "ERROR: Address must not be longer than 20 characters.";
		String lengthActualMessage = lengthException.getMessage();

		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}

}
