package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import static stepDefinitions.Hooks.driver;
import static stepDefinitions.Hooks.width;

public class US069_StepDefs extends CommonPage {
    @And("User clicks Mark All As Read link")
    public void userClicksMarkAllAsReadLink() {
       try{ getOrdersPage().markAllAsReadLink.click();}catch (Exception e){
           e.printStackTrace();
       }
       BrowserUtilities.wait(1);
    }

    @And("User verifies that number on Notification Icon is {int}")
    public void userVerifiesThatNumberOnNotificationIconIs(int numberOnNotificationIcon) {

        Assert.assertEquals(numberOnNotificationIcon,getOrdersPage().markReadList.size());
    }
    @And("User clicks Add to Cart of last product")
    public void userClicksAddToCartOfLastProduct() {
      getWelcomePage().addCartButton.click();
      getEvent().alertCloseButton.click();
    }

    @Then("User clicks Number of Cart button")
    public void userClicksNumberOfCartButton() {
        getWelcomePage().numberOfCart.click();
    }

    @And("User clicks the Proceed To Checkout button")
    public void userClicksTheProceedToCheckoutButton() {
        getCartPage().proceedToCheckout.click();
    }

    @And("User verifies the next page opened.")
    public void userVerifiesTheNextPageOpened() {
        Assert.assertEquals("https://test.urbanicfarm.com/basket/proceed",driver.getCurrentUrl());
    }

    @And("User clicks Next-Previous button and verifies related page opened.")
    public void userClicksNextPreviousButtonAndVerifiesRelatedPageOpened() {
        getCartPage().nextButton.click();
        Assert.assertEquals("rgba(33, 37, 41, 1)", getCartPage().addressCycle.getCssValue("color"));
        getCartPage().nextButton.click();
        Assert.assertEquals("rgba(33, 37, 41, 1)", getCartPage().reviewCycle.getCssValue("color"));
        getCartPage().prevButton.click();
        Assert.assertEquals("rgba(33, 37, 41, 1)", getCartPage().addressCycle.getCssValue("color"));
        getCartPage().prevButton.click();
        Assert.assertEquals("rgba(33, 37, 41, 1)", getCartPage().informationCycle.getCssValue("color"));
    }

    @And("User clicks Go To Payment button and verifies related page opened.")
    public void userClicksGoToPaymentButtonAndVerifiesRelatedPageOpened() {
        getCartPage().nextButton.click();
        getCartPage().nextButton.click();
        BrowserUtilities.waitForPageToLoad(10);
        getCartPage().goToPaymentButton.click();
        BrowserUtilities.switchToWindow(1);
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals("PayPal",driver.getTitle());
    }

    @Then("User enters Payment Information")
    public void userEntersPaymentInformation() {
        getCartPage().loginPayPalButton.click();
        getCartPage().payPalEmailBox.sendKeys(Keys.END);
        BrowserUtilities.cleanTextInBox(getCartPage().payPalEmailBox);
        getCartPage().payPalEmailBox.sendKeys(ConfigurationReader.getProperty("paypal_username"));
        getCartPage().payPalPasswordBox.sendKeys(Keys.END);
        BrowserUtilities.cleanTextInBox(getCartPage().payPalPasswordBox);
        getCartPage().payPalPasswordBox.sendKeys(ConfigurationReader.getProperty("paypal_password"));
        getCartPage().payPalLoginButton.click();
        getCartPage().payPalCompletePurchaseButton.click();
    }



    @And("User verifies that {string} alert is visible")
    public void userVerifiesThatAlertIsVisible(String alert) {
            Assert.assertEquals(alert,getOrdersPage().alert.getText());
    }

    @And("User clicks Rate button and verifies related page opened.")
    public void userClicksRateButtonAndVerifiesRelatedPageOpened() {
        getCartPage().rateOurServiceButton.click();
        Assert.assertTrue(getOrdersPage().howWouldYouRateOurServiceTitle.isDisplayed());
getCartPage().rateOurServiceXButton.click();
    }
    @And("User clicks Order detail button and verifies related page opened.")
    public void userClicksOrderDetailButtonAndVerifiesRelatedPageOpened() {
getCartPage().viewOrderDetailLink.click();
Assert.assertEquals("https://test.urbanicfarm.com/account/orders",driver.getCurrentUrl());
    }

    @And("User verifies that {string} text is visible")
    public void userVerifiesThatTextIsVisible(String text) {
BrowserUtilities.switchToWindow(0);
        Assert.assertEquals(text,getCartPage().paymentSuccessfulText.getText());
    }
}