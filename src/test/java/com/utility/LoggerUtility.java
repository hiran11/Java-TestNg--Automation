package com.utility;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.*;

public class LoggerUtility {
	
	
	private static Logger logger;

	public LoggerUtility() {
		super();
	}
	
	public static Logger  getLoggerUtility(Class<?>clazz) {
		
		if(logger==null) {
		
		logger = (Logger) LogManager.getLogger(clazz);
		
		}
		
		return logger;
		
	}
	

}
