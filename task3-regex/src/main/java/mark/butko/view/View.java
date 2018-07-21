package mark.butko.view;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Console view
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
	 * Creates View object with specified Locale
	 * 
	 * @param locale
	 * @throws Exception
	 */
	public View(Locale locale) throws Exception {
		this.locale = locale;
		InputStream stream = null;
		stream = getClass().getClassLoader().getResourceAsStream("menu_" + locale.getLanguage() + ".properties");
		if (stream == null) {
			stream = getClass().getClassLoader().getResourceAsStream("menu.properties");
		}
		Reader reader = new InputStreamReader(stream, "UTF-8");
		this.resourceBundle = new PropertyResourceBundle(reader);
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
