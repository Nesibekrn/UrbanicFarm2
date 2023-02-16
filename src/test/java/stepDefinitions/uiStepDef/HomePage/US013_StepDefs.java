package stepDefinitions.uiStepDef.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

public class US013_StepDefs extends CommonPage{
    @And("user goes to the {string} heading")
    public void userGoesToTheHeading(String arg0) {
        JSutilities.scrollToWebElement(getHomePage().contributionToTheEnvironmentAndSocietyHeading);
    }

    @And("user waits {int} seconds")
    public void userWaitsSeconds(int saniye) {
        BrowserUtilities.wait(saniye);
    }

    @Then("user verifies that the {string} heading is clickable")
    public void user_verifies_that_the_heading_is_clickable(String string) {
        Assert.assertTrue(getHomePage().registerNowLink.isEnabled());
    }
}
