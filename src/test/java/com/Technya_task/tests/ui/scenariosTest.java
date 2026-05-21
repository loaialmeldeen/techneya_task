package com.Technya_task.tests.ui;

import com.Technya_task.tests.drivers.GUIDriver;
import com.Technya_task.tests.drivers.UITest;
import com.Technya_task.tests.pages.scenario1;
import com.Technya_task.tests.utils.dataReader.JsonReader;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@UITest
public class scenario1Test extends BaseTest {
    //Test
    @Test
    @Description("Verify that user can't login with valid but not registered email")
    public void test() {
        new scenario1(driver).navigate().clickOnAccountList()
                .enterEmail(testData.getJsonData("Email"))
                .clickOnContinue()
                .verify_LoggedIn_With_new_Email_Error_Message(testData.getJsonData("messages"));

    }
    @Test(priority = 1)
    @Description("")
    public void test2() {
        new scenario1(driver).navigate().clickOnTodayDeals().clickOnEndsTonight()
                .clickOnProduct().clickOnItem().clickOnAddToCart().verify_that_item_is_added_to_cart().clickOnGoToBasket()
                .clickOnPlusIcon();
    }

    @Test(priority = 2)
    public void test3() {
        new scenario1(driver).navigate().hoverOnHello().clickOnYourAddresses().verify_signin_is_exist();
    }

    @Test(priority = 3)
    public void test4() {
        new scenario1(driver).navigate().hoverOnHello().clickOnYourListes().verify_signin2_is_exist();
    }

    @Test(priority = 4)
    public void test5() {
        new scenario1(driver).navigate().hoverOnHello().clickOnYourOrders().verify_signin_is_exist();
    }

    //  configurations
    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("scenario1-data");
    }

    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
    }
}
