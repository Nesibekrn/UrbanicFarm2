package stepDefinitions.uiStepDef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;

import javax.swing.*;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class US017_StepDefs extends CommonPage {

    @Given("User goes to {string}")
    public void user_goes_to(String url) {
        driver.get(url);

    }
    @When("User goes to bottom page")
    public void user_goes_to_bottom_page() {
       actions.sendKeys(Keys.END).perform();
        BrowserUtilities.wait(3);
    }
    @When("User click Discover Local link")
    public void User_click_Discover_Local_link() {
        getHomePage().discoverLink.click();
    }
    @Then("User verifies relevant pages url")
    public void User_verifies_relevant_pages_url() {
        Assert.assertEquals("https://test.urbanicfarm.com/explore",driver.getCurrentUrl());
    }
}
