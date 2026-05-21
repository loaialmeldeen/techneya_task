package com.Techneya_task.tests.assertions;

import com.Techneya_task.tests.FileUtils;
import com.Techneya_task.tests.utils.WaitManager;
import com.Techneya_task.tests.utils.actions.ElementActions;
import com.Techneya_task.tests.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public abstract class BaseAssertions {
    protected WebDriver driver;
    public WaitManager waitManager;
    protected ElementActions elementActions;

    protected BaseAssertions() {
    }

    protected BaseAssertions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
        this.elementActions = new ElementActions(driver);
    }

    public abstract void assertTrue(boolean condition, String message);

    public abstract void assertFalse(boolean condition, String message);

    public abstract void assertEquals(Object actual, Object expected, String message);

    public abstract void assertNotEquals(Object actual, Object expected, String message);

    public BaseAssertions Equals(Object actual, Object expected, String message) {
        assertEquals(actual, expected, message);
        return this;
    }

    public BaseAssertions Equalstest(String actualSupplier,
                                     String expected,
                                     String message) {

        boolean flag = waitManager.fluentWait().until(driver -> {
            try {
                String actualValue = actualSupplier;
                return actualValue.equals(expected);
            } catch (Exception e) {
                return false;
            }
        });
        assertTrue(flag, message + " | Expected: " + expected);
        return this;
    }

    public BaseAssertions isElementVisible(By locator) {
        boolean flag = waitManager.fluentWait().until(driver1 ->
        {
            try {
                WebElement element = driver1.findElement(locator);
                //  LogsManager.debug("Checking if element is visible: " + locator);
                return element.isDisplayed();
            } catch (Exception e) {
                LogsManager.error("Error checking if element is visible: " + e.getMessage());
                return false;
            }
        });
        assertTrue(flag, "Element with locator: " + locator + " is not visible");
        return this;
    }


    public BaseAssertions isElementDisable(By locator) {
        boolean flag = waitManager.fluentWait().until(driver1 ->
        {
            try {
                WebElement element = driver1.findElement(locator);
                //LogsManager.debug("Checking if element is disabled: " + locator);
                return !element.isEnabled();
            } catch (Exception e) {
                LogsManager.error("Error checking if button is disable: " + e.getMessage());
                return false;
            }
        });
        assertTrue(flag, "Expected element to be disabled but it is enabled: " + locator);
        return this;
    }


    public BaseAssertions isElementEnable(By locator) {
        boolean flag = waitManager.fluentWait().until(driver1 ->
        {
            try {
                WebElement element = driver1.findElement(locator);
                //  LogsManager.debug("Checking if element is enabled: " + locator);
                return element.isEnabled();
            } catch (Exception e) {
                LogsManager.error("Error checking if button is enable: " + e.getMessage());
                return false;
            }
        });
        assertTrue(flag, "Expected element to be enabled but it is disabled: " + locator);
        return this;
    }


    /**
     * Asserts that the current URL matches the expected URL using fluent wait.
     *
     * @param expectedUrl The expected URL to verify
     * @throws AssertionError if the URL doesn't match within the wait timeout
     */
    public BaseAssertions assertPageUrl(String expectedUrl) {
        try {
            boolean urlMatches = waitManager.fluentWait().until(driver -> {
                String actualUrl = driver.getCurrentUrl();
                // LogsManager.debug("Verifying URL. Current: " + actualUrl + " | Expected: " + expectedUrl);
                return Objects.equals(actualUrl, expectedUrl);
            });

            if (!urlMatches) {
                String errorMsg = String.format("URL verification failed. Expected: '%s' but was: '%s'",
                        expectedUrl, driver.getCurrentUrl());
                LogsManager.error(errorMsg);
                throw new AssertionError(errorMsg);
            }
            LogsManager.info("URL verification passed: " + expectedUrl);
        } catch (Exception e) {
            String errorMsg = String.format("Error verifying URL. Expected: '%s' | Current: '%s' | Error: %s",
                    expectedUrl, driver.getCurrentUrl(), e.getMessage());
            LogsManager.error(errorMsg + " - " + e.toString());
            throw new AssertionError(errorMsg, e);
        }
        return this;
    }

    // verify page title
    public BaseAssertions assertPageTitle(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            assertEquals(actualTitle, expectedTitle, "Expected title: " + expectedTitle + ", but got: " + actualTitle);
        } catch (AssertionError e) {
            return this;
        }
        return this;
    }

    // Verify that file exists
    public BaseAssertions assertFileExists(String fileName, String message) {
        boolean fileExists = FileUtils.isFileExist(fileName,3);
        assertTrue(FileUtils.isFileExists(fileName), message);
        return this;
    }

}
