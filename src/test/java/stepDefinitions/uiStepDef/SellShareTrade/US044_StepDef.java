package stepDefinitions.uiStepDef.SellShareTrade;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;

public class US044_StepDef extends CommonPage {

    @Then("User verifies logout botton is clickable")
    public void userVerifiesLogoutBottonIsClickable() {
        Assert.assertTrue(getHomePage().logoutButton2.isEnabled());
        getHomePage().logoutButton2.click();
    }
}

