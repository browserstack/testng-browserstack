package com.browserstack;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.browserstack.SeleniumTest;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.browserstack.v2.utils.BrowserStack; 


public class NOWDemoTest extends SeleniumTest {
    @Test
    public void openTestPage() throws Exception {
        BrowserStack.setCustomTag("ID", System.getenv().getOrDefault("BSTACK_NOW_WEB_TEST_ID", "TC-1"));
        String content = new String(Files.readAllBytes(Paths.get("browserstack.yml")));
        System.out.println(content);
        
        String webEndpointFromEnv = System.getenv().getOrDefault("CX_TEST_URL", "https://bstackdemo.com");
        System.out.println("CX_TEST_URL from Env: " + webEndpointFromEnv);
        driver.get(webEndpointFromEnv);

        Assert.assertTrue(driver.getPageSource().length() > 100);
    }
}
