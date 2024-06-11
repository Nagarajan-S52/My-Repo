package Com.BasePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

/**
 * Base utility class for setting up and tearing down WebDriver instances.
 */
public class BaseUtils {
    public WebDriver driver;

    public WebDriverUtility webDriverUtils = new WebDriverUtility();
    public WaitUtils wait;

    public BaseUtils() throws FileNotFoundException {
    }
    public PropertiesFileUtils properties = new PropertiesFileUtils(driver);
    /**
     * Method to open the browser and initialize WebDriver based on the browser specified in the properties file.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    @BeforeClass
    public void OpenBrowser() throws IOException {

        // Get the browser name from the properties file
        String browserName = this.properties.getDataFromPropertyFile("BrowserName");
        if (browserName.equals("chrome")) {
            this.driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            this.driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            this.driver = new EdgeDriver();
        } else if (browserName.equals("safari")) {
            this.driver= new SafariDriver();
        }
        // Maximize the browser window
        this.webDriverUtils.maximize(this.driver);

        // Initialize WaitUtils and set implicit wait
        this.wait = new WaitUtils(this.driver);
        this.wait.implicitWaitCommand();

        // Open the URL specified in the properties file
        driver.get(properties.getDataFromPropertyFile("url"));
    }
    /**
     * Method to close the browser and quit the WebDriver.
     */
@AfterClass
    public void CloseBrowser() {

        // Quit the WebDriver
        this.webDriverUtils.minimize(this.driver);
        driver.quit();
    }
}
