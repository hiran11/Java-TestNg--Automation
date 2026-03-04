package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.constants.Env;
import com.utility.Browserutility;
import com.utility.PropertiesUtil;

import static com.utility.PropertiesUtil.*;

public class HomePage extends Browserutility {

    private static final By USERNAME_LOCATOR = By.id("user-name");
    private static final By PASSWORD_LOCATOR = By.id("password");
    private static final By LOGIN_LOCATOR = By.id("login-button");

    public HomePage(Browser browserName) {
        super(browserName);
       // goToWebsite("https://www.saucedemo.com/");
       // goToWebsite(PropertiesUtil.readProperty(Env.QA,"URL"));
        goToWebsite(PropertiesUtil.readProperty(Env.QA,"URL"));
    }


    public MyAccountPage doLoginwith(String userName, String password) {
    	
        enterText(USERNAME_LOCATOR, userName);
        enterText(PASSWORD_LOCATOR, password);
        clickOn(LOGIN_LOCATOR);
        return new MyAccountPage(getDriver());
    }

}