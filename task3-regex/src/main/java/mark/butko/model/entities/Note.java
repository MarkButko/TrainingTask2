package mark.butko.model.entities;

import mark.butko.model.NoteConstructor;

/**
 * Business entity that describes user
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class Note {

	private String firstName;
	private String lastName;
	private String email;

	/**
	 * Constructor that creates object with empty Strings(not null)
	 */
	public Note() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.email = "";
	}

	/**
	 * Constructor that is a part of builder pattern implementation
	 * 
	 * @param noteConstructor
	 */
	public Note(NoteConstructor noteConstructor) {
		super();
		this.firstName = noteConstructor.firstName;
		this.lastName = noteConstructor.lastName;
		this.email = noteConstructor.email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
