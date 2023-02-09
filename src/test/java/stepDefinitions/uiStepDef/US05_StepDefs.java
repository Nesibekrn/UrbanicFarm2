package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

import static stepDefinitions.Hooks.driver;

public class US05_StepDefs extends CommonPage {


    @When("user clicks to About Us button")
    public void userClicksToAboutUsButton() {
        getHomePage().aboutUsLink.click();
    }
    @Then("user verifies relevant page is {string}")
    public void userVerifiesRelevantPageIs(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }


}
