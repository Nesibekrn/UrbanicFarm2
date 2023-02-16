package stepDefinitions.uiStepDef.Login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

public class US035_StepDefs extends CommonPage {

    @When("User clicks login link")
    public void user_clicks_login_link() {
        BrowserUtilities.wait(3);
        getHomePage().loginButton.click();
        //JSutilities.clickWithJS(getHomePage().loginButton);
        BrowserUtilities.wait(3);
    }

    @Then("User clicks on email address box")
    public void user_clicks_on_email_address_box() {
        //getLoginPage().emailText.click();
        //Assert.assertTrue(getLoginPage().emailText.isDisplayed());

        BrowserUtilities.wait(3);
        getLoginPage().emailBox.click();
        BrowserUtilities.wait(3);
    }
    @Then("User clicks on password box")
    public void user_clicks_on_password_box() {
        BrowserUtilities.wait(3);
        getLoginPage().passwordBox.click();
        BrowserUtilities.wait(3);
    }

    @Then("User enters a valid email,password and clicks the login button")
    public void userEntersAValidEmailPasswordAndClicksTheLoginButton() {
        BrowserUtilities.wait(3);
        BrowserUtilities.loginMethod(
                ConfigurationReader.getProperty("buyerEmail"),
                ConfigurationReader.getProperty("buyerPassword"));
        BrowserUtilities.wait(3);
    }

    @Then("User closes the {string} alert")
    public void userClosesTheAlert(String welcomeToUrbanicFarm) {
        BrowserUtilities.waitForVisibility(getSellShareTradePage().welcomeToUrbanicFarmCloseButton,45);
        getSellShareTradePage().welcomeToUrbanicFarmCloseButton.click();
    }



   /* @Then("User verifies {string} alert is visible")
    public void userVerifiesAlertIsVisible(String welcomeToUrbanicFarm) {
        BrowserUtilities.wait(2);
        Assert.assertTrue(getLoginPage().alertWelcomeToUrbanicFarm.isDisplayed());
        BrowserUtilities.wait(2);
    }
*/

}
