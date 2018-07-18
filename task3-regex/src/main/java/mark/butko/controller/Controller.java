package mark.butko.controller;

import java.util.Scanner;

import mark.butko.model.Model;
import mark.butko.model.entities.Note;
import mark.butko.model.entities.Notebook;
import mark.butko.view.View;

/**
 * Controls application flow
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class Controller {

	/**
	 * bussines logic
	 */
	private Model model;
	/**
	 * user view
	 */
	private View view;

	/**
	 * Creates new object with given logic and view
	 * 
	 * @param model
	 * @param view
	 */
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	/**
	 * Gets one Note object ftom user input and psses it to model
	 */
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
