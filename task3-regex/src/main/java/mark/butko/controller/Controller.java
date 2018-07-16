package mark.butko.controller;

import java.util.Scanner;

import mark.butko.model.Model;
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
	}

	public int inputIntWithScanner(Scanner scanner) {
		while (true) {
			if (!scanner.hasNextInt()) {
				view.printlnMessage("Wrong");
				scanner.next();
			} else {
				int input = scanner.nextInt();
				if (!true) {
					view.printlnMessage("Wrong");
				} else {
					return input;
				}
			}

		}
	}
}
