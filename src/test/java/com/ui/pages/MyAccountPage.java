package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.Browserutility;

public class MyAccountPage {
	
	private WebDriver driver;

    private static final By WEBNAME_LOCATOR = By.xpath("//div[text()='Swag Labs']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWebText() {
        return driver.findElement(WEBNAME_LOCATOR).getText();
    }


}
