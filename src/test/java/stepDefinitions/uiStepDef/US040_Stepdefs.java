package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.remote.Command;
import pages.CommonPage;

import static stepDefinitions.Hooks.driver;

public class US040_Stepdefs extends CommonPage {
    @Then("User checks the Contact Us Link is clickable")
    public void userChecksTheContactUsLinkIsClickable() {

        Assert.assertTrue(getSellShareTradePage().contactUsLinkSell.isEnabled());

    }

    @Then("User clicks the Contact Us Link")
    public void userClicksTheContactUsLink() {

        getSellShareTradePage().contactUsLinkSell.click();

    }

    @Then("User verifies if Contact Us page is  visible")
    public void userVerifiesIfContactUsPageIsVisible() {

        Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());

    }
}
