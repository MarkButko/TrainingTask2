package mark.butko.controller;

import java.util.Scanner;

import mark.butko.model.entities.Note;
import mark.butko.model.entities.Notebook;
import mark.butko.model.exceptions.UserAlreadyExistsException;
import mark.butko.view.PropertyKeys;
import mark.butko.view.View;

/**
 * Provides util methods that get user input
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class ControllerUtil {

	/**
	 * used for reading user input
	 */
	private Scanner scanner;

	/**
	 * used for interacting with user through given view methods
	 */
	private View view;

	/**
	 * Creates object with given view and scanner
	 * 
	 * @param scanner
	 * @param view
	 */
	public ControllerUtil(Scanner scanner, View view) {
		super();
		this.scanner = scanner;
		this.view = view;
	}

	/**
	 * interacts with user and gets user console input that matches given regex
	 * 
	 * @param regex regular expression pattern
	 * @return valid user input
	 */
	public String requestStringThatMatches(String regex) {
		String result = null;
		while (!(scanner.hasNext() && (result = scanner.next()).matches(regex))) {
			View.printlnMessage(view.getPropertiesProvider().getProperty(PropertyKeys.WRONG_INPUT));
		}
		return result;
	}

	public void checkUniqness(String email) throws UserAlreadyExistsException {
		for (Note note : Notebook.getNotesList())
			if (email.equalsIgnoreCase(note.getEmail())) {
				throw new UserAlreadyExistsException(email);
			}
	}
}
