package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US046_Stepdefs extends CommonPage {
    @And("User clicks the login link")
    public void userClicksTheLoginLink() {

        getHomePage().loginButton.click();

    }

    @Then("User enters valid email address & password & clicks the login button")
    public void userEntersValidEmailAddressPasswordClicksTheLoginButton() {

      //  getLoginPage().loginMethod("buyer_urban@mailsac.com", "VHt*zzt*wQNu6XS");
       getLoginPage().loginMethod(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
      //  BrowserUtilities.waitForVisibility(getSellShareTradePage().welcomeToUrbanicFarmCloseButton,30);
      //  getSellShareTradePage().welcomeToUrbanicFarmCloseButton.click();
    }
    @Then("User checks the Cart button is clickable")
    public void userChecksTheCartButtonIsClickable() {
        Assert.assertTrue(getSellShareTradePage().cartLink.isEnabled());
    }
    @Then("User clicks the Cart button")
    public void userClicksTheCartButton() {
       BrowserUtilities.wait(3);
        JSutilities.clickWithJS(getSellShareTradePage().cartLink);
      // getSellShareTradePage().cartLink.click();
        BrowserUtilities.wait(3);
    }
    @Then("User verifies if Cart page is  visible")
    public void userVerifiesIfCartPageIsVisible() {
        Assert.assertEquals("https://test.urbanicfarm.com/basket", driver.getCurrentUrl());
    }
}
