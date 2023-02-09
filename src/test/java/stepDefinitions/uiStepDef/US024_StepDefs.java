package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US024_StepDefs extends CommonPage {

    @Then("User verifies that Address is visible")
    public void user_verifies_that_address_is_visible() {
        BrowserUtilities.wait(2);
        Assert.assertTrue(getHomePage().address.isDisplayed());
        BrowserUtilities.wait(2);
    }


    @Then("user verifies the contents of current address")
    public void userVerifiesTheContentsOfCurrentAddress() {
        BrowserUtilities.wait(2);
       Assert.assertTrue(getHomePage().addressContent.isDisplayed());
        BrowserUtilities.wait(2);
    }
}
