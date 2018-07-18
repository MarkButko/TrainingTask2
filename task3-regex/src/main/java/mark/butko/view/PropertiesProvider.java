package mark.butko.view;

import java.io.FileReader;
import java.util.Properties;

/**
 * Reads properties file for specified or default language and brings access to
 * this properties
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class PropertiesProvider {

	/**
	 * Container that holds readed properties
	 */
	Properties properties = new Properties();

	/**
	 * specified language of properties
	 */
	String language;

	/**
	 * Constructor that creates object with default(Russian) language
	 * 
	 * @param filename file with properties
	 */
	public PropertiesProvider(String fileName) throws Exception {
		this.language = "ru";
		FileReader fileReader = new FileReader("src/main/resources/" + fileName + "_" + language + ".properties");
		properties.load(fileReader);
	}

	/**
	 * Constructor that creates object with specified language
	 * 
	 * @param filename file with properties
	 * @param language short language code
	 */
	public PropertiesProvider(String fileName, String language) throws Exception {
		this.language = language;
		String localizedFileName = fileName + "_" + language;
		FileReader fileReader = new FileReader("src/main/resources/" + localizedFileName + ".properties");
		properties.load(fileReader);
	}

	/**
	 * @param key
	 * @return property by given key
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * @return short name of language of properties file
	 */
	public String getLanguage() {
		return language;
	}
}
