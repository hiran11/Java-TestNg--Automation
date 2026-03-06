package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> excelReader(String fileName)  {
		
		File xlsxfile;
		FileInputStream fis;
		XSSFWorkbook xssfworkbook = null;
		XSSFSheet xssfsheet;
		Row row ;
		Cell userEName;
		Cell userEpassword;
		User user;
		List<User> userList = new ArrayList<User>();
		
		try {
			
			xlsxfile = new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
			// FileInputStream is required for XSSFWorkbook
		    fis = new FileInputStream(xlsxfile);
		    xssfworkbook = new XSSFWorkbook(fis);
		    xssfsheet = xssfworkbook.getSheet("Login Test Data");
			Iterator<Row> rowIterator = xssfsheet.iterator();
			rowIterator.next();//skip header
			
		while (rowIterator.hasNext()) {
				
				row = rowIterator.next();
				userEName = row.getCell(0);
				userEpassword = row.getCell(1);
				System.out.println(userEName.toString());
				System.out.println(userEpassword.toString());
				user = new User(userEName.toString(),userEpassword.toString());// mapping data from excel to POJO class User
				userList.add(user);
				                   	}
		
		        xssfworkbook.close();
		     }
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
				
			
		return userList.iterator();
		
	}

}

