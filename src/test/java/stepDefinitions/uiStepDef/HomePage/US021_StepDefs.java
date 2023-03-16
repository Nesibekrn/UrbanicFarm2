package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;


public class US021_StepDefs extends CommonPage {
    @When("User clicks Contact Us button Navbar")
    public void userClicksContactUsButtonNavbar() {
        BrowserUtilities.scrollAndClickWithJS(getHomePage().contactUsNavbar);

    }

    @Then("User veries relavent page is {string}")
    public void userVeriesRelaventPageIs(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
}
