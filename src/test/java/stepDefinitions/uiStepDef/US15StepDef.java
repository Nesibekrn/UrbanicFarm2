package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.util.Set;

import static stepDefinitions.Hooks.driver;

public class US15StepDef extends CommonPage {
    @Then("User assert the go wefunder  button is clickable")
    public void userAssertTheGoWefunderButtonIsClickable() {
        Assert.assertTrue(getHomePage().goWefunderButton.isEnabled());


    }

    @When("User clicks on go wefunder button")
    public void userClicksOnGoWefunderButton() {

        JSutilities.clickElementByJS(getHomePage().goWefunderButton);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        String window1Handle = driver.getWindowHandle();
        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
    }
}