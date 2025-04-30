package utiles;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest logger;
    protected Logger log;

    @BeforeClass
    public void setUp() {
        log = LogManager.getLogger(this.getClass());
        log.info("Initializing WebDriver...");
        driver = DriverFactory.getDriver("chrome");

        log.info("Setting up ExtentReports...");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        logger = extent.createTest(this.getClass().getSimpleName());
        log.info("Test initialized: " + this.getClass().getSimpleName());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            log.info("Quitting WebDriver...");
            driver.quit();
        }
        log.info("Flushing ExtentReports...");
        extent.flush();
    }
}
