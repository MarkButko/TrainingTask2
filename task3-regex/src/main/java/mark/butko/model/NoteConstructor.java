package mark.butko.model;

import mark.butko.model.entities.Note;

/**
 * Class that is implementation of builder pattern for Note objects.
 * 
 * @author Butko Mark
 *
 */
public class NoteConstructor {

	public String firstName;
	public String lastName;
	public String email;

	/**
	 * Sets email value.
	 * 
	 * @param email
	 * @return reference to this NoteConstructor object
	 */
	public NoteConstructor withEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Sets last name value.
	 * 
	 * @param lastName
	 * @return reference to this NoteConstructor object
	 */
	public NoteConstructor withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Sets first name value.
	 * 
	 * @param firstName
	 * @return reference to this NoteConstructor object
	 */
	public NoteConstructor withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Creates new Note object with fields specified in withXXX methods. Other not
	 * specified values remains default.
	 * 
	 * @return Note object
	 */
	public Note build() {
		return new Note(this);
	}

}
