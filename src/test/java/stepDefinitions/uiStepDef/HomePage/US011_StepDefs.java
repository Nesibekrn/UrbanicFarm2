package stepDefinitions.uiStepDef.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US011_StepDefs  {
    @Then("User assert register now button is clickable")
    public void userAssertRegisterNowButtonIsClickable(){
        Assert.assertTrue(commonPage.getHomePage().registernow.isEnabled());
    }

    @When("User clicks on register now button")
    public void userClicksOnRegisterNowButton(){
        JSutilities.clickElementByJS(commonPage.getHomePage().registernow);
    }


}
