package com.Techneya_task.tests.utils.actions;

import com.Techneya_task.tests.utils.WaitManager;
import com.Techneya_task.tests.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {
    private WebDriver driver;
    private WaitManager waitManager;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    // Clicking
    public ElementActions click(By locator) {
        waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                // Wait until the element is stable (not moving)
                Point initialLocation = element.getLocation();
                LogsManager.info("initialLocation: " + initialLocation);
                Point finalLocation = element.getLocation();
                LogsManager.info("finalLocation: " + finalLocation);
                if (!initialLocation.equals(finalLocation)) {
                    return false; // still moving, wait longer
                }
                element.click();
                LogsManager.info("Clicked on element: " + locator);
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to click on element: " + locator, e.getMessage());
                return false;
            }
        });
        return this;
    }

    // Typing
    public ElementActions type(By locator, String text) {
        waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                // new Actions(d).scrollToElement(element);
                element.clear();
                element.sendKeys(text);
                LogsManager.info("Typed text '", text, "' into element: ", locator.toString());
                return true;
            } catch (Exception e) {
                return false;
            }
        });
        return this;
    }

    // Hovering
    public ElementActions hover(By locator) {
        waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                new Actions(d).moveToElement(element).perform();
                LogsManager.info("Hovered over element: " + locator);
                return true;
            } catch (Exception e) {
                // LogsManager.error("Failed to click on element: " + locator, e.getMessage());
                return false;
            }
        });
        return this;
    }

    // Getting text
    public String getText(By locator) {
        return waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                String msg = element.getText();
                LogsManager.info("Retrieved text from element: " + locator + " Text: " + msg);
                return !msg.isEmpty() ? msg : null;
            } catch (Exception e) {
                return null;
            }
        });

    }

    // find an element
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // function to scroll to an element using js
    public void scrollToElementJS(By locator) {
        WebElement element = driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("""
                        arguments[0].scrollIntoView({behaviour:"auto",block:"center",inline:"center"});""",
                        findElement(locator));
    }

    // upload file
    public ElementActions uploadFile(By locator, String filePath) {
        String fillAbsolute = System.getProperty("user.dir") + filePath;
        waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.sendKeys(fillAbsolute);
                LogsManager.info("Uploaded file '", fillAbsolute, "' to element: ", locator.toString());
                return true;
            } catch (Exception e) {
                return false;
            }
        });
        return this;
    }

    // select from dropdown
    public ElementActions selectFromDropdown(By locator, String value) {
        waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                Select select = new Select(element);
                select.selectByVisibleText(value);
                LogsManager.info("Selected value '" + value + "' from dropdown: " + locator);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
        return this;
    }

    private boolean isElementNotClickableResult;

    public ElementActions isElementNotClickable(By locator) {
        waitManager.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);

                boolean enabled = element.isEnabled();
                boolean displayed = element.isDisplayed();
                String pointerEvents = element.getCssValue("pointer-events");

                boolean notClickable = !enabled || !displayed || "none".equals(pointerEvents);

                LogsManager.info("Element NOT clickable for " + locator + " = " + notClickable);
                return notClickable;
            } catch (Exception e) {
                return false;
            }
        });
        return this;
    }

}

