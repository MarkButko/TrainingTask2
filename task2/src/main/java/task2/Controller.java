package task2;

import java.util.Scanner;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		view.printlnMessage(View.GREETING);
		view.printlnRange(model.getMin(), model.getMax());

		while (!model.addNewGuess(inputIntWithScanner(scanner))) {
			if (model.getHistory().get(model.getHistory().size() - 1) < model.getSecretNumber()) {
				view.printlnMessage(View.GREATER);
			} else {
				view.printlnMessage(View.LESS);
			}
			view.printlnRange(model.getMin(), model.getMax());
		}

		view.printlnMessage(View.CONGRATULATION);
		view.printlnMessage(View.HISTORY + model.getHistory());
	}

	public int inputIntWithScanner(Scanner scanner) {
		while (true) {
			if (!scanner.hasNextInt()) {
				view.printlnMessage(View.WRONG);
				view.printlnRange(model.getMin(), model.getMax());
				scanner.next();
			} else {
				int input = scanner.nextInt();
				if (!model.isInRange(input)) {
					view.printlnMessage(View.WRONG);
					view.printlnRange(model.getMin(), model.getMax());
				} else {
					return input;
				}
			}

		}
	}
}
