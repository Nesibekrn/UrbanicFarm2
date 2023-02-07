package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import utilities.BrowserUtilities;


public class US022_StepDefs {
    HomePage homePage = new HomePage();

    @And("the user clicks the Privacy Policy.")
    public void theUserClicksThePrivacyPolicy() {
        //  WebElement privacyPolicy = getDriver().findElement(By.xpath("//a[@href='/privacy-policy']"));

        BrowserUtilities.wait(2);
        homePage.privacyPolicy.click();
    }

    @Then("the user verifies the Privacy Policy is enabled.")
    public void theUserVerifiesThePrivacyPolicyIsEnabled() {
        // WebElement privacyPolicy = getDriver().findElement(By.xpath("//a[@href='/privacy-policy']"));
        Assert.assertTrue(homePage.privacyPolicy.isEnabled());
    }



}
