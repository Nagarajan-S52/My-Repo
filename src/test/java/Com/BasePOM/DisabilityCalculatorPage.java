package Com.BasePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;

/**
 * Page Object Model (POM) class for the Disability Calculator Page.
 */
public class DisabilityCalculatorPage {
    public WebDriver driver;

    SoftAssert softAssert;
    PropertiesFileUtils properties;
    Select select;
    PageScrolling scroll;
    ActionClassUtils action;
    WaitUtils wait ;

    /**
     * Constructor to initialize the driver and utilities.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public DisabilityCalculatorPage(WebDriver driver) {

        this.driver = driver;
        this.properties = new PropertiesFileUtils(driver);
        this.softAssert = new SoftAssert();
        this.wait = new WaitUtils(this.driver);
    }

    // Locators for elements on the Disability Calculator Page
    private By payrateDropdown = By.id("payrate");
    private By monthlyTFP = By.name("mtfp");
    private By monthlyMBE = By.id("pde");

    /**
     * Method to calculate MBE field value and verify it.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void calculateMBEiledValue() throws IOException {

        // Select the pay rate from the dropdown
        this.wait.explicitWaitForElementToBeLocated(payrateDropdown);
        WebElement payratefield = driver.findElement(payrateDropdown);
        select = new Select(payratefield);
        select.selectByIndex(11);

        // Get and parse the selected pay rate
        WebElement selectedOption = select.getFirstSelectedOption();
        String payrateText = selectedOption.getText().replace("$", ""); // Remove currency symbol
        double finalPayRate = Double.parseDouble(payrateText);

        // Get and parse the monthly TFP value
        String TfpValue = driver.findElement(monthlyTFP).getAttribute("value");
        double finalTfpValue = Double.parseDouble(TfpValue);

        // Get and parse the MBE value
        String mblValue = driver.findElement(monthlyMBE).getAttribute("value").replace("$", "").replace(",", "");
        double aResult = Double.parseDouble(mblValue);

        // Calculate expected value and round both actual and expected values
        double Actual = Math.round(aResult * 100D) / 100D;
        double expected = Math.round(finalPayRate * finalTfpValue * 100D) / 100D;

        // Assert that the calculated value matches the actual value
        softAssert.assertEquals(expected, Actual, "Value Mismatch");
        softAssert.assertAll();
    }

    // Locators for elements on the Disability Calculator Page
    private By sickBank = By.id("sickbank");
    private By CalculateButton = By.xpath("//button[text()='Calculate']");
    private By sickuseDropdown = By.xpath("//select[@name=\"sickuse\"]");
    private By tSickBankTd1 = By.xpath("(//div[@class=\"swapatable-container\"])/../div/table/tbody/tr[1]/td[2]");
    private By tSickBankTd2 = By.xpath("(//div[@class=\"swapatable-container\"])/../div/table/tbody/tr[2]/td[2]");
    private By tSickBankTd3 = By.xpath("(//div[@class=\"swapatable-container\"])/../div/table/tbody/tr[3]/td[2]");

    /**
     * Method to calculate the sick bank TPF filed value and verify it.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void calculateSickBankTpfValue() throws IOException {

        // Set the sick bank value
        this.wait.explicitWaitForElementToBeLocated(sickBank);
        WebElement findSickBank = driver.findElement(sickBank);
        findSickBank.clear();
        findSickBank.sendKeys(properties.getDataFromPropertyFile("sickBank"));
        String valueInSickBank = findSickBank.getAttribute("value");
        double finalSickBankValue = Double.parseDouble(valueInSickBank);

        // Set the monthly TFP value
        this.wait.explicitWaitForElementToBeLocated(monthlyTFP);
        WebElement findMonthlyTFP = driver.findElement(monthlyTFP);
        findMonthlyTFP.clear();
        findMonthlyTFP.sendKeys(properties.getDataFromPropertyFile("monthlyTFP"));
        String valueInMonthlyTFP = findMonthlyTFP.getAttribute("value");
        double finalMonthlyTFPValue = Double.parseDouble(valueInMonthlyTFP);

        // Select the sick use value from the dropdown
        action = new ActionClassUtils(driver);
        WebElement sickuse = driver.findElement(sickuseDropdown);
        action.clickAction(sickuse);
        select = new Select(sickuse);
        select.selectByVisibleText("30");

        // Get and parse the selected sick use value
        WebElement selectedOption = select.getFirstSelectedOption();
        String sickuseText = selectedOption.getText();
        double finalSickUse = Double.parseDouble(sickuseText);

        // Click the Calculate button
        this.wait.explicitWaitForElementToBeLocated(CalculateButton);
        driver.findElement(CalculateButton).click();

        // Scroll down the page to view the results
        scroll = new PageScrolling(driver);
        scroll.setScroll300();

        // Calculate and verify the values in the sick bank table
        String sickBankEndColumn01 = driver.findElement(tSickBankTd1).getText().replace(",", "");
        double sickBankEndColumn01Actual = Double.parseDouble(sickBankEndColumn01);
        double sickBankEndColumn01Expected = finalSickBankValue - finalMonthlyTFPValue;

        String sickBankEndColumn02 = driver.findElement(tSickBankTd2).getText().replace(",", "");
        double sickBankEndColumn02Actual = Double.parseDouble(sickBankEndColumn02);
        double sickBankEndColumn02Expected = sickBankEndColumn01Expected - finalMonthlyTFPValue;

        String sickBankEndColumn03 = driver.findElement(tSickBankTd3).getText().replace(",", "");
        double sickBankEndColumn03Actual = Double.parseDouble(sickBankEndColumn03);
        double sickBankEndColumn03Expected = sickBankEndColumn02Expected - finalSickUse;

        // Assert that the calculated values match the actual values
        this.softAssert.assertEquals(sickBankEndColumn01Actual, sickBankEndColumn01Expected, "sickBankEndColumn01 Value mismatch");
        this.softAssert.assertEquals(sickBankEndColumn02Actual, sickBankEndColumn02Expected, "sickBankEndColumn02 Value mismatch");
        this.softAssert.assertEquals(sickBankEndColumn03Actual, sickBankEndColumn03Expected, "sickBankEndColumn03 Value mismatch");
        this.softAssert.assertAll();
    }

}
