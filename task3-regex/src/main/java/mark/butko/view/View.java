package mark.butko.view;

/**
 * Console view
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class View {

	/**
	 * field - localized string constants container
	 */
	private PropertiesProvider propertiesProvider;

	public static final String EQUALS_STRING = "=";
	public static final String SPACE_STRING = " ";
	public static final String DASH_STRING = "-";

	/**
	 * Creates View object with default parameters
	 * 
	 * @throws Exception
	 */
	public View() throws Exception {
		propertiesProvider = new PropertiesProvider("menu", "ru");
	}

	/**
	 * Prints message in standart ouput stream
	 * 
	 * @param message
	 */
	public static void printlnMessage(String message) {
		System.out.println(message);
	}

	/**
	 * @return localized strings container
	 */
	public PropertiesProvider getPropertiesProvider() {
		return propertiesProvider;
	}

}
