package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;


public class US03_StepDefs extends CommonPage {

    @Given("User verifies Blog Link is clickable and clicks")
    public void userVerifiesBlogLinkIsClickableAndClicks() {
        Assert.assertTrue(getHomePage().blogLink.isDisplayed());
        getHomePage().blogLink.click();
        BrowserUtilities.wait(2);
    }

    @Then("User verifies relevant Blog Page with url")
    public void userVerifiesRelevantBlogPageWithUrl() {
        Assert.assertEquals("https://test.urbanicfarm.com/blog/", driver.getCurrentUrl());

    }

}
