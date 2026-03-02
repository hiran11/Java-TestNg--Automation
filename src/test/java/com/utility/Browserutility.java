package com.utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.constants.Browser;

public abstract class Browserutility {
	
	protected WebDriver driver;

	public void goToWebsite(String url) {
		getDriver().get(url);// launch website
	}
	
	public void maximizeWindow() {
		getDriver().manage().window().maximize();
		
	}
	
	public Browserutility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            
        } else if (browserName.equalsIgnoreCase("edge")) {
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--incognito");
            driver = new EdgeDriver(options);
        } 
         else if (browserName.equalsIgnoreCase("firefox")) {
        	 FirefoxProfile profile = new FirefoxProfile();

        	// Disable password manager & breach alerts
        	profile.setPreference("signon.rememberSignons", false);
        	profile.setPreference("signon.autofillForms", false);
        	profile.setPreference("signon.generation.enabled", false);
        	profile.setPreference("signon.management.page.breach-alerts.enabled", false);

        	// Disable autofill
        	profile.setPreference("extensions.formautofill.creditCards.enabled", false);
        	profile.setPreference("extensions.formautofill.addresses.enabled", false);

        	// Private browsing
        	profile.setPreference("browser.privatebrowsing.autostart", true);

        	FirefoxOptions options = new FirefoxOptions();
        	options.setProfile(profile);
        	driver = new FirefoxDriver(options);
         }
        else {
            throw new RuntimeException("Invalid browser name");
        }
    }
     
	public Browserutility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            
        } else if (browserName == Browser.EDGE) {
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--incognito");
            driver = new EdgeDriver(options);
        } 
         else if (browserName == Browser.FIREFOX) {
        	 FirefoxProfile profile = new FirefoxProfile();

        	// Disable password manager & breach alerts
        	profile.setPreference("signon.rememberSignons", false);
        	profile.setPreference("signon.autofillForms", false);
        	profile.setPreference("signon.generation.enabled", false);
        	profile.setPreference("signon.management.page.breach-alerts.enabled", false);

        	// Disable autofill
        	profile.setPreference("extensions.formautofill.creditCards.enabled", false);
        	profile.setPreference("extensions.formautofill.addresses.enabled", false);

        	// Private browsing
        	profile.setPreference("browser.privatebrowsing.autostart", true);

        	FirefoxOptions options = new FirefoxOptions();
        	options.setProfile(profile);
        	driver = new FirefoxDriver(options);
         }
      }

	public void clickOn(By locator) {
		WebElement element = getDriver().findElement(locator);
	    element.click();
	}
	
	public void enterText(By locator,String textToEnter) {
		WebElement element = getDriver().findElement(locator);
	    element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		WebElement element = getDriver().findElement(locator);
	    return element.getText();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
