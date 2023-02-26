package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US063_Stepdefs extends CommonPage {


    @Given("User goes to Welcome Page")
    public void userGoesToWelcomePage() {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("buyerToken"), "home");
    }

    @Then("User verifies if Welcome Page appears")
    public void userVerifiesIfWelcomePageAppears() {

        Assert.assertEquals("https://test.urbanicfarm.com/home", driver.getCurrentUrl());

    }

 }

