package mark.butko.view;

public class View {

	private PropertiesProvider propertiesProvider;

	public static final String EQUALS_STRING = "=";
	public static final String SPACE_STRING = " ";
	public static final String DASH_STRING = "-";

	public View() throws Exception {
		propertiesProvider = new PropertiesProvider("menu", "ru");
	}

	public static void printlnMessage(String message) {
		System.out.println(message);
	}

	public PropertiesProvider getPropertiesProvider() {
		return propertiesProvider;
	}

}
