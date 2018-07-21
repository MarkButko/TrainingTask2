package mark.butko.model;

import mark.butko.model.entities.Note;

public class NoteConstructor {

	public String firstName;
	public String lastName;
	public String email;

	public NoteConstructor withEmail(String email) {
		this.email = email;
		return this;
	}

	public NoteConstructor withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public NoteConstructor withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Note build() {
		return new Note(this);
	}

}
