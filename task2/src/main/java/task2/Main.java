package task2;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);

		System.out.println(model.getSecretNumber());
		controller.start();

	}

}
