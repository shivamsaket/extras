package com.amarpushp.project.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyFileReader {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private Properties properties = new Properties();

	public PropertyFileReader(String fileName) {
		try {
			properties.load(
					new FileInputStream(new File(this.getClass().getClassLoader().getResource(fileName).getFile())));
		} catch (Exception e) {
			logger.error("Error loading property file");
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public int getPropertyAsInt(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}

	public double getPropertyAsDouble(String key) {
		return Double.parseDouble(properties.getProperty(key));
	}

	public float getPropertyAsFloat(String key) {
		return Float.parseFloat(properties.getProperty(key));
	}

	/*public static void main(String[] args) {
		PropertyFileReader reader = new PropertyFileReader("application.properties");
		System.out.println(reader.getProperty("aws.user.accessKey"));
		System.out.println(reader.getProperty("aws.user.accessSecret"));
	}*/
}
