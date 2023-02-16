package stepDefinitions.uiStepDef.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US010_StepDefs {

    @Given("User goes to home page")
    public void userGoesToHomePage() {
        driver.get("https://test.urbanicfarm.com/");
    }

    @Then("User assert sell your produce button is clickable")
    public void userAssertSellYourProduceButtonIsClickable() {
        Assert.assertTrue(commonPage.getHomePage().sellyourproduce.isEnabled());
    }

    @When("User clicks on sell your produce button")
    public void userClicksOnSellYourProduceButton() {
        commonPage.getHomePage().sellyourproduce.click();
    }

    @Then("User verified the url is {string}")
    public void userVerifiedTheUrlIs(String expectedurl) {
        Assert.assertEquals(expectedurl,driver.getCurrentUrl());
    }
}
