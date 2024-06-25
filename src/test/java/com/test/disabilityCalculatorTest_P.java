package com.test;

import com.baseclass.baseClass;
import com.pageobject.disabilityCalculatorPage;
import com.pageobject.loginPage;
import com.pageobject.homePage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Test class to execute disability calculator related tests.
 */
public class disabilityCalculatorTest_P extends baseClass {

    // Initialize the DisabilityCalculatorPage instance
    disabilityCalculatorPage disability = new disabilityCalculatorPage(driver);;

    /**
     * Constructor to initialize BaseUtils.
     *
     * @throws FileNotFoundException If the properties file is not found.
     */
    public disabilityCalculatorTest_P() throws FileNotFoundException {
    }

    /**
     * Test case to perform login.
     *
     * @throws IOException If there is an error reading from the properties file.
     *
     * Test case to navigate to the disability calculator and verify the page.
     */
    @Test(priority = 1)
    public void navigateToDisabilityCalculator() throws IOException {
        // Instantiate LoginPage
        loginPage login = new loginPage(driver);
        // Perform login
        login.ClickMainLogin();
        login.setUsername(properties.getDataFromPropertyFile("username"));
        login.setPassword(properties.getDataFromPropertyFile("password"));
        login.ClickLoginbutton();

        // Instantiate swapaHomePage
        homePage home = new homePage(driver);
        // Click on Resources
        home.clickResources();
        // Click on Calculators
        home.clickCalculators();
        // Click on Disability Calculator and verify the page
        home.clickDisabilityCalculator();

    }
    /**
     * Test case to verify monthly MBE value calculation.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    @Test(priority = 2,enabled = true)
    public void validateMonthlyMbe() throws IOException {
        // Recreate DisabilityCalculatorPage instance
    disability = new disabilityCalculatorPage(driver);
        // Calculate and verify monthly MBE value
        disability.calculateMBEfiledValue();
    }
    /**
     * Test case to verify sick bank TPF value calculation.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    @Test(priority = 3)
    public void validateSickBankTpf() throws IOException {

        // Recreate DisabilityCalculatorPage instance
      //  disability = new DisabilityCalculatorPage(driver);
        // Calculate and verify sick bank TPF value
        disability.calculateSickBankTpfValue();
    }




}
