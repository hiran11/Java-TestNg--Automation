package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.Browserutility;

public class HomePage extends Browserutility {

    private static final By LOGIN_LOCATOR = By.id("login-button");
    private static final By USERNAME_LOCATOR = By.id("user-name");
    private static final By PASSWORD_LOCATOR = By.id("password");

    public HomePage(Browser browserName) {
        super(browserName);
        goToWebsite("https://www.saucedemo.com/");
    }


    public MyAccountPage doLoginwith(String userName, String password) {
        enterText(USERNAME_LOCATOR, userName);
        enterText(PASSWORD_LOCATOR, password);
        clickOn(LOGIN_LOCATOR);
        return new MyAccountPage(getDriver());
    }

}