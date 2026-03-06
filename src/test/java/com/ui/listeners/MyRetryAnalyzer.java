package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


// This is called only when test is failing 
public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	private static final int MAX_NO_ATTEMPTS = 3;
	private static int currentAttempts = 1;

	@Override
	public boolean retry(ITestResult result) {
		//ITestResult provides information about failed Test 
		if(currentAttempts<=MAX_NO_ATTEMPTS){
			currentAttempts++;
			return true;
		}
		return false;
	}

}
