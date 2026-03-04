package com.ui.pojo;

import java.util.Map;

//for Json file
public class Config {
	
	//DEV,QA,UAT --keys represented in string format 
    //we have stored key and value in the Map from JSON file
	// QA,DEV,UAT are keys stored as string , url is separate json object and stored in separate class as environments
	
	private Map<String,Environment> environments;

	public Map<String,Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String,Environment> environments) {
		this.environments = environments;
	} 
        
}



