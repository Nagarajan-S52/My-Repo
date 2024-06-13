package com.pageobject;

import com.utilities.propertiesFileUtility;
import com.utilities.randomProgramUtillity;
import com.utilities.waitCommandUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

/**
 * Page Object Model (POM) class for the Pilot Polling Form page.
 */
public class pilotPollingFormPage {
    WebDriver driver;
    SoftAssert softAssert;
    propertiesFileUtility property;
    waitCommandUtility wait;
    /**
     * Constructor to initialize WebDriver and utilities.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public pilotPollingFormPage(WebDriver driver) {

        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.property = new propertiesFileUtility(driver);
        this.wait = new waitCommandUtility(this.driver);
    }

    // Locators for elements on the Pilot Polling Form page
    private By Question1 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[1]/../div/label");
    private By Question2 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[2]/../div/label");
    private By Question3 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[3]/../div/label");
    private By Question4 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[4]/../div/label");
    private By Question5 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[5]/../div/label");
    private By Question6 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[6]/../div/label");
    private By Question7 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[7]/../div/label");
    private By Question8 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[8]/../div/label");
    private By Question9 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[9]/../div/label");
    private By Question10 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[10]/../div/label");
    private By Question11 = By.xpath("(//span[@class=\"Form__Element__Caption\"])[11]/../div/label");
    private By SubmitButton = By.name("submit");
    private By successfullMessage = By.xpath("//div[contains(@class,\"Form__Status__Message\")]");

    /**
     * Selects an option for Question 1.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion1() throws InterruptedException {
        // Find all elements matching Question1 locator
        List<WebElement> q1 = driver.findElements(Question1);

        // If no elements found, throw IllegalStateException
        if (q1.isEmpty()) {
            throw new IllegalStateException("No elements found for Question1");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();

        // Get a random WebElement from the list of Question 1 options
        WebElement radiobutton = q1.get(getrandom.randamValue(q1.size()));

        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }
    /**
     * Selects an option for Question 2.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion2() throws InterruptedException {
        // Find all elements matching Question2 locator
        List<WebElement> q2 = driver.findElements(Question2);

        // If no elements found, throw IllegalStateException
        if (q2.isEmpty()) {
            throw new IllegalStateException("No elements found for Question2");
        }

        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();

        // Get a random WebElement from the list of Question 2 options
        WebElement radiobutton = q2.get(getrandom.randamValue(q2.size()));

        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 3.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion3() throws InterruptedException {
        // Find all elements matching Question3 locator
        List<WebElement> q3 = driver.findElements(Question3);
        // If no elements found, throw IllegalStateException
        if (q3.isEmpty()) {
            throw new IllegalStateException("No elements found for Question3");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 3 options
        WebElement radiobutton = q3.get(getrandom.randamValue(q3.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 4.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion4() throws InterruptedException {
        // Find all elements matching Question4 locator
        List<WebElement> q4 = driver.findElements(Question4);
        // If no elements found, throw IllegalStateException
        if (q4.isEmpty()) {
            throw new IllegalStateException("No elements found for Question4");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 4 options
        WebElement radiobutton = q4.get(getrandom.randamValue(q4.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 5.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion5() throws InterruptedException {
        // Find all elements matching Question5 locator
        List<WebElement> q5 = driver.findElements(Question5);
        // If no elements found, throw IllegalStateException
        if (q5.isEmpty()) {
            throw new IllegalStateException("No elements found for Question5");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 5 options
        WebElement radiobutton = q5.get(getrandom.randamValue(q5.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 6.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion6() throws InterruptedException {
        // Find all elements matching Question6 locator
        List<WebElement> q6 = driver.findElements(Question6);
        // If no elements found, throw IllegalStateException
        if (q6.isEmpty()) {
            throw new IllegalStateException("No elements found for Question6");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 6 options
        WebElement radiobutton = q6.get(getrandom.randamValue(q6.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 7.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion7() throws InterruptedException {
        // Find all elements matching Question7 locator
        List<WebElement> q7 = driver.findElements(Question7);
        // If no elements found, throw IllegalStateException
        if (q7.isEmpty()) {
            throw new IllegalStateException("No elements found for Question7");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 7 options
        WebElement radiobutton = q7.get(getrandom.randamValue(q7.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 8.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion8() throws InterruptedException {
        // Find all elements matching Question8 locator
        List<WebElement> q8 = driver.findElements(Question8);
        // If no elements found, throw IllegalStateException
        if (q8.isEmpty()) {
            throw new IllegalStateException("No elements found for Question8");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 8 options
        WebElement radiobutton = q8.get(getrandom.randamValue(q8.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 9.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion9() throws InterruptedException {
        // Find all elements matching Question9 locator
        List<WebElement> q9 = driver.findElements(Question9);
        // If no elements found, throw IllegalStateException
        if (q9.isEmpty()) {
            throw new IllegalStateException("No elements found for Question9");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 9 options
        WebElement radiobutton = q9.get(getrandom.randamValue(q9.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 10.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion10() throws InterruptedException {
        // Find all elements matching Question10 locator
        List<WebElement> q10 = driver.findElements(Question10);
        // If no elements found, throw IllegalStateException
        if (q10.isEmpty()) {
            throw new IllegalStateException("No elements found for Question10");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 10 options
        WebElement radiobutton = q10.get(getrandom.randamValue(q10.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Selects an option for Question 11.
     *
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void selectQuestion11() throws InterruptedException {
        // Find all elements matching Question11 locator
        List<WebElement> q11 = driver.findElements(Question11);
        // If no elements found, throw IllegalStateException
        if (q11.isEmpty()) {
            throw new IllegalStateException("No elements found for Question11");
        }
        // Create an instance of RandomProgramUtils to get a random value
        randomProgramUtillity getrandom = new randomProgramUtillity();
        // Get a random WebElement from the list of Question 11 options
        WebElement radiobutton = q11.get(getrandom.randamValue(q11.size()));
        // Wait for the radio button to be clickable
        this.wait.explicitWaitForElementToBeClickable(radiobutton);
        // Click the radio button
        radiobutton.click();
    }

    /**
     * Clicks on the Submit button and verifies the success message.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void SetSubmitButton() throws IOException {
        // Click the Submit button
        driver.findElement(SubmitButton).click();

        // Get the actual message text displayed after submitting
        String ActualmessageText = driver.findElement(successfullMessage).getText();
        // Compare the actual message text with the expected message text from the properties file
        this.softAssert.assertEquals(ActualmessageText, this.property.getDataFromPropertyFile("ExceptedMessageText"), "Success Message Mismatch");
        // Perform all assertions
        this.softAssert.assertAll();
    }

}

