package mark.butko.controller;

import java.util.Scanner;

import mark.butko.view.PropertyKeys;
import mark.butko.view.View;

public class ControllerUtil {

	private Scanner scanner;
	private View view;

	public ControllerUtil(Scanner scanner, View view) {
		super();
		this.scanner = scanner;
		this.view = view;
	}

	public String requestStringThatMatches(String regex) {
		String result = null;
		while (!(scanner.hasNext() && (result = scanner.next()).matches(regex))) {
			View.printlnMessage(view.getPropertiesProvider().getProperty(PropertyKeys.WRONG_INPUT));
		}
		return result;
	}
}
