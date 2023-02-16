package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CommonPage;
import static stepDefinitions.Hooks.driver;

public class US005_StepDefs extends CommonPage {
    @When("user clicks to About Us button")
    public void userClicksToAboutUsButton() {
        getHomePage().aboutUsLink.click();
    }
    @Then("user verifies relevant page is {string}")
    public void userVerifiesRelevantPageIs(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
