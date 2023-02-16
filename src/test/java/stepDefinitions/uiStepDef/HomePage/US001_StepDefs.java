package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.*;
import org.junit.Assert;

import static stepDefinitions.Hooks.driver;

public class US001_StepDefs {
    @Given("User goes to {string}")
    public void userGoesTo(String url) {
        driver.get(url);

    }

    @Then("User verifies the url is {string}")
    public void userVerifiesTheUrlIs(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
}
