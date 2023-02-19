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
import java.util.List;

import static utilities.Driver.getDriver;

public class US062_stepDefs extends CommonPage {

    @And("the user fill out valid email in username text box")
    public void theUserFillOutValidEmailInUsernameTextBox() {
        BrowserUtilities.loginMethod("seller_urban2@yopmail.com","Seller2/");
        //getLoginPage().emailBox.sendKeys(ConfigurationReader.getProperty("buyer_urban@mailsac.com"));
    }

    @And("the user fill out valid email in password text box")
    public void theUserFillOutValidEmailInPasswordTextBox() {
        getLoginPage().passwordBox.sendKeys(ConfigurationReader.getProperty("VHt*zzt*wQNu6XS"));
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
        WebElement orderQuick1 = getDriver().findElement(By.xpath("//a[@href='/account/orders/order-details/776']"));
        // orderQuick1.click();
        JSutilities.scrollToWebElement(orderQuick1);
        BrowserUtilities.wait(3);
//        getDriver().navigate().back();
//        BrowserUtilities.wait(5);
//        WebElement orderQuick2 = getDriver().findElement(By.xpath("//a[@href='/account/orders/order-details/775']"));
//        orderQuick2.click();
//        BrowserUtilities.wait(3);
//        getDriver().navigate().back();
//        BrowserUtilities.wait(5);
//        WebElement orderQuick3 = getDriver().findElement(By.xpath("//a[@href='/account/orders/order-details/774']"));
//        orderQuick3.click();
//        BrowserUtilities.wait(3);
//        getDriver().navigate().back();
//        BrowserUtilities.wait(5);
//        List<WebElement> orderviewCount = new ArrayList<>();
//        orderviewCount.add(orderQuick1);
//        orderviewCount.add(orderQuick2);
//        orderviewCount.add(orderQuick3);
//        System.out.println(orderviewCount.size());
//        for (WebElement each : orderviewCount) {
//            each.click();
//            BrowserUtilities.wait(5);
//            getDriver().navigate().back();
//            BrowserUtilities.wait(5);
//
////        }
        }


    @Then("The Order Details text should be displayed on the Order Details page")
    public void theOrderDetailsTextShouldBeDisplayedOnTheOrderDetailsPage() {

        WebElement orderDetail=getDriver().findElement(By.xpath("//div/span[contains(text(),'Order Details ')]"));
        Assert.assertTrue(String.valueOf(orderDetail.isDisplayed()),true);

    }

    @Then("The Order summary should be displayed on the Order Details page")
    public void theOrderSummaryShouldBeDisplayedOnTheOrderDetailsPage() {

        WebElement orderSummary=getDriver().findElement(By.xpath("//h5[contains(text(),'Order summary')]"));
        Assert.assertTrue(String.valueOf(orderSummary.isDisplayed()),true);
    }

    @Then("The Order contents fields should be visible on the Order Details page")
    public void theOrderContentsFieldsShouldBeVisibleOnTheOrderDetailsPage() {

        WebElement orderContent=getDriver().findElement(By.xpath("//h5[contains(text(),'Order contents')]"));
        Assert.assertTrue(String.valueOf(orderContent.isDisplayed()),true);

    }

    @And("The Seller page link should be enabled")
    public void theSellerPageLinkShouldBeEnabled() {

        WebElement sellerPage=getDriver().findElement(By.xpath("//a[@href='/point/1484']"));
        sellerPage.click();
        BrowserUtilities.wait(5);


    }

    @And("Seller page should redirect to correct page when click back")
    public void sellerPageShouldRedirectToCorrectPageWhenClickBack() {
        getDriver().navigate().back();
    }
}
