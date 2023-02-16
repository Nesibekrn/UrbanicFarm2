package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US039_StepDefs extends CommonPage {

    @Given("User click the login link")
    public void user_click_the_login_link() {
        getHomePage().loginButton.click();
    }

    @Then("User enter valid email address & password & clicks the login button")
    public void user_enter_valid_email_address_password_clicks_the_login_button() {
        getLoginPage().loginMethod(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
        BrowserUtilities.wait(2);
    }
    @Then("User checks the About Us Link is clickable")
    public void user_checks_the_about_us_link_is_clickable() {
        Assert.assertTrue(getSellShareTradePage().AboutUs.isEnabled());
    }
    @Then("User clicks the About Us Link")
    public void user_clicks_the_about_us_link() {
        BrowserUtilities.wait(4);
       // JSutilities.clickWithJS(getSellShareTradePage().AboutUs);
        getSellShareTradePage().AboutUs.click();
        BrowserUtilities.wait(2);
    }
    @Then("User verifies if About Us page is  visible")
    public void user_verifies_if_about_us_page_is_visible() {
        Assert.assertEquals("https://test.urbanicfarm.com/about", driver.getCurrentUrl());
    }


}

