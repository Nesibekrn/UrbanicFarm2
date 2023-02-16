package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import static stepDefinitions.Hooks.driver;

public class US004_StepDefs extends CommonPage {

    @When("user clicks to explore button")
    public void userClicksToExploreButton() {
        getHomePage().exploreLink.click();
    }

    @Then("user verifies relavent page is {string}")
    public void userVerifiesRelaventPageIs(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
