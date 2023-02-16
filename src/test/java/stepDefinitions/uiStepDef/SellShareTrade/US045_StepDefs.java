package stepDefinitions.uiStepDef.SellShareTrade;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US045_StepDefs extends CommonPage {
    @When("User clicks the Notification button")
    public void userClicksTheNotificationButton() {
        getSellShareTradePage().userClicksTheNotificationButton.click();

    }

    @Then("User verifies Notification page is  visible")
    public void userVerifiesNotificationPageIsVisible() {
    getSellShareTradePage().userVerifiesNotificationPageIsVisible.isDisplayed();
    }
}
