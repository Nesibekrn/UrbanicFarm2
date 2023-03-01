package stepDefinitions.uiStepDef.Orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US061_StepDefs extends CommonPage {
Actions actions=new Actions(driver);

    @And("Product name should be seen")
    public void productNameShouldBeSeen() {
  Assert.assertTrue(getOrdersPage().productName.isDisplayed());
        
        //getOrdersPage().productName.isDisplayed();
       // BrowserUtilities.wait(2);
    }

    @Then("Product Price should be seen")
    public void productPriceShouldBeSeen() {
   Assert.assertTrue(getOrdersPage().productPrice.isDisplayed());
    //getOrdersPage().productPrice.isDisplayed();
     //   BrowserUtilities.wait(2);

    }

    @Then("Product Stock should be seen")
    public void productStockShouldBeSeen() {

        Assert.assertTrue(getOrdersPage().productLb.isDisplayed());

    }

    @Then("Product Unit should be seen")
    public void productUnitShouldBeSeen() {
   Assert.assertTrue(getOrdersPage().productTotal.isDisplayed());
    }

    @Then("Product Image should be seen")
    public void productImageShouldBeSeen() {
  Assert.assertTrue(getOrdersPage().productImage.isDisplayed());

    }

    @And("Rate the product button should be clickable")
    public void rateTheProductButtonShouldBeClickable()
    {
 Assert.assertTrue(getOrdersPage().rateTheProduct.isEnabled());
    }

    @And("Rate the Seller button should be clickable")
    public void rateTheSellerButtonShouldBeClickable() {
      getOrdersPage().rateTheSeller.click();
       //BrowserUtilities.waitForClickable(getOrdersPage().rateTheSeller);
       // JSutilities.clickWithJS(getOrdersPage().rateTheSeller);
    }

    @And("The Rate the product button are clicked various actions should be performed on the screen that open")
    public void theRateTheProductButtonAreClickedVariousActionsShouldBePerformedOnTheScreenThatOpen() {
getOrdersPage().rateTheProduct.click();
       BrowserUtilities.waitForClickable(getOrdersPage().cursorPointer);
        getOrdersPage().cursorPointer.click();
        BrowserUtilities.wait(2);
       // actions.moveToElement(getOrdersPage().commitBox).sendKeys("iyi").click(getOrdersPage().submitButton).build().perform();
        getOrdersPage().commitBox.sendKeys("iyi");
        getOrdersPage().submitButton.click();
        BrowserUtilities.wait(2);
        Assert.assertTrue(getOrdersPage().alert.isDisplayed());
    }

    @Then("The Rate the Seller button are clicked various actions should be performed on the screen that open")
    public void theRateTheSellerButtonAreClickedVariousActionsShouldBePerformedOnTheScreenThatOpen() {
       getOrdersPage().rateTheSeller.click();
        getOrdersPage().cursorPointer.click();
        BrowserUtilities.wait(2);
        //actions.moveToElement(getOrdersPage().commitBox).sendKeys("iyi").click(getOrdersPage().submitButton).build().perform();
        getOrdersPage().commitBox.sendKeys("iyi");
        getOrdersPage().submitButton.click();
        BrowserUtilities.wait(2);
        Assert.assertTrue(getOrdersPage().alert.isDisplayed());

    }

}
