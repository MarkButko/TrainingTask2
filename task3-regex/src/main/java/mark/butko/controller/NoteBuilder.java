package mark.butko.controller;

import static mark.butko.view.PropertyKeys.INPUT_EMAIL;
import static mark.butko.view.PropertyKeys.INPUT_FIRST_NAME;
import static mark.butko.view.PropertyKeys.INPUT_LAST_NAME;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import mark.butko.model.RegexContainer;
import mark.butko.model.entities.Note;
import mark.butko.view.View;

/**
 * Util controller class that is used to create Note objects from user input
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class NoteBuilder {

	private View view;
	private ControllerUtil controllerUtil;
	private Note note = new Note();

	/**
	 * Creates object with given Scanner and View
	 */
	public NoteBuilder(Scanner scanner, View view) {
		super();
		this.view = view;
		controllerUtil = new ControllerUtil(scanner, view);
	}

	/**
	 * Consecuently gets user input for each Note field
	 * 
	 * @return Note object created from user input
	 * @throws UnsupportedEncodingException
	 */
	public Note build() {
		String firstName;
		String lastName;
		String email;

		RegexContainer languageConst = RegexContainer.valueOf(RegexContainer.class,
				view.getPropertiesProvider().getLanguage().toUpperCase());

		View.printlnMessage(view.getPropertiesProvider().getProperty(INPUT_FIRST_NAME));
		firstName = controllerUtil.requestStringThatMatches(languageConst.getName());

		View.printlnMessage(view.getPropertiesProvider().getProperty(INPUT_LAST_NAME));
		lastName = controllerUtil.requestStringThatMatches(languageConst.getName());

		View.printlnMessage(view.getPropertiesProvider().getProperty(INPUT_EMAIL));
		email = controllerUtil.requestStringThatMatches(languageConst.getEmail());

		note.setFirstName(firstName);
		note.setLastName(lastName);
		note.setEmail(email);

		return note;
	}
}
