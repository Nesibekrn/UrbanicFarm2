package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;


public class US018_StepDefs extends CommonPage {



    @When("User scrolls down")
    public void user_scrolls_down() {
        actions.sendKeys(Keys.END).perform();
        //JSutilities.scrollToBottom();
        BrowserUtilities.wait(2);
    }

    @When("User clicks on the Get The App")
    public void user_clicks_on_the_get_the_app() {
        BrowserUtilities.wait(2);
        getHomePage().getTheApp.click();
        BrowserUtilities.wait(2);
    }

    @Then("User verifies Get The App visible")
    public void userVerifiesGetTheAppVisible() {
        Assert.assertTrue(getHomePage().getTheApp.isDisplayed());
        BrowserUtilities.wait(2);
    }


}

