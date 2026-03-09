package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;


// This is called only when test is failing 
public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	
	//******************** default hard coded max no and current attempts for csv file 
	//private static final int MAX_NO_ATTEMPTS = 3;
	//private static int currentAttempts = 1;
	
	
	//******to read data from dev.properties file
	//private static final int MAX_NO_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NO_ATTEMPTS"));
	
	
	// ************ to read data from config.json file 
	private static final int MAX_NO_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NO_ATTEMPTS(); 
	private static int currentAttempts = 1;
	Throwable cause;

	@Override
	public boolean retry(ITestResult result) {
		//ITestResult provides information about failed Test 
		
	    cause = result.getThrowable();

	    // Retry only for Selenium-related failures
	    
	    if (cause instanceof org.openqa.selenium.TimeoutException ||
	        cause instanceof org.openqa.selenium.NoSuchElementException ||
	        cause instanceof org.openqa.selenium.StaleElementReferenceException) {
	    	
		if(currentAttempts<MAX_NO_ATTEMPTS){
			currentAttempts++;
			return true;
		}
	    }
		return false;
	}

}
