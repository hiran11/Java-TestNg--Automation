package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	
	
public static Iterator<User> readCSVFile(String fileName) {
    
	File csvFile = new File (System.getProperty("user.dir")+("//testData//"+fileName));
	FileReader fileReader = null;
	CSVReader csvfileReader = null;
	List<User> userList = null;
	String[] line; 
	
	try {
		fileReader = new FileReader(csvFile);
		csvfileReader = new CSVReader(fileReader);
		csvfileReader.readNext();// Reading Column names Row1  and to skip the column we have this readNext   
		//	csvfileReader.readNext();// Reading column 2 values 
	//	csvfileReader.readNext();// Reading column 3 values 
	//	data = csvfileReader.readNext();// Reading column 4 values 
		
		
		userList = new ArrayList<User>();
				
		while((line= csvfileReader.readNext())!= null) {
			User userData = new User(line[0],line[1],line[2]);
			userList.add(userData);
		}
		
		for (User userDatalist : userList) {
			
			System.out.println(userDatalist.toString());
		}
				
	}	

	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	catch (CsvValidationException e) {
		e.printStackTrace();
	} 
	
	catch (IOException e) {
		e.printStackTrace();
	}    
	
	return userList.iterator();
}}
	
	


