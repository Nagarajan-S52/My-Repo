package com.pageobject;

import com.utilities.propertiesFileUtility;
import com.utilities.waitCommandUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
/**
 * Page Object Model (POM) class for the Login page.
 */
public class loginPage {
    public  WebDriver driver;
    public   SoftAssert softAssert;
    public propertiesFileUtility property;
    public  waitCommandUtility wait;

    /**
     * Constructor to initialize WebDriver and utilities.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.property = new propertiesFileUtility(driver);
        this.wait = new waitCommandUtility(this.driver);
    }

    // Locators for elements on the Login page
    private By mainLogin = By.linkText("Log in");
    private By UserNamefield = By.id("signInName");
    private By Passwordfield = By.id("password");
    private By Logininbutton = By.id("next");

    /**
     * Clicks on the main login link.
     */
    public void ClickMainLogin() {

        this.wait.explicitWaitForElementToBeLocated(mainLogin);
        driver.findElement(mainLogin).click();
    }

    /**
     * Enters the username in the username field.
     *
     * @param username The username to be entered.
     */
    public void setUsername(String username) {

        this.wait.explicitWaitForElementToBeLocated(UserNamefield);
        driver.findElement(UserNamefield).sendKeys(username);
    }


    /**
     * Enters the password in the password field.
     *
     * @param password The password to be entered.
     */

    public void setPassword(String password) {

        this.wait.explicitWaitForElementToBeLocated(Passwordfield);
        driver.findElement(Passwordfield).sendKeys(password);
    }

    /**
     * Clicks on the login button and verifies the title of the home page.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void ClickLoginbutton() throws IOException {

        this.wait.explicitWaitForElementToBeLocated(Logininbutton);
        // Click on the login button
        driver.findElement(Logininbutton).click();

        // Get the title of the home page
        String ActualHomePageTitle = driver.getTitle();

        // Assert that the actual home page title matches the expected title from the properties file
        this.softAssert.assertEquals(ActualHomePageTitle, this.property.getDataFromPropertyFile("ExpectedHomePageTitle"), "Home Page Tile Mismatch");


        // Perform all assertions
        this.softAssert.assertAll();
    }


}
