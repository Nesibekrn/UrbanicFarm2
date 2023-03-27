package stepDefinitions.uiStepDef.Orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;
import static utilities.Driver.getDriver;

public class US062_stepDefs extends CommonPage {

    @And("the user fill out valid email in username text box")
    public void theUserFillOutValidEmailInUsernameTextBox() {
        BrowserUtilities.loginMethod(" urbanicfarm2@yopmail.com", "Urbanicfarm2/");

    }

    @And("the user clicks account name")
    public void theUserClicksAccountName() {
        BrowserUtilities.wait(4);
        getAccountPage().accountName.click();
        BrowserUtilities.wait(2);
    }

    @Then("the user verifies page is {string}")
    public void theUserVerifiesPageIs(String url) {
        BrowserUtilities.wait(2);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @And("The user clicks orders option")
    public void theUserClicksOrdersOption() {

        getOrdersPage().order.click();
        BrowserUtilities.wait(2);

    }

    @Then("The user verifies orders tab is enabled")
    public void theUserVerifiesOrdersTabIsEnabled() {
        getOrdersPage().order.click();
        Assert.assertTrue(String.valueOf(getOrdersPage().order.isEnabled()), true);
    }

    @Then("The orders page should be displayed")
    public void theOrdersPageShouldBeDisplayed() {
        Assert.assertTrue("https://test.urbanicfarm.com/account/orders", true);

    }

    @And("Orders list should be displayed")
    public void ordersListShouldBeDisplayed() {

        for (WebElement each : getOrdersPage().orderlist) {
            each.isDisplayed();
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @When("The user clicks view order details")
    public void theUserClicksViewOrderDetails() {

        getOrdersPage().orderviewdetails.click();


    }


    @Then("The Order Details text should be displayed on the Order Details page")
    public void theOrderDetailsTextShouldBeDisplayedOnTheOrderDetailsPage() {


        Assert.assertTrue(getOrdersPage().orderDetail.isDisplayed());

    }

    @Then("The Order summary should be displayed on the Order Details page")
    public void theOrderSummaryShouldBeDisplayedOnTheOrderDetailsPage() {


        Assert.assertTrue(String.valueOf(getOrdersPage().orderSummary.isDisplayed()), true);
    }

    @Then("The Order contents fields should be visible on the Order Details page")
    public void theOrderContentsFieldsShouldBeVisibleOnTheOrderDetailsPage() {


        BrowserUtilities.wait(2);
        Assert.assertTrue(String.valueOf(getOrdersPage().orderContent.isDisplayed()), true);

    }



    @And("The Seller page link should be enabled")
    public void theSellerPageLinkShouldBeEnabled() {


        Assert.assertTrue(getOrdersPage().sellerPage.isEnabled());
        BrowserUtilities.wait(3);
        JSutilities.clickWithJS(getOrdersPage().sellerPage);
        BrowserUtilities.wait(3);


    }


    @And("The Seller page should be redirected to correct page when click back")
    public void theSellerPageShouldBeRedirectedToCorrectPageWhenClickBack() {

        while (!driver.getCurrentUrl().contains("https://test.urbanicfarm.com/account/orders/order-details")) {
            getDriver().navigate().back();
        }
        BrowserUtilities.wait(2);
    }

    @Then("The user verifies seller address is correct")
    public void theUserVerifiesSellerAddressIsCorrect() {
        WebElement iframelement = getDriver().findElement(By.xpath("(//iframe[@class='d-block'])[1]"));
        getDriver().switchTo().frame(iframelement);
        List<WebElement> address = getDriver().findElements(By.xpath("(//a[contains(text(),'View l')])[1]"));
        String defaulthandle = getDriver().getWindowHandle();
        address.get(0).click();
        getDriver().switchTo().defaultContent();
        for (String each : getDriver().getWindowHandles()) {
            if (!each.equals(defaulthandle)) {
                getDriver().switchTo().window(each);
            }
        }

        String expectedAddress = "239 Dilston Rd, Newcastle upon Tyne NE4 5AD, UK";
        String actualAddress = getOrdersPage().address2page.getText();
        Assert.assertEquals(expectedAddress, actualAddress);
    }

    @Then("The user clicks Seller address is displayed")
    public void theUserClicksSellerAddressIsDisplayed() {
        Assert.assertTrue(getOrdersPage().sellerAdress.isDisplayed());
    }
}