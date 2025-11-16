package com.browserstack;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.browserstack.SeleniumTest;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NOWDemoTest extends SeleniumTest {
    @Test
    public void openTestPage() throws Exception {

        String content = new String(Files.readAllBytes(Paths.get("browserstack.yml")));
        System.out.println(content);
        
        String webEndpointFromEnv = System.getenv("CX_TEST_URL");
        System.out.println("CX_TEST_URL from Env: " + webEndpointFromEnv);
        driver.get(webEndpointFromEnv);

        Assert.assertTrue(driver.getPageSource().length() > 100);
    }
}
