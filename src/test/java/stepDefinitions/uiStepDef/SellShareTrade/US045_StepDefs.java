package stepDefinitions.uiStepDef.SellShareTrade;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US045_StepDefs extends CommonPage {
    @When("User clicks the Notification button")
    public void userClicksTheNotificationButton() {
        BrowserUtilities.wait(1);
        getSellShareTradePage().userClicksTheNotificationButton.click();

    }

    @Then("User verifies Notification page is  visible")
    public void userVerifiesNotificationPageIsVisible() {
    getSellShareTradePage().userVerifiesNotificationPageIsVisible.isDisplayed();
    }
}
