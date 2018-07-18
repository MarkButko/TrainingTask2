package mark.butko;

import mark.butko.controller.Controller;
import mark.butko.model.Model;
import mark.butko.view.View;

/**
 * Class that has main() method
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);

		controller.processUser();
	}
}
