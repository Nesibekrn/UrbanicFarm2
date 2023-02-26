package stepDefinitions.uiStepDef.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US016_StepDefs extends CommonPage{
    @Given("user goes to {string}")
    public void user_Goes_To(String url) {
        driver.get(url);

    }
    @And("user goes to bottom page")
    public void user_Goes_To_Bottom_Page() {
        JSutilities.scrollToBottom();
        //  actions.sendKeys(Keys.END).perform();
        //BrowserUtilities.wait(3);

    }

    @And("user clicks on Blog option under the Explore Icon")
    public void user_Clicks_On_Blog_Icon_Under_The_Explore_Icon() {
        BrowserUtilities.wait(3);
        getHomePage().blogOption.click();


    }
    @Then("user verifies that current url")
    public void user_Verifies_That_CurrentUrl_Is() {
        // Assert.assertEquals("https://test.urbanicfarm.com/blog/",driver.getCurrentUrl());
        Assert.assertEquals("https://urbanicfarm.com/blog/",driver.getCurrentUrl());

    }
}
