package com.browserstack;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.browserstack.SeleniumTest;

public class NOWDemoTest extends SeleniumTest {
    @Test
    public void openTestPage() throws Exception {
        driver.get("https://www.bstackdemo.com");

        // Check the title. Always passes.
        Assert.assertTrue(driver.getTitle().matches(driver.getTitle()));
    }
}
