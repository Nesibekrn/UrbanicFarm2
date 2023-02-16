package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CommonPage;
import static stepDefinitions.Hooks.driver;

public class US006_StepDefs extends CommonPage {

    @And("User checks the Contact Us button is clickable")
    public void userChecksTheContactUsButtonIsClickable() {

        getHomePage().contactUsLink.isEnabled();

    }

    @Then("User clicks Contact Us button")
    public void userClicksContactUsButton() {

        getHomePage().contactUsLink.click();

    }

    @Then("User verifies if Contact Us page is visible")
    public void userVerifiesIfContactUsPageIsVisible() {

        Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());

    }

}
