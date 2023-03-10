package stepDefinitions.uiStepDef.Orders;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;
import static stepDefinitions.Hooks.select;

public class US067_StepDefs extends CommonPage {
    @Given("User login as {string} to {string}")
    public void userLoginAs(String token, String web) {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty(token), web);
    }

    @Then("User add a new product if it is not exist")
    public void userAddANewProductIfItIsNotExist() {
        getYourProductsServicesPage().yourProductsServices.click();
        try {
            getYourProductsServicesPage().vegetablesAndFruitsHub.click();
            try {
                Assert.assertTrue(getYourProductsServicesPage().productImage.isDisplayed());
            } catch (Exception f) {
                getYourProductsServicesPage().addNewProduct_Name.sendKeys(getYourProductsServicesPage().allProductsNames.get(0).getText());
                getYourProductsServicesPage().addNewProduct_Price.sendKeys("15");
                getYourProductsServicesPage().addNewProduct_Stock.sendKeys("15");
                select = new Select(getYourProductsServicesPage().addNewProduct_Unit);
                select.selectByIndex(5);
                BrowserUtilities.scrollAndClickWithJS(getYourProductsServicesPage().addNewProduct_Submit);
            }
        } catch (Exception e) {
            getYourProductsServicesPage().allhubs.get(0).click();
            getYourProductsServicesPage().vegetablesAndFruitsHub.click();
            getYourProductsServicesPage().addNewProduct_Name.sendKeys(getYourProductsServicesPage().allProductsNames.get(0).getText());
            getYourProductsServicesPage().addNewProduct_Price.sendKeys("15");
            getYourProductsServicesPage().addNewProduct_Stock.sendKeys("15");
            select = new Select(getYourProductsServicesPage().addNewProduct_Unit);
            select.selectByIndex(5);
            BrowserUtilities.scrollAndClickWithJS(getYourProductsServicesPage().addNewProduct_Submit);
        }
    }

    @And("User give an order from Seller")
    public void userGiveAnOrderFromSeller() {
        getHomePage().urbanicFarmLogo.click();
        getWelcomePage().searchBox.sendKeys("Green Zebra");
        select = new Select(getWelcomePage().searchInMilesBox);
        select.selectByIndex(2);
        getWelcomePage().allCategories.sendKeys("Vegetable & fruits");
        getWelcomePage().searchButton.click();
        BrowserUtilities.wait(1);
        BrowserUtilities.scrollAndClickWithJS(getWelcomePage().addCartButton);
        BrowserUtilities.wait(1);
        getWelcomePage().numberOfCart.click();
        BrowserUtilities.wait(1);
        getCartPage().proceedToCheckout.click();
        BrowserUtilities.wait(1);
        getCartPage().nextButton.click();
        BrowserUtilities.wait(1);
        getCartPage().nextButton.click();
        BrowserUtilities.wait(1);
        getCartPage().goToPaymentButton.click();
        BrowserUtilities.wait(3);
        BrowserUtilities.switchToWindowWithIndex(1);
        BrowserUtilities.waitForPageToLoad(10);
        getCartPage().loginPayPalButton.click();
        getCartPage().payPalEmailBox.sendKeys(Keys.END);
        BrowserUtilities.cleanTextInBox(getCartPage().payPalEmailBox);
        getCartPage().payPalEmailBox.sendKeys(ConfigurationReader.getProperty("paypal_username"));
        getCartPage().payPalPasswordBox.sendKeys(Keys.END);
        BrowserUtilities.cleanTextInBox(getCartPage().payPalPasswordBox);
        getCartPage().payPalPasswordBox.sendKeys(ConfigurationReader.getProperty("paypal_password"));
        getCartPage().payPalLoginButton.click();
        getCartPage().payPalCompletePurchaseButton.click();
       BrowserUtilities.switchToWindowWithIndex(0);
        Assert.assertEquals("Payment successful", getCartPage().paymentSuccessfulText.getText());
    }

    @And("User clicks Orders option")
    public void userClicksOrdersOption() {
        getOrdersPage().ordersLink.click();
    }

    @And("User verifies that Orders status is {string}")
    public void userVerifiesThatOrdersStatusIs(String expectedStatus) {
        Assert.assertEquals(expectedStatus, getOrdersPage().activeOrderStatus.getText());
        driver.navigate().refresh();
    }

    @When("User -Seller- changes Orders status {string}")
    public void userSellerChangesOrdersStatus(String newOrderStatus) {
       select = new Select(getOrdersPage().orderStatusDropdown);
        select.selectByVisibleText(newOrderStatus);
    }

    @And("User -Buyer- verifies that new Orders status is {string}")
    public void userBuyerVerifiesThatNewOrdersStatusIs(String expectedStatus) {
        Assert.assertEquals(expectedStatus, getOrdersPage().activeOrderStatus.getText());
    }

    @When("User {string} clicks Notification icon")
    public void userClicksNotificationIcon(String user) {
        getWelcomePage().notificationIcon.click();
    }

    @Then("User {string} verifies Mark all as read button and X button are functional")
    public void userVerifiesMarkAllAsReadButtonAndXButtonAreFunctional(String arg0) {
        Assert.assertTrue(getOrdersPage().markAllAsReadLink.isEnabled());
        Assert.assertTrue(getOrdersPage().notificationXButton.isEnabled());
    }

    @And("User {string} verifies that correct result is occure after clicking Mark all as read button")
    public void userVerifiesThatCorrectResultIsOccureAfterClickingMarkAllAsReadButton(String arg0) {
        Assert.assertTrue(getOrdersPage().markReadList.get(0).isDisplayed());
        getOrdersPage().markAllAsReadLink.click();
        if (getOrdersPage().viewAllLink.isDisplayed()){
            JSutilities.clickElementByJS(getOrdersPage().viewAllLink);
        }
        BrowserUtilities.wait(1);

        Assert.assertEquals(0, getOrdersPage().markReadList.size());
    }

    @And("User {string} verifies that correct result is occure after clicking X button")
    public void userVerifiesThatCorrectResultIsOccureAfterClickingXButton(String arg0) {
        JSutilities.clickElementByJS(getOrdersPage().notificationXButton);
    }

    @And("User verifies that {string} message is displayed.")
    public void userVerifiesThatMessageIsDisplayed(String text) {
        Assert.assertEquals(text, getOrdersPage().notificationText.getText());
    }
}
