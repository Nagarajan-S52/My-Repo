package com.utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * Utility class for performing various actions using Selenium's Actions class.
 */
public class actionClassUtility {

    public WebDriver driver;
    public  Actions action;

    /**
     * Constructor to initialize WebDriver.
     */
    public actionClassUtility(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Clicks on the specified web element using the Actions class.
     */
    public void clickAction(WebElement element){
        // Initialize Actions instance with the current WebDriver
         action = new Actions(driver);

        // Perform click action on the specified element
         action.click(element);

        // Execute all actions that have been built
           action.perform();

    }
}
