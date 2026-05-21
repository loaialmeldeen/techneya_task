package com.Techneya_task.tests.assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// Hard assertion
public class Hard extends BaseAssertions {
    public Hard(WebDriver driver) {
        super(driver);
    }
    public Hard(){
        super();
    }
    @Override
    public void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Override
    public void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    @Override
    public void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Override
    public void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }
}

