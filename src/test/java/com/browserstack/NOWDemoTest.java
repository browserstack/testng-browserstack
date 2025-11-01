package com.browserstack;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.browserstack.SeleniumTest;

public class NOWDemoTest extends SeleniumTest {
    @Test
    public void openTestPage() throws Exception {
        driver.get("https://www.bstackdemo.com");

        String webDomainFromEnv = System.getenv("NOW_WEB_DOMAIN");
        System.out.println("Web Domain from Env: " + webDomainFromEnv);
        Assert.assertTrue(driver.getPageSource().length() > 100);
        // Check the title.
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Assert.assertTrue(pageTitle.contains(webDomainFromEnv));
    }
}
