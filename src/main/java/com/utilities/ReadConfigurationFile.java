package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigurationFile {
	public static Properties readConfiguration() {

		Properties prop = null;

		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\settings.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prop;

	}
}
