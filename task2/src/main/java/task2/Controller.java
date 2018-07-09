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

		while (!model.addNewGuess(inputIntWithScanner(scanner)))
			;

		view.printlnMessage(View.CONGRATULATION);
		view.printlnMessage(View.HISTORY);
		for (Integer i : model.getHistory()) {
			view.printlnMessage(i + View.SPACE_STRING);
		}
	}

	public int inputIntWithScanner(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			view.printlnMessage(View.WRONG);
			view.printlnRange(model.getMin(), model.getMax());
		}
		return scanner.nextInt();
	}
}
