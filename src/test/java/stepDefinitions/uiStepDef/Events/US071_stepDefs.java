package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.time.Duration;

public class US071_stepDefs extends CommonPage {

    @Then("User clicks Submit button{int}")
    public void userClicksSubmitButton(int arg0) {
        JSutilities.clickWithJS(getEvent().submitButton2);

    }

    @Then("User verifies event created alert massages")
    public void user_verifies_even_created_alert_massages() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(getEvent().eventCreateddAlertMassage.isDisplayed());
        BrowserUtilities.waitForVisibility(getEvent().eventCreateddAlertMassage,5);
    }

    @Then("User verifies new sign massages")
    public void user_verifies_new_sign_massages() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(getEvent().newSinggMassage.isDisplayed());


    }



}
