package jp.co.sample.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HelloProp {

	private Properties properties = null;

	public void loadPropertiesByXml(String path) throws HelloException {
		properties = new Properties();
		try {
			properties.loadFromXML(new FileInputStream(path));
		} catch (IOException ex) {
			throw new HelloException(ex.getMessage());
		}
	}

	public String getProperty(String key) {
		if (properties == null) {
			return "";
		}

		return properties.getProperty(key);
	}

}
