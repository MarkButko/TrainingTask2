package mark.butko.controller;

import static mark.butko.model.RegexContainer.EMAIL_REGEX;
import static mark.butko.model.RegexContainer.NAME_EN_REGEX;
import static mark.butko.model.RegexContainer.NAME_RU_REGEX;
import static mark.butko.view.PropertyKeys.INPUT_EMAIL;
import static mark.butko.view.PropertyKeys.INPUT_FIRST_NAME;
import static mark.butko.view.PropertyKeys.INPUT_LAST_NAME;

import java.util.Scanner;

import mark.butko.model.entities.Note;
import mark.butko.view.View;

public class NoteBuilder {

	private View view;

	private ControllerUtil controllerUtil;
	private Note note = new Note();

	public NoteBuilder(Scanner scanner, View view) {
		super();
		this.view = view;
		controllerUtil = new ControllerUtil(scanner, view);
	}

	public Note build() {
		String temp;

		View.printlnMessage(view.getPropertiesProvider().getProperty(INPUT_FIRST_NAME));
		temp = controllerUtil.requestStringThatMatches(
				(view.getPropertiesProvider().getLanguage().equals("ru")) ? NAME_RU_REGEX : NAME_EN_REGEX);
		note.setFirstName(temp);

		View.printlnMessage(view.getPropertiesProvider().getProperty(INPUT_LAST_NAME));
		temp = controllerUtil.requestStringThatMatches(
				(view.getPropertiesProvider().getLanguage().equals("ru")) ? NAME_RU_REGEX : NAME_EN_REGEX);
		note.setLastName(temp);

		View.printlnMessage(view.getPropertiesProvider().getProperty(INPUT_EMAIL));
		temp = controllerUtil.requestStringThatMatches((EMAIL_REGEX));
		note.setEmail(temp);

		return note;
	}
}
