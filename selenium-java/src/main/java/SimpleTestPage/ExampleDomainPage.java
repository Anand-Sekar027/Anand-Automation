package SimpleTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utiles.SeleniumActions;

public class ExampleDomainPage {

	private WebDriver driver;
	private SeleniumActions actions;
	private ExtentTest logger;
	//private SoftAssert softAssert;

	public ExampleDomainPage(WebDriver driver, ExtentTest logger) {
		 this.driver = driver;
		 this.logger = logger;
	     //this.softAssert = softAssert;

	     this.actions = new SeleniumActions(driver, logger);
	}
	
	public ExampleDomainPage goto_url(String url) {
		driver.get(url);
		return this;
	}
	
	 // Validate the page title with logging, exception handling, and soft assertion
    public void validatePageTitle(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            logger.info("Validating page title. Expected: " + expectedTitle + ", Actual: " + actualTitle);
            //softAssert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
            Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
            logger.pass("Page title validated successfully.");
        } catch (Exception e) {
            logger.log(Status.FAIL, "Exception while validating title: " + e.getMessage());
            Assert.fail("Exception thrown: " + e.getMessage());
        }
    }

    // Click on a link by XPath with logging and exception handling
    public void clickExampleLink(String xpath) {
        try {
        	By Xpath = By.id(xpath);
            logger.info("Attempting to click the link with XPath: " + xpath);
            actions.click(Xpath);
            logger.pass("Successfully clicked the link.");
        } catch (Exception e) {
            logger.log(Status.FAIL, "Failed to click element: " + e.getMessage());
            Assert.fail("Click operation failed: " + e.getMessage());
        }
    }

}
