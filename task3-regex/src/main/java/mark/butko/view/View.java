package mark.butko.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Console view. Prints messages to user. Internacionlizad messages provided by
 * menuPropertiesProvider
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class View {

	private ResourceBundle resourceBundle;
	private Locale locale;
	private PropertiesProvider menuPropertiesProvider;

	public static final String EQUALS_STRING = "=";
	public static final String SPACE_STRING = " ";
	public static final String DASH_STRING = "-";
	public static final String SPACED_DASH_STRING = " - ";

	/**
	 * Creates View object with default parameters
	 * 
	 * @throws Exception
	 */
	public View() throws Exception {
		this(Locale.getDefault());
	}

	/**
	 * Creates View object with specified Locale. Uses default locale if there is
	 * not file for specifeid.
	 * 
	 * 
	 * @param locale
	 * @throws Exception
	 */
	public View(Locale locale) throws Exception {
		this.locale = locale;
		this.resourceBundle = ResourceBundle.getBundle("menu", this.locale);
		this.menuPropertiesProvider = new ResourceBundlePropertiesProvider(this.resourceBundle, this.locale);
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
		return menuPropertiesProvider;
	}

}
