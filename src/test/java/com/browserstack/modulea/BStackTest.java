package com.browserstack.modulea;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.Retry;
import com.browserstack.SeleniumTest;

public class BStackTest extends SeleniumTest {
    @Test
    public void flakyTest_intermittentlyPassesAndFails() throws Exception {
        String titleText = Math.random() < 0.5 ? "StackDemo" : "incorrect title";
        Assert.assertTrue(driver.getTitle().matches(titleText));
    }

    @Test
    public void alwaysPassingTest_exampleF() {
        Assert.assertTrue(true);
    }

    @Test
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

    @Test(groups = "regression")
    public void alwaysPassingTest_exampleA() {
        Assert.assertTrue(true);
    }

    @Test
    public void alwaysFailingTest_missingElement1() {
        driver.findElement(By.xpath("//*[@id=\"missing\"]/div[4]")).click();
    }

    @Test(groups = "regression")
    public void alwaysFailingTest_sameStacktrace1() {
        driver.findElement(By.xpath("//*[@id=\"same-stacktrace\"]/div[4]")).click();
    }

    @Test
    public void alwaysFailingTest_sameStacktrace2() {
        driver.findElement(By.xpath("//*[@id=\"same-stacktrace\"]/div[4]")).click();
    }

    @Test
    public void passingTest_verifyPageTitle() {
        Assert.assertEquals(driver.getTitle(), "StackDemo");
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
