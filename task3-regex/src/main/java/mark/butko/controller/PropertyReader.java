package mark.butko.controller;

import java.io.FileReader;
import java.util.Properties;

class PropertyReader {

	Properties properties = new Properties();

	public PropertyReader(String fileName) throws Exception {
		FileReader fileReader = new FileReader(fileName);
		properties.load(fileReader);
	}

	public PropertyReader(String fileName, String language) throws Exception {
		String localizedFileName = fileName + "_" + language;
		FileReader fileReader = new FileReader(localizedFileName);
		properties.load(fileReader);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
