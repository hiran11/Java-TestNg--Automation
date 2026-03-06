package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;


public class LoginDataProvider {
	
	// data read from JSON file 
	@DataProvider(name = "LoginTestJsonDataProvider") 
	public Iterator<Object[]> loginjsonDataProvider() throws FileNotFoundException {
		
		Gson gson = new Gson();
		File testDatafile = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		FileReader fileReader = new FileReader(testDatafile);
		
		//Map Json to Pojo
		TestData data = gson.fromJson(fileReader, TestData.class);// deserialization converting Json object to java class object
		
		// data from loginDatajson has to be returned in array list username,passord is the object 
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		
		for (User user: data.getData()) {
			
			dataToReturn.add(new Object[] {user});// get individual data and attach to arraylist 
		}
		
		return dataToReturn.iterator();
		
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public static Iterator<User> loginCSVDataProvider() {
		
		return CSVReaderUtility.readCSVFile("loginData.csv");
		
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public static Iterator<User> loginExcelDataProvider() {
		
		return ExcelReaderUtility.excelReader("loginData.xlsx");
		
	}

}
