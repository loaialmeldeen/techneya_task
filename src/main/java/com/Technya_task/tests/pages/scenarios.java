package com.Technya_task.tests.pages;

import com.Technya_task.tests.drivers.GUIDriver;
import com.Technya_task.tests.utils.dataReader.PropertyReader;
import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class scenario1 {
    private final GUIDriver driver;

    public scenario1(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By navLinkAccountList = By.id("nav-link-accountList");
    private final By email_field = By.id("ap_email_login");
    private final By continue_button = By.id("continue");
    private final By error_message = By.cssSelector(".a-size-medium-plus.a-spacing-small");
    private final By today_Deals = By.partialLinkText("Today's Deals");
    private final By endsTonight = By.id("discount-bubble-discounts-collection-deals-ending-today");
    private final By product = By.cssSelector("a[data-testid='product-card-link']");
    private final By item = By.xpath("//a[contains(@href,'/dp/B09HVCS4TM')]");
    private final By addToCart = By.id("add-to-cart-button");
    private final By plusOne = By.cssSelector("[data-action='a-stepper-increment']");
    private final By AddedToCartMessage = By.cssSelector(".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold");
    private final By goToBasketBtn = By.cssSelector(".a-button-text[href='/-/en/cart?ref_=sw_gtc']");
    private final By cart = By.cssSelector(".nav-cart-icon.nav-sprite");
    private final By plusIcon = By.cssSelector(".a-icon.a-icon-small-add");
    private final By itemPriceOut = By.cssSelector("body > div:nth-child(1) > div:nth-child(34) > div:nth-child(1) > div:nth-child(41) > div:nth-child(1) > div:nth-child(1) > div:nth-child(18) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ol:nth-child(1) > li:nth-child(2) > div:nth-child(2) > div:nth-child(6) > a:nth-child(1) > span:nth-child(1) > span:nth-child(2) > span:nth-child(2)");
    private final By productTitle = By.id("productTitle");
    private final By itemPriceIn = By.cssSelector("span[class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay apex-pricetopay-value'] span[class='a-price-whole']");
    private final By productPrice = By.cssSelector("span[aria-label='EGP 244.00'] span[class='a-price'] span span[name='symbolFirst'] span[class='a-price-whole']");
private final By HelleSignIn = By.id("nav-link-accountList");
private final By YourOrders = By.partialLinkText("Your Orders");
private final By yourAddress = By.partialLinkText("Your Addresses");
private final By yourLists = By.partialLinkText("Your Lists");
private final By signin = By.id("claim-collection-container");
    private final By signin2 = By.partialLinkText("Sign In");
    //Methods
    @Step("Navigate to Amazon URL")
    public scenario1 navigate() {
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseURL"));
        return this;
    }

    @Step("Click on Account List")
    public scenario1 clickOnAccountList() {
        driver.element().click(navLinkAccountList);
        return this;
    }

    @Step("Enter Email")
    public scenario1 enterEmail(String email) {
        driver.element().type(email_field, email);
        return this;
    }

    @Step("Click on Continue")
    public scenario1 clickOnContinue() {
        driver.element().click(continue_button);
        return this;
    }

    @Step("Click on Today's Deals")
    public scenario1 clickOnTodayDeals() {
        driver.element().click(today_Deals);
        return this;
    }

    @Step("Click on ends Tonight")
    public scenario1 clickOnEndsTonight() {
        driver.element().click(endsTonight);
        return this;
    }

    @Step("Click on Product")
    public scenario1 clickOnProduct() {
        driver.element().click(product);
        return this;
    }

    @Step("Click on Item")
    public scenario1 clickOnItem() {
        driver.element().click(item);
        return this;
    }

    @Step("Click on Add to Cart")
    public scenario1 clickOnAddToCart() {
        driver.element().click(addToCart);
        return this;
    }
    @Step("Click on Go to basket")
    public scenario1 clickOnGoToBasket() {
        driver.element().click(goToBasketBtn);
        return this;
    }
    @Step("Click on Plus Icon")
    public scenario1 clickOnPlusIcon() {
        driver.element().click(plusIcon);
        return this;
    }
    @Step("Click on Your Listes")
    public scenario1 clickOnYourListes() {
        driver.element().click(yourLists);
        return this;
    }
    @Step("Click on Your Orders")
    public scenario1 clickOnYourOrders() {
        driver.element().click(YourOrders);
        return this;
    }
    @Step("Click on Your Addresses")
    public scenario1 clickOnYourAddresses() {
        driver.element().click(yourAddress);
        return this;
    }
    @Step("Hover on Hello")
    public scenario1 hoverOnHello() {
        driver.element().hover(HelleSignIn);
        return this;
    }




    // assertions
    public scenario1 verify_LoggedIn_With_new_Email_Error_Message(String message) {
        String actualMessage = driver.element().getText(error_message);
        driver.hardAssertion().assertTrue(actualMessage.contains(message),
                "new email error message is not as expected");
        return this;
    }

    public scenario1 verify_that_item_is_added_to_cart() {
        String actualMessage = driver.element().getText(AddedToCartMessage);
        driver.hardAssertion().assertTrue(actualMessage.contains("Added to cart"),
                "Item is not added to cart");
        return this;
    }
    public scenario1 verify_signin_is_exist() {
        driver.element().findElement(signin);
        return this;
    }
    public scenario1 verify_signin2_is_exist() {
        driver.element().findElement(signin2);
        return this;
    }



}
