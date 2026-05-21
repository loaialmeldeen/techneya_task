package com.Techneya_task.tests.media;

import com.Techneya_task.tests.utils.logs.LogsManager;
import com.Techneya_task.tests.utils.TimeManager;
import com.Techneya_task.tests.utils.reports.AllureAttachmentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class ScreenshotsManager {
    public static String SCREENSHOTS_PATH = "test-output/screenshots/";

    public static void takeFullPageScreenshot(WebDriver driver, String screenshotName) {
        // Implementation for taking a full-page screenshot
        try {
            File screenshotsSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(
                    SCREENSHOTS_PATH + screenshotName + "-" + TimeManager.getTimestamp() + ".png");
            FileUtils.copyFile(screenshotsSrc, screenshotFile);
            AllureAttachmentManager.attachScreenshot(screenshotName, screenshotFile.getAbsolutePath());
            LogsManager.info("capturing screenshot succeeded");
        } catch (Exception e) {
            LogsManager.error("capturing screenshot failed: " + e.getMessage());
        }
    }

    // TAKE ELEMENT SCREENSHOT
    public static void takeElementScreenshot(WebDriver driver, String screenshotName, By elementSelector) {
        // Implementation for taking an element screenshot
        try {
            String ariaName = driver.findElement(elementSelector).getAccessibleName();
            File screenshotsSrc = driver.findElement(elementSelector).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + ariaName + "-" + TimeManager.getTimestamp() + ".png");
            FileUtils.copyFile(screenshotsSrc, screenshotFile);
            // Attach the screenshot to Allure report
            AllureAttachmentManager.attachScreenshot(screenshotName, screenshotFile.getAbsolutePath());
            LogsManager.info("capturing element screenshot succeeded");
        } catch (Exception e) {
            LogsManager.error("capturing element screenshot failed: " + e.getMessage());
        }
    }

}
