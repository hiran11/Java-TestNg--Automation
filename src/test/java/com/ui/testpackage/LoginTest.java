package com.ui.testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Browser.* ;
import com.ui.pages.HomePage;
import com.utility.Browserutility;


public class LoginTest {
		HomePage homePage;
		
@BeforeMethod(description=" Load the Homepage of the website")	

	public void setup() {
		homePage = new HomePage(CHROME);
		}

	@Test(description = "Verifies with Valid user, is able to login into the application ", groups = {"e2e","sanity"})
	
	public void loginTest() {
		
      //  String webText = homePage.doLoginwith("standard_user", "secret_sauce").getWebText();
      //  Assert.assertEquals(webText,"Swag Labs");
		assertEquals(homePage.doLoginwith("standard_user", "secret_sauce").getWebText(),"Swag Labs");
	  

	}

}
