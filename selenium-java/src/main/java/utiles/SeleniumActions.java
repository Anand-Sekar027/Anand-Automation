package utiles;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class SeleniumActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest logger;

    public SeleniumActions(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            logger.log(Status.PASS, "Clicked element: " + locator.toString());
        } catch (Exception e) {
            logger.log(Status.FAIL, "Failed to click: " + locator.toString() + " | " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void type(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            logger.log(Status.PASS, "Typed into element: " + locator.toString() + " with text: " + text);
        } catch (Exception e) {
            logger.log(Status.FAIL, "Failed to type in element: " + locator.toString() + " | " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getText(By locator) {
        try {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
            logger.log(Status.PASS, "Got text from: " + locator.toString() + " => " + text);
            return text;
        } catch (Exception e) {
            logger.log(Status.FAIL, "Failed to get text from: " + locator.toString() + " | " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean isDisplayed(By locator) {
        try {
            boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
            logger.log(Status.PASS, "Element visible: " + locator.toString());
            return visible;
        } catch (TimeoutException e) {
            logger.log(Status.WARNING, "Element not visible (timeout): " + locator.toString());
            return false;
        } catch (Exception e) {
            logger.log(Status.FAIL, "Error checking visibility: " + locator.toString() + " | " + e.getMessage());
            return false;
        }
    }

    public void waitForElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.log(Status.PASS, "Waited for element: " + locator.toString());
        } catch (Exception e) {
            logger.log(Status.FAIL, "Failed to wait for element: " + locator.toString() + " | " + e.getMessage());
        }
    }
}

