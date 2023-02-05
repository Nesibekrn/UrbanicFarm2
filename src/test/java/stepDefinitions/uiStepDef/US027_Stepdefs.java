package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.util.Set;

import static stepDefinitions.Hooks.driver;

public class US027_Stepdefs extends CommonPage {
    @And("User scrolls down to the Bottom End on the home page")
    public void userScrollsDownToTheBottomEndOnTheHomePage() {

        JSutilities.scrollToBottom();
        BrowserUtilities.wait(5);

    }

    @Then("User checks the Facebook button is clickable")
    public void userChecksTheFacebookButtonIsClickable() {

        Assert.assertTrue(getHomePage().facebookButton.isEnabled());

    }

    @Then("User clicks the Facebook button")
    public void userClicksTheFacebookButton() {

        getHomePage().facebookButton.click();

    }

    @Then("User verifies if Facebook page is visible")
    public void userVerifiesIfFacebookPageIsVisible() {

        Set<String> allWindowHandles = driver.getWindowHandles();
        String window1Handle=driver.getWindowHandle();
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        Assert.assertEquals("https://www.facebook.com/urbanicfarmstead", driver.getCurrentUrl());

    }
}
