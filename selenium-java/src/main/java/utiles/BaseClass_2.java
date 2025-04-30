package utiles;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;

public class BaseClass_2 {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest logger;
   // protected SoftAssert softAssert;

    // Change this if you want to run on different browsers
    private String browser = "chrome";

    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        // Initialize driver via DriverFactory
        driver = DriverFactory.getDriver(browser);

        // Create a logger for the test method
        logger = extent.createTest(method.getName());

        // Initialize SoftAssert for each test
        //softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        // Collect soft assertion results
        //softAssert.assertAll();

        // Quit driver using DriverFactory
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}
