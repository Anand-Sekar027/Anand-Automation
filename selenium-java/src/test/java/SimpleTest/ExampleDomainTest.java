package SimpleTest;

import org.testng.annotations.Test;
import SimpleTestPage.ExampleDomainPage;
import utiles.BaseClass_2;

public class ExampleDomainTest extends BaseClass_2 {

    @Test
    public void testExampleDomain() {
        driver.get("https://example.com");

		ExampleDomainPage page = new ExampleDomainPage(driver, logger);
        page.validatePageTitle("Example Domain");
    }
    
    @Test
    public void testExampleDomain_2() {
        driver.get("https://example.com");

		ExampleDomainPage page = new ExampleDomainPage(driver, logger);
        page.validatePageTitle("Example Domain");
        page.clickExampleLink("//a[text()='More information...']");
    }
}