package stepDefinitions.uiStepDef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;


import static stepDefinitions.Hooks.driver;

public class US036_StepDef extends CommonPage {
    @Given("User is on the login page")
    public void UserIsOnTheLoginPage() {
      JSutilities.clickWithJS( getHomePage().loginButton);
    }

    @When("the user enters {string} and {string} and clicks on the login button")
    public void theUserEntersAndAndClicksOnTheLoginButton(String email, String password) {
        BrowserUtilities.loginMethod(email,password);

    }

    @Then("the user should see an error message indicating login failure")
    public void theUserShouldSeeAnErrorMessageIndicatingLoginFailure() {
        BrowserUtilities.waitForVisibility(getHomePage().invalidAlert,2);
        Assert.assertTrue(getHomePage().invalidAlert.isDisplayed());
    }

    @And("the user should not be redirected to the dashboard page")
    public void theUserShouldNotBeRedirectedToTheDashboardPage() {
        Assert.assertNotEquals("https://test.urbanicfarm.com/home",driver.getCurrentUrl());

    }

}
