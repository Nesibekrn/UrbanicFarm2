package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import static stepDefinitions.Hooks.driver;

public class US007_StepDefs extends CommonPage {

    @And("User checks the Login button is clickable")
    public void userChecksTheLoginButtonIsClickable() {

        Assert.assertTrue(getHomePage().loginButton.isDisplayed());

    }

    @Then("User clicks Login button")
    public void userClicksLoginButton() {

        getHomePage().loginButton.click();
        BrowserUtilities.wait(3);

    }

    @Then("User verifies if Login page is visible")
    public void userVerifiesIfLoginPageIsVisible() {

        Assert.assertEquals("https://test.urbanicfarm.com/auth/login", driver.getCurrentUrl());

    }
}
