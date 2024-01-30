package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	/**
	 * This Method is used to read the data from property Files
	 * @author Aftab
	 * @param key
	 * @return String
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis = new FileInputStream(IpathConstant.PROPERTYFILEPATH);
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
}
