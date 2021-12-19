

public class Contact {
	
	// All declarations below
	// Declarations for final values for max characters
	private static final int CONTACT_PHONENUMBER_LENGTH = 10;
	private static final byte CONTACT_ID_LENGTH = 10;
	private static final byte CONTACT_FIRST_NAME_LENGTH = 10;
	private static final byte CONTACT_LAST_NAME_LENGTH = 10;
	private static final byte CONTACT_ADDRESS_LENGTH = 30;
	private static final String INITIAL = "INITIAL";
	private static final String INITIAL_PHONE_NUMBER = "0123456789";
	
	//Declarations for main strings
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	
	// Default Constructor
	public Contact() {
	    this.contactId = INITIAL;
	    this.firstName = INITIAL;
	    this.lastName = INITIAL;
	    this.phoneNumber = INITIAL_PHONE_NUMBER;
	    this.address = INITIAL;
	  }
	
	//Overloading Constructor for Contact ID
	public Contact(String contactId) {
	
		updateContactId(contactId);
		this.firstName = INITIAL;
		this.lastName = INITIAL;
		this.phoneNumber = INITIAL_PHONE_NUMBER;
		this.address = INITIAL;	
		}
	
	//Overloading Constructor for Contact ID and First Name
	public Contact(String contactId, String firstName) {
	
		updateContactId(contactId);
		updateFirstName(firstName);
		this.lastName = INITIAL;
		this.phoneNumber = INITIAL_PHONE_NUMBER;
		this.address = INITIAL;	
		}
	
	//Overloading Constructor for Contact ID, First and Last Name
	public Contact(String contactId, String firstName, String lastName) {
	
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = INITIAL_PHONE_NUMBER;
		this.address = INITIAL;	
		}
	
	//Overloading Constructor for Contact ID, First Name, Last Name, and Phone Number
	public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
	
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = INITIAL;	
		}
	
	//Overloading constructor for all
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
	
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateContactAddress(address);
		}
	
	
	//Accessors for each 
	
	public final String getContactId() {
		return contactId;
	}
	public final String getFirstName() {
		return firstName;
	}
	public final String getLastName() {
		return lastName;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}
	public final String getAddress() {
		return address;
	}
	


	//Methods that update each
	//Will throw IllegalArgumentException if requirements are not met. 
	
	public void updateFirstName(String firstName) {
		if(firstName == null)
			throw new IllegalArgumentException("Invaid First Name");
		else if(firstName.length() > CONTACT_FIRST_NAME_LENGTH)
			throw new IllegalArgumentException("First Name Is Longer Than " + CONTACT_FIRST_NAME_LENGTH + " Characters");
		else
			this.firstName = firstName;
	}
	
	
	public void updateLastName(String lastName) {
		if(lastName == null)
			throw new IllegalArgumentException("Invaid Last Name");
		else if(lastName.length() > CONTACT_LAST_NAME_LENGTH)
			throw new IllegalArgumentException("Last Name Is Longer Than " + CONTACT_LAST_NAME_LENGTH + " Characters");
		else
			this.lastName = lastName;
	}
	
	
	public void updatePhoneNumber(String phoneNumber) {
		
		String reg = "[0-9]+";
		
		if(phoneNumber.length() != CONTACT_PHONENUMBER_LENGTH)
			throw new IllegalArgumentException("Invaid Phone Number Length. Must Be " + CONTACT_PHONENUMBER_LENGTH + " Digits");
		else if(!phoneNumber.matches(reg))
			throw new IllegalArgumentException("Phone Number Must Only Contain Numbers");
		else
			this.phoneNumber = phoneNumber;
	}
	
	
	public void updateContactAddress(String address) {
		if(address == null)
			throw new IllegalArgumentException("Invaid Address");
		else if(address.length() > CONTACT_ADDRESS_LENGTH)
			throw new IllegalArgumentException("Address Is Longer Than " + CONTACT_ADDRESS_LENGTH + " Characters");
		else
			this.address = address;
	}
	
	
	protected void updateContactId(String id) {
		if(id == null)
			throw new IllegalArgumentException("Invaid ID");
		else if(id.length() > CONTACT_ID_LENGTH)
			throw new IllegalArgumentException("ID Is Longer Than " + CONTACT_ID_LENGTH + " Characters");
		else
			this.contactId = id;
	}
}
