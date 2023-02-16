package stepDefinitions.uiStepDef.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

public class US014_StepDefs extends CommonPage{

    @And("user goes  the {string} heading")
    public void userGoesTheHeading(String arg0) {
        JSutilities.scrollToWebElement(getHomePage().ReduceWasteStrengthenYourCommunityHeading);
    }

    @And("user waits {int} second")
    public void userWaitsSecond(int arg0) {
        BrowserUtilities.wait(2);
    }

    @Then("user verifies  the {string} heading is clickable")
    public void userVerifiesTheHeadingIsClickable(String arg0) {
        Assert.assertTrue(getHomePage().WhatsNearYouLink.isEnabled());
        Assert.assertTrue(getHomePage().PostYourGoodsLink.isEnabled());
    }
}
