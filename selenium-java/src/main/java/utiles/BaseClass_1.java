package utiles;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.asserts.SoftAssert;

public class BaseClass_1 {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest logger;
    protected SoftAssert softAssert;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Your Name");
    }

    @BeforeMethod
    public void setupTest(Method method) {
        driver = new ChromeDriver();
        logger = extent.createTest(method.getName());
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
        softAssert.assertAll();  // Report all soft assertion failures
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
