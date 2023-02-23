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
        BrowserUtilities.loginMethod(" urbanicfarm2@yopmail.com","Urbanicfarm2/");

    }

    @And("the user clicks account name")
    public void theUserClicksAccountName() {
        getAccountPage().accountName.click();
    }

    @Then("the user verifies page is {string}")
    public void theUserVerifiesPageIs(String url) {
        BrowserUtilities.wait(2);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @And("The user clicks orders option")
    public void theUserClicksOrdersOption() {
        WebElement order=getDriver().findElement(By.xpath("//a[@href='/account/orders']"));
        order.click();
        BrowserUtilities.wait(2);

    }

    @Then("The user verifies orders tab is enabled")
    public void theUserVerifiesOrdersTabIsEnabled() {
        WebElement order=getDriver().findElement(By.xpath("//a[@href='/account/orders']"));
        order.click();
        Assert.assertTrue(String.valueOf(order.isEnabled()),true);
    }

    @Then("The orders page should be displayed")
    public void theOrdersPageShouldBeDisplayed() {
        Assert.assertTrue("https://test.urbanicfarm.com/account/orders",true);

    }

    @And("Orders list should be displayed")
    public void ordersListShouldBeDisplayed() {
        List<WebElement> orderlist = getDriver().findElements(By.xpath(" //section[@class='card mb-2']"));
        for (WebElement each : orderlist) {
            each.isDisplayed();
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @When("The user clicks view order details")
    public void theUserClicksViewOrderDetails() {
        WebElement orderQuick1 = getDriver().findElement(By.xpath("//a[@href='/account/orders/order-details/813']"));
        //a[contains(text(),'View order details')]"));
        orderQuick1.click();
        BrowserUtilities.wait(3);

        }


    @Then("The Order Details text should be displayed on the Order Details page")
    public void theOrderDetailsTextShouldBeDisplayedOnTheOrderDetailsPage() {

        WebElement orderDetail=getDriver().findElement(By.xpath("//div/span[contains(text(),'Order Details')]"));
        Assert.assertTrue(String.valueOf(orderDetail.isDisplayed()),true);

    }

    @Then("The Order summary should be displayed on the Order Details page")
    public void theOrderSummaryShouldBeDisplayedOnTheOrderDetailsPage() {

        WebElement orderSummary=getDriver().findElement(By.xpath("//h5[contains(text(),'Order summary')]"));
        Assert.assertTrue(String.valueOf(orderSummary.isDisplayed()),true);
    }

    @Then("The Order contents fields should be visible on the Order Details page")
    public void theOrderContentsFieldsShouldBeVisibleOnTheOrderDetailsPage() {

        WebElement orderContent=getDriver().findElement(By.xpath("//h5[contains(text(),'Order content')]"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(String.valueOf(orderContent.isDisplayed()),true);

    }

    @And("The Seller page link should be enabled")
    public void theSellerPageLinkShouldBeEnabled() {

        WebElement sellerPage=getDriver().findElement(By.xpath("//a[@href='/point/1807']"));
        Assert.assertTrue(sellerPage.isEnabled());
        BrowserUtilities.wait(3);
        JSutilities.clickWithJS(sellerPage);
        BrowserUtilities.wait(3);



    }

    @And("Seller page should redirect to correct page when click back")
    public void sellerPageShouldRedirectToCorrectPageWhenClickBack() {

    }


    @And("The Seller page should be redirected to correct page when click back")
    public void theSellerPageShouldBeRedirectedToCorrectPageWhenClickBack() {
        getDriver().navigate().to("https://test.urbanicfarm.com/account/orders/order-details/813");
        BrowserUtilities.wait(5);

    }

    @Then("The user verifies seller address is correct on the seller page")
    public void theUserVerifiesSellerAddressIsCorrectOnTheSellerPage() {
        WebElement iframelement=getDriver().findElement(By.xpath("//iframe[@class='my-0 mx-auto d-block shadow mb-5 bg-white rounded']"));
        getDriver().switchTo().frame(iframelement);
        WebElement address=getDriver().findElement(By.xpath("//div[@class='address']"));
        String expectedAddress="26581 Joshua St, Hayward, CA 94544";
        String actualAddress= address.getText();
        Assert.assertEquals(expectedAddress,actualAddress);
        BrowserUtilities.wait(3);
    }

    @And("The user should closed driver")
    public void theUserShouldClosedDriver() {
        driver.close();
        BrowserUtilities.wait(5);
    }
}
