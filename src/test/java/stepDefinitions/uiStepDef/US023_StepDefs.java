package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import utilities.BrowserUtilities;

public class US023_StepDefs {

    HomePage homePage = new HomePage();

    @And("the user clicks the Terms Of Service.")
    public void theUserClicksTheTermsOfService() {
        //WebElement termOfservice = getDriver().findElement(By.xpath("//a[@href='/terms-of-service']"));
        BrowserUtilities.wait(2);
        homePage.termOfservice.click();
    }

    @Then("the user verifies the Terms Of Service is enabled.")
    public void theUserVerifiesTheTermsOfServiceIsEnabled() {
        // WebElement termOfservice = getDriver().findElement(By.xpath("//a[@href='/terms-of-service']"));
        BrowserUtilities.wait(2);
        homePage.termOfservice.isEnabled();
        Assert.assertTrue(homePage.termOfservice.isEnabled());
    }

}