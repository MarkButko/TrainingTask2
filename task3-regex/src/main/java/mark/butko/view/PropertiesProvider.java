package mark.butko.view;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesProvider {

	Properties properties = new Properties();
	String language;

	public PropertiesProvider(String fileName) throws Exception {
		this.language = "ru";
		FileReader fileReader = new FileReader(fileName + "_" + language);
		properties.load(fileReader);
	}

	public PropertiesProvider(String fileName, String language) throws Exception {
		this.language = language;
		String localizedFileName = fileName + "_" + language;
		FileReader fileReader = new FileReader("src/main/resources/" + localizedFileName + ".properties");
		properties.load(fileReader);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public String getLanguage() {
		return language;
	}
}
