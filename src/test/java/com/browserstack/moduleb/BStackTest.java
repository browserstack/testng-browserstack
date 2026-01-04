package com.browserstack.moduleb;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.Retry;
import com.browserstack.SeleniumTest;

public class BStackTest extends SeleniumTest {
    @Test(groups = "regression")
    public void flakyTest_intermittentlyPassesAndFails() throws Exception {
        String titleText = Math.random() < 0.5 ? "StackDemo" : "incorrect title";
        Assert.assertTrue(driver.getTitle().matches(titleText));
    }

    @Test
    public void alwaysFailingTest_sameStacktrace1() {
        driver.findElement(By.xpath("//*[@id=\"same-stacktrace\"]/div[4]")).click();
    }

    @Test
    public void alwaysFailingTest_sameStacktrace2() {
        driver.findElement(By.xpath("//*[@id=\"same-stacktrace\"]/div[4]")).click();
    }

    @Test
    public void alwaysPassingTest_exampleF() {
        Assert.assertTrue(true);
    }

    @Test(groups = "must_pass")
    public void alwaysPassingTest_exampleG() {
        Assert.assertTrue(true);
    }

    @Test
    public void alwaysPassingTest_exampleH() {
        Assert.assertTrue(true);
    }

    @Test
    public void alwaysPassingTest_exampleI() {
        Assert.assertTrue(true);
    }

    @Test
    public void alwaysPassingTest_verifyPageTitle() {
        Assert.assertEquals(driver.getTitle(), "StackDemo");
    }

    @Test
    public void alwaysPassingTest() {
        Assert.assertTrue(6 + 3 == 9);
    }

    @Test
    public void alwaysPassingTest_exampleB() {
        Assert.assertTrue(true);
    }

    @Test
    public void alwaysPassingTest_exampleC() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"regression", "p1"})
    public void alwaysPassingTest_exampleD() {
        Assert.assertTrue(true);
    }

    @Test
    public void alwaysPassingTest_exampleE() {
        Assert.assertTrue(true);
    }

    @Test(retryAnalyzer = Retry.class)
    public void testWithFrameworkLevelRetry_2RetriesConfigured() {
        String titleText = Math.random() > 0.7 ? "StackDemo" : "incorrect title";
        Assert.assertTrue(driver.getTitle().matches(titleText));
    }

    @Test(retryAnalyzer = Retry.class)
    public void anotherTestWithFrameworkLevelRetry_2RetriesConfigured() {
        String titleText = Math.random() > 0.7 ? "StackDemo" : "incorrect title";
        Assert.assertTrue(driver.getTitle().matches(titleText));
    }
}