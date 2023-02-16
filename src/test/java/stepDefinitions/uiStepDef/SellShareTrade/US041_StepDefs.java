package stepDefinitions.uiStepDef.SellShareTrade;

import io.cucumber.java.en.Then;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US041_StepDefs extends CommonPage {

    @Then("User clicks Sceduled delivery")
    public void user_clicks_sceduled_delivery() {
        BrowserUtilities.wait(3);
        getSellShareTradePage().scheduledDeliveryLink.click();
        BrowserUtilities.wait(3);

    }
    @Then("User verify relevant page text: {string}")
    public void user_verify_relevant_page_text(String string) {
        getSellShareTradePage().relevantPageText.isDisplayed();
        BrowserUtilities.wait(3);
    }
    @Then("User closes the relevant page")
    public void user_closes_the_relevant_page() {
        getSellShareTradePage().relevantPageClose.click();
        BrowserUtilities.wait(3);

    }
}
