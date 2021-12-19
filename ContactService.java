

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	
	
	private String uniqueId;
	
	{
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	private List<Contact> contactList = new ArrayList<>();
	
	public ContactService() {
		contactList.add(new Contact(uniqueId));
	}
	
	public ContactService(String firstName) {
		contactList.add(new Contact(uniqueId, firstName));
	}
	
	public ContactService(String firstName, String lastName) {
		contactList.add(new Contact(uniqueId, firstName, lastName));
	}
	
	public ContactService(String firstName, String lastName, String phoneNumber) {
		contactList.add(new Contact(uniqueId, firstName, lastName, phoneNumber));
	}
	
	public ContactService(String firstName, String lastName, String phoneNumber, String address) {
		contactList.add(new Contact(uniqueId, firstName, lastName, phoneNumber, address));
	}
	
	//////
	//Adds a new Contact
	public Contact newContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
		return contact;
	}
	
	//Delete Contact
	public void deleteContact(Contact contact) {
		contactList.remove(contact);
	}
	
	//////
	//Update Each
	public void updateFirstName(Contact contact, String firstName) {
		contact.updateFirstName(firstName);
	}
	
	//Update Last Name
	public void updateLastName(Contact contact, String lastName) {
		contact.updateLastName(lastName);
	}
	
	//Update Phone Number
	public void updatePhoneNumber(Contact contact, String phoneNumber) {
		contact.updatePhoneNumber(phoneNumber);
	}
	
	//Update Address
	public void updateAddress(Contact contact, String address) {
		contact.updateContactAddress(address);
	}
	
	///////
	//Gets the contact List
	public List<Contact> getContactList(){
		return contactList;
	}
	
	///////
	//Creates a new ID
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
}
