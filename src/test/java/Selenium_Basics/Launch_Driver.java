package Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_Driver {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("running");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/in/anand-s-565bb220b/");
		
		System.out.println("The end");
		
	}

}
