package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

// read and access properties file like QA properties file , UAT prop file , DEV properties file 
public class PropertiesUtil {

	public static String readProperty(Env env,String propertyName) {
		
		System.out.println(System.getProperty("user.dir"));
		File proFile = new File(System.getProperty("user.dir") +("\\config\\"+env+".properties") );// QA
	
			FileReader fileReader = null;
			Properties properties = new Properties();
			
			try {
				fileReader = new FileReader(proFile);
				properties.load(fileReader);
			} 
			
			catch (FileNotFoundException e) {
				  e.printStackTrace();
			}
	     
			catch (IOException e) {
				  e.printStackTrace();
			}
			  
			  String urlValue = properties.getProperty(propertyName.toUpperCase());// URL
			   return(urlValue);

}
}



