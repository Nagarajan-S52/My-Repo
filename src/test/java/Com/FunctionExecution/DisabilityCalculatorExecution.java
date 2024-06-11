package Com.FunctionExecution;

import Com.BasePOM.BaseUtils;
import Com.BasePOM.DisabilityCalculatorPage;
import Com.BasePOM.LoginPage;
import Com.BasePOM.swapaHomePage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Test class to execute disability calculator related tests.
 */
public class DisabilityCalculatorExecution extends BaseUtils {

    // Initialize the DisabilityCalculatorPage instance
    DisabilityCalculatorPage disability = new DisabilityCalculatorPage(driver);;

    /**
     * Constructor to initialize BaseUtils.
     *
     * @throws FileNotFoundException If the properties file is not found.
     */
    public DisabilityCalculatorExecution() throws FileNotFoundException {
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
        LoginPage login = new LoginPage(driver);
        // Perform login
        login.ClickMainLogin();
        login.setUsername(properties.getDataFromPropertyFile("username"));
        login.setPassword(properties.getDataFromPropertyFile("password"));
        login.ClickLoginbutton();

        // Instantiate swapaHomePage
        swapaHomePage home = new swapaHomePage(driver);
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
    disability = new DisabilityCalculatorPage(driver);
        // Calculate and verify monthly MBE value
        disability.calculateMBEiledValue();
    }
    /**
     * Test case to verify sick bank TPF value calculation.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    @Test(priority = 3)
    public void validateSickBankTpf() throws IOException {
        // Recreate DisabilityCalculatorPage instance
        disability = new DisabilityCalculatorPage(driver);
        // Calculate and verify sick bank TPF value
        disability.calculateSickBankTpfValue();
    }


}
