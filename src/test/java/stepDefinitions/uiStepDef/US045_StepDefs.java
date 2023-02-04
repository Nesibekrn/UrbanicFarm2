package stepDefinitions.uiStepDef;

import enums.USERINFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US045_StepDefs extends CommonPage {

    @When("User clicks Sell-Share-Trade button")
    public void userClicksSellShareTradeButton() {
   getHomePage().getSellShareTradePage().userClicksSellShareTradeButton.click();
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        getHomePage().loginButton.click();
    }

    @And("User goes to email box and writes email")
    public void userGoesToEmailBoxAndWritesEmail(USERINFO user) {
      getLoginPage().loginMethod(user);
    }

    @And("User goes to password box and writes password")
    public void userGoesToPasswordBoxAndWritesPassword(USERINFO user) {
        getLoginPage().loginMethod(user);
    }

    @Then("User click login page")
    public void userClickLoginPage() {
    }

    @And("User clicks notification button")
    public void userClicksNotificationButton() {
    }

    @Then("User verify relevant notifications visibility")
    public void userVerifyRelevantNotificationsVisibility() {
    }
}
