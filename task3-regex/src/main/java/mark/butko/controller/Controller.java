package mark.butko.controller;

import java.util.Scanner;

import mark.butko.model.Model;
import mark.butko.model.entities.Note;
import mark.butko.model.entities.Notebook;
import mark.butko.view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void processUser() {
		Scanner scanner = new Scanner(System.in);

		NoteBuilder noteBuilder = new NoteBuilder(scanner, view);
		Note note = noteBuilder.build();
		Notebook notebook = new Notebook();
		notebook.addNote(note);

		View.printlnMessage(
				note.getEmail() + View.SPACE_STRING + note.getFirstName() + View.SPACE_STRING + note.getLastName());
	}

}
