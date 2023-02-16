package stepDefinitions.uiStepDef.SellShareTrade;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;

public class US043_StepDefs extends CommonPage {


    @Then("User clicks {string} username")
    public void user_clicks_username(String userNameCristian) {
        BrowserUtilities.wait(3);
        getSellShareTradePage().userNameVerify.click();
        BrowserUtilities.wait(3);
    }

    @Then("User verifies the username is visible")
    public void user_verifies_the_username_is_visible() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(getSellShareTradePage().userNameVisible.isDisplayed());
        BrowserUtilities.wait(3);
    }

    @Then("User verifies the url of the account name page")
    public void userVerifiesTheUrlOfTheAccountNamePage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/home", driver.getCurrentUrl());
        BrowserUtilities.wait(3);
    }

}
