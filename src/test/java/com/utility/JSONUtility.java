package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {
	
	
	// Use main method to debug this utility class 
	//public static void main(String[] args) {
	//    String url = readJSON("QA");
	//    System.out.println(url);
	//}

	//read and access environment variable from JSON file
	//public static String readJSON(Env env){
   
		//********** QA,DEV,UAT are keys stored as String,url is the json object stored as environment class object 
		//Gson gson = new Gson();
		//File jsonfile = new File(System.getProperty("user.dir")+"\\config\\config.json");
		//FileReader filereader = null;
		//try {
		//	filereader = new FileReader(jsonfile);
	//	} catch (FileNotFoundException e) {
		//	e.printStackTrace();
		//}
		
		//****************Reference of Config class which creates a config object 
		//****here config.json mapped to config.java 
		//Config config  = gson.fromJson(filereader,Config.class);
		
		//*********config.getEnvironments gets all the environment and from there get the QA environment 
		//********* get QA environment from all environment 
		
		//Environment environment = config.getEnvironments().get(env);
		//System.out.println(config.getEnvironments().get(env));
		//return environment.getUrl() ;

	//}

    public static Environment readJSON(Env env) {

        Gson gson = new Gson();
        File jsonfile = new File(System.getProperty("user.dir") + "\\config\\config.json");

        try (FileReader filereader = new FileReader(jsonfile)) {

            Config config = gson.fromJson(filereader, Config.class);

            // Convert enum to string key (QA, DEV, UAT)
            String envKey = env.name();

            Environment environment = config.getEnvironments().get(envKey);

            if (environment == null) {
                throw new RuntimeException("Environment '" + envKey + "' not found in config.json");
            }

            return environment;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read config.json", e);
        }
    }
}

