

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ContactServiceTest {
	
	protected String contactId;
	protected String firstNameTest;
	protected String lastNameTest;
	protected String phoneNumberTest;
	protected String addressTest;
	protected String tooLongContactId;
	protected String tooLongFirstName;
	protected String tooLongLastName;
	protected String tooLongPhoneNumber;
	protected String tooShortPhoneNumber;
	protected String tooLongAddress;
	
	@BeforeEach
	void setUp() {
		contactId = "0123456789";
		firstNameTest = "Oliver";
		lastNameTest = "Milani";
		phoneNumberTest = "1112223333";
		addressTest = "101 Junit Ave";
	    tooLongContactId = "0123456789001122334";
	    tooLongFirstName = "My Name Too Long";
	    tooLongLastName = "For this Program";
	    tooLongPhoneNumber = "111222333444555";
	    tooShortPhoneNumber = "012345";
	    tooLongAddress = "123456 Really Long Address that someone does not live at";
	  }
	
	@Test
	void ContactServiceConstructorTest() {
	    ContactService service = new ContactService();
	    Assertions.assertNotNull(service.getContactList().get(0).getContactId());
	}
	
	@Test
	void ContactServiceConstructorIdLengthTest() {
	    ContactService service = new ContactService();
	    Assertions.assertTrue(service.getContactList().get(0).getContactId().length() <= 10);
	}
	
	@Test
	void ContactServiceConstructorFirstNameTest() {
	    ContactService service = new ContactService(firstNameTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	}
	
	@Test
	void ContactServiceConstructorFullNameTest() {
	    ContactService service = new ContactService(firstNameTest, lastNameTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	}
	
	@Test
	void ContactServiceConstructorFullNameAndNumberTest() {
	    ContactService service = new ContactService(firstNameTest, lastNameTest, phoneNumberTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
	}
	
	@Test
	void ContactServiceConstructorIntializeEverythingTest() {
	    ContactService service = new ContactService(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	}
	
	@Test
	void newContactTest() {
	    ContactService service = new ContactService();
	    Contact tempContactObject = service.newContact();
	    Assertions.assertNotEquals(tempContactObject.getContactId(), service.getContactList().get(0).getContactId());
	}
	
	@Test
	void newContactUpdateTest() {
	    ContactService service = new ContactService();
	    Contact tempContactObject = service.newContact();
	    Assertions.assertNotNull(tempContactObject.getContactId());
	    Assertions.assertNull(tempContactObject.getFirstName());
	    Assertions.assertNull(tempContactObject.getLastName());
	    Assertions.assertNull(tempContactObject.getPhoneNumber());
	    Assertions.assertNull(tempContactObject.getAddress());
	    tempContactObject.updateFirstName(firstNameTest);
	    tempContactObject.updateLastName(lastNameTest);
	    tempContactObject.updatePhoneNumber(phoneNumberTest);
	    tempContactObject.updateContactAddress(addressTest);
	    assertEquals(firstNameTest, tempContactObject.getFirstName());
	    assertEquals(lastNameTest, tempContactObject.getLastName());
	    assertEquals(phoneNumberTest, tempContactObject.getPhoneNumber());
	    assertEquals(addressTest, tempContactObject.getAddress());
	}
	
	@Test
	void updateContactUpdateListTest() {
	    ContactService service = new ContactService();
	    Contact tempContactObject = service.newContact();
	    Assertions.assertNotNull(tempContactObject.getContactId());
	    Assertions.assertNull(tempContactObject.getFirstName());
	    Assertions.assertNull(tempContactObject.getLastName());
	    Assertions.assertNull(tempContactObject.getPhoneNumber());
	    Assertions.assertNull(tempContactObject.getAddress());
	    service.getContactList().get(0).updateFirstName(firstNameTest);
	    service.getContactList().get(0).updateLastName(lastNameTest);
	    service.getContactList().get(0).updatePhoneNumber(phoneNumberTest);
	    service.getContactList().get(0).updateContactAddress(addressTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	}
	
	@Test
	void multipleNewContactTest() {
	    ContactService service = new ContactService(tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooLongAddress);
	    Contact tempContact1 = service.newContact();
	    Contact tempContact2 = service.newContact();
	    Assertions.assertNotEquals(tempContact1.getContactId(), service.getContactList().get(0).getContactId());
	    Assertions.assertNotEquals(tempContact2.getContactId(), service.getContactList().get(0).getContactId());
	    Assertions.assertNotEquals(tempContact1.getContactId(), tempContact2.getContactId());
	    Assertions.assertTrue(service.getContactList().size() >= 2);
	    Assertions.assertNotEquals(service.getContactList().get(0).getContactId(), service.getContactList().get(1).getContactId());
	    Assertions.assertNotEquals(service.getContactList().get(0).getContactId(), service.getContactList().get(2).getContactId());
	    Assertions.assertNotEquals(service.getContactList().get(1).getContactId(), service.getContactList().get(2).getContactId());
	}
	
	@Test
	void deleteContactTest() {
	    ContactService service = new ContactService(tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooLongAddress);
	    Contact tempContact1 = service.newContact();
	    Contact tempContact2 = service.newContact();
	    service.getContactList().get(1).updateFirstName(firstNameTest);
	    service.getContactList().get(1).updateLastName(lastNameTest);
	    service.getContactList().get(1).updatePhoneNumber(phoneNumberTest);
	    service.getContactList().get(1).updateContactAddress(addressTest);
	    assertEquals(tooLongFirstName, service.getContactList().get(0).getFirstName());
	    assertEquals(tooLongLastName, service.getContactList().get(0).getLastName());
	    assertEquals(tooLongPhoneNumber, service.getContactList().get(0).getPhoneNumber());
	    assertEquals(tooLongAddress, service.getContactList().get(0).getAddress());
	    assertEquals(firstNameTest, service.getContactList().get(1).getFirstName());
	    assertEquals(lastNameTest, service.getContactList().get(1).getLastName());
	    assertEquals(phoneNumberTest, service.getContactList().get(1).getPhoneNumber());
	    assertEquals(addressTest, service.getContactList().get(1).getAddress());
	    service.deleteContact(service.getContactList().get(0));
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	}
	
	@Test
	void updateFirstNameTest() {
	    ContactService service = new ContactService();
	    service.updateFirstName(service.getContactList().get(0), firstNameTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	}
	
	@Test
	void updateLastNameTest() {
	    ContactService service = new ContactService();
	    service.updateLastName(service.getContactList().get(0), lastNameTest);
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	}
	
	@Test
	void updatePhoneNumberTest() {
	    ContactService service = new ContactService();
	    service.updatePhoneNumber(service.getContactList().get(0), phoneNumberTest);
	    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
	    assertThrows(IllegalArgumentException.class, () -> service.getContactList().get(0).updatePhoneNumber(contactId));
	}
	
	@Test
	void updateAddressTest() {
	    ContactService service = new ContactService();
	    service.updateAddress(service.getContactList().get(0), addressTest);
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	}
	
}
