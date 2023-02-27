package stepDefinitions.uiStepDef.SellShareTrade;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;
import utilities.BrowserUtilities;

import static utilities.Driver.getDriver;

public class US042_StepDefs {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    SellShareTradePage sellShareTradePage = new SellShareTradePage();

    @When("the user clicks login module button")
    public void theUserClicksLoginModuleButton() {

        BrowserUtilities.wait(2);
        homePage.loginmodule.click();

    }

    @And("the user fill out valid email {string} in username text box")
    public void theUserFillOutValidEmailInUsernameTextBox(String email) {

        loginPage.emailRegister.sendKeys(email);

    }

    @And("the user fill out valid email {string} in password text box")
    public void theUserFillOutValidEmailInPasswordTextBox(String password) {

        loginPage.passwordRegister.sendKeys(password);
    }

    @And("the user clicks login button on the login page")
    public void theUserClicksLoginButtonOnTheLoginPage() {

        loginPage.loginButton.click();
    }

    @Then("the user verifes page is {string}")
    public void theUserVerifesPageIs(String url) {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Then("the user verifies account name is displayed")
    public void theUserVerifiesAccountNameIsDisplayed() {

        BrowserUtilities.wait(2);
        Assert.assertTrue(accountPage.accountName.isDisplayed());
    }

    @And("the user clicks Sale-Pay-Trade module")
    public void theUserClicksSalePayTradeModule() {

        BrowserUtilities.wait(2);
        accountPage.salePTmodule.click();

    }

    @Then("the user verifies Sale-Pay-Trade modele is enabled")
    public void theUserVerifiesSalePayTradeModeleIsEnabled() {

        BrowserUtilities.wait(2);
        Assert.assertTrue(accountPage.salePTmodule.isEnabled());

    }

    @And("the user clicks events button")
    public void theUserClicksEventsButton() {

        BrowserUtilities.wait(3);
        Assert.assertTrue(sellShareTradePage.eventsButton.isEnabled());
        BrowserUtilities.wait(2);
        sellShareTradePage.eventsButton.click();
        BrowserUtilities.wait(2);

    }
}
