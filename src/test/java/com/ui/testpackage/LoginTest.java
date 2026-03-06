package com.ui.testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Browser.* ;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.Browserutility;


public class LoginTest {
		HomePage homePage;
		
@BeforeMethod(description=" Load the Homepage of the website")	

	public void setup() {
		homePage = new HomePage(CHROME);
		}
     

    // *************** Login using Json file 

	@Test(description = "Verifies with Valid user, is able to login into the application ", groups = {"e2e","sanity"},
			              dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestJsonDataProvider")
	
	public void loginJsonTest(User user) {		
		
	      //  String webText = homePage.doLoginwith("standard_user", "secret_sauce").getWebText();
	      //  Assert.assertEquals(webText,"Swag Labs");
		        // data passed directly without Testdata json	
			    //  assertEquals(homePage.doLoginwith("standard_user", "secret_sauce").getWebText(),"Swag Labs");
			    assertEquals(homePage.doLoginwith(user.getUserName(),user.getPassword(),user.getExpectedResult()).getWebText(),"Swag Labs");
			  
		}
	
	
    //*************** Login using CSV file

	@Test(description = "Verifies with Valid user, is able to login into the application ", groups = {"e2e","sanity"},
    dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestCSVDataProvider",
    retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)

	public void loginCSVTest(User user) {		
	      
		   // assertEquals(homePage.doLoginwith(user.getUserName(),user.getPassword().getExpectedResult()).getWebText(),"Swag Labs");
	  
	    String actualText = homePage.doLoginwith(user.getUserName(), user.getPassword(), user.getExpectedResult()).getWebText();

	    if (user.getExpectedResult().equalsIgnoreCase("PASS")) {

	        // Expect login to succeed
	        Assert.assertEquals(actualText,"Swag Labs","Expected login to succeed but it failed for user: " + user.getUserName());
	    }

	    else if (user.getExpectedResult().equalsIgnoreCase("FAIL")) {

	        // Expect login to fail
	        Assert.assertNotEquals(actualText,"Swag Labs","Expected login to fail but it succeeded for user: " + user.getUserName());
	    }
	}
		
		

	
	 //*************** Login using Excel file

		@Test(description = "Verifies with Valid user, is able to login into the application ", groups = {"e2e","sanity"},
	    dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestExcelDataProvider",
	    retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)

	//	public void loginExcelDataProvider(User user) {		
		
			// assertEquals(homePage.doLoginwith(user.getUserName(),user.getPassword()).getWebText(),"Swag Labs");
			 	
	//		     if (user.getExpectedResult().equalsIgnoreCase("PASS")) {
	//		    assertEquals(homePage.doLoginwith(user.getUserName(),user.getPassword(),user.getExpectedResult()).getWebText(),"Swag Labs");
	//		     }
	//		     else 
	//		    if (user.getExpectedResult().equalsIgnoreCase("FAIL")) {
	//		    	 Assert.assertNotEquals(null,user.getUserName(),user.getPassword(),user.getExpectedResult()).getWebText(),"Swag Labs");
	//		    }
			    
		//}
		
		public void loginExcelDataProvider(User user) {

		    String actualText = homePage.doLoginwith(user.getUserName(), user.getPassword(), user.getExpectedResult()).getWebText();

		    if (user.getExpectedResult().equalsIgnoreCase("PASS")) {

		        // Expect login to succeed
		        Assert.assertEquals(actualText,"Swag Labs","Expected login to succeed but it failed for user: " + user.getUserName());
		    }

		    else if (user.getExpectedResult().equalsIgnoreCase("FAIL")) {

		        // Expect login to fail
		        Assert.assertNotEquals(actualText,"Swag Labs","Expected login to fail but it succeeded for user: " + user.getUserName());
		    }
		}

}
