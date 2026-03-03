package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		File proFile = new File(System.getProperty("user.dir") +("\\config\\QA.properties") );
	
			FileReader fileReader = new FileReader(proFile);
			
			Properties properties = new Properties();
			  properties.load(fileReader);
			  String urlValue = properties.getProperty("URL");
			   System.out.println(urlValue);
			

}
}



