package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.util.Set;

import static stepDefinitions.Hooks.driver;

public class US028_Stepdefs extends CommonPage {
    @And("User scrolls down to the Bootm End on the home page")
    public void userScrollsDownToTheBootmEndOnTheHomePage() {

        JSutilities.scrollToBottom();
        BrowserUtilities.wait(5);

    }

    @Then("User checks the LinkedIn button is clickable")
    public void userChecksTheLinkedInButtonIsClickable() {

        Assert.assertTrue(getHomePage().linkedInButton.isEnabled());

    }

    @Then("User clicks the LinkedIn button")
    public void userClicksTheLinkedInButton() {

        getHomePage().linkedInButton.click();

    }

    @Then("User verifies if LinkedIn page is visible")
    public void userVerifiesIfLinkedInPageIsVisible() {

        Set<String> allWindowHandles = driver.getWindowHandles();
        String window1Handle=driver.getWindowHandle();
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        Assert.assertEquals("https://www.linkedin.com/company/urbanicfarm/?original_referer=", driver.getCurrentUrl());

    }
}
