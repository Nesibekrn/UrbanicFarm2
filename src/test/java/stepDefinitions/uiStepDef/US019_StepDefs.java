package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

public class US019_StepDefs extends CommonPage {

    @When("User clicks on Sell-Share-Trade under the Features bottom")
    public void userClicksOnSellShareTradeUnderTheFeaturesBottom() {
       //getHomePage().sellShareTrade.click();
        BrowserUtilities.wait(2);
        JSutilities.clickWithJS(getHomePage().sellShareTrade);
        BrowserUtilities.wait(2);
    }

    @Then("User verifies {string} visible")
    public void userVerifiesVisible(String sellShareTrade) {
        Assert.assertTrue(getHomePage().sellShareTrade.isDisplayed());
        BrowserUtilities.wait(2);
    }


    /*
    @Then("User verifies the current url")
    public void user_verifies_the_current_url() {
        Assert.assertEquals("https://test.urbanicfarm.com/explore",driver.getCurrentUrl());
        BrowserUtilities.wait(2);
    }

     */

}
