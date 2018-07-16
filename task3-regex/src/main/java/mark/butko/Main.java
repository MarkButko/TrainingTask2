package mark.butko;

import mark.butko.controller.Controller;
import mark.butko.model.Model;
import mark.butko.view.View;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);

		controller.processUser();

	}

}
