package com.wordpress.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;

	public ConfigReader() {
		// TODO Auto-generated constructor stub

		try {
			File src = new File("./Configuration/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public String getchromepath() {

		String path = pro.getProperty("chromeDriver");
		return path;
	}

	public String getApplicationURL() {
		return pro.getProperty("URL");
	}
	
	public String getActualURLforVerification() {
		return pro.getProperty("Actual");
	}
	
	public String getmsedgepath() {

		String path = pro.getProperty("msedgeDriver");
		return path;
	}
	
	public String Exceldata() {
		return pro.getProperty("Excelpath");
		
	}

}
