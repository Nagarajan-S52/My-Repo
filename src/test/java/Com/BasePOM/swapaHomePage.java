package Com.BasePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
/**
 * Page Object Model (POM) class for the SWAPA Home page.
 */
public class swapaHomePage {

    WebDriver driver;
    SoftAssert softAssert;
    PropertiesFileUtils property;
    WaitUtils wait ;
    public swapaHomePage(WebDriver driver) {
        /**
         * Constructor to initialize WebDriver and utilities.
         *
         * @param driver The WebDriver instance.
         */
        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.property = new PropertiesFileUtils(driver);
        this.wait = new WaitUtils(this.driver);
    }

    // Locator for the 'Resources' link
    private By resources = By.xpath("//span[text() = 'Resources']");
    /**
     * Clicks on the 'Resources' link.
     */
    public void clickResources() {
        // Wait for the 'Resources' link to be located
        this.wait.explicitWaitForElementToBeLocated(resources);
        // Click on the 'Resources' link
        driver.findElement(resources).click();
    }

    // Locator for the 'SRC Forms' link
    private By SrcForms = By.xpath("(//a[contains(text(),'SRC')])[1]");
    /**
     * Clicks on the 'SRC Forms' link.
     */
    public void clickSRC_Forms() {

        // Wait for the 'SRC Forms' link to be located
        this.wait.explicitWaitForElementToBeLocated(SrcForms);
        // Click on the 'SRC Forms' link
        driver.findElement(SrcForms).click();
    }

    // Locator for the 'Pilot Polling Form' link
    private By PilotPollingForm = By.xpath("(//a[contains(text(),'Pilot')])[3]");
    /**
     * Clicks on the 'Pilot Polling Form' link and verifies the page title.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void clickPilotPollingForm() throws IOException {
        // Wait for the 'PilotPollingForm' link to be located
        this.wait.explicitWaitForElementToBeLocated(PilotPollingForm);
        // Click on the 'Pilot Polling Form' link
        driver.findElement(PilotPollingForm).click();
        // Verify the page title
        String ActualPilotPollingFormPageTitle = driver.getTitle();
        this.softAssert.assertEquals(ActualPilotPollingFormPageTitle, this.property.getDataFromPropertyFile("ExceptedPilotPollingFormPageTitle"), "Home Page Tile Mismatch");
        this.softAssert.assertAll();

    }
    // Locator for the 'Calculators' link
    private By Calculators = By.linkText("Calculators");
    /**
     * Clicks on the 'Calculators' link.
     */
    public void clickCalculators() {
        // Wait for the 'Calculators' link to be located
        this.wait.explicitWaitForElementToBeLocated(Calculators);
        // Click on the 'Calculators' link
        driver.findElement(Calculators).click();
    }

    // Locator for the 'Disability Calculator' link
    private By DisabilityCalculator = By.xpath("(//a[contains(text(),'Calculators')])[1]/../div[3]/a[3]");
    /**
     * Clicks on the 'Disability Calculator' link and verifies the page title.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void clickDisabilityCalculator() throws IOException {
        // Wait for the 'DisabilityCalculator' link to be located
        this.wait.explicitWaitForElementToBeLocated(DisabilityCalculator);
        // Click on the 'Disability Calculator' link
        driver .findElement(DisabilityCalculator).click();
        // Verify the page title
        String ActualDisabilityCalculatorPageTitle = driver.getTitle();
        this.softAssert.assertEquals(ActualDisabilityCalculatorPageTitle, this.property.getDataFromPropertyFile("ExceptedDisabilityCalculatorPageTitle"), "Disability Calculator Page Tile Mismatch");
        this.softAssert.assertAll();
    }
}
