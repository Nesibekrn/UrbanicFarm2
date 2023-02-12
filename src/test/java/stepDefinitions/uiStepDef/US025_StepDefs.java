package stepDefinitions.uiStepDef;

import pages.CommonPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;

    public class US025_StepDefs extends CommonPage {

        @And("user clicks on phone")
        public void userClicksOnPhone() {
            BrowserUtilities.wait(5);
            BrowserUtilities.scrollToElement(getHomePage().phoneHomePage);
            getHomePage().phoneHomePage.click();

        }

        @Then("user verifies that {string} box is visible")
        public void userVerifiesThatBoxIsVisible(String arg0) {
            // driver.switchTo().alert().dismiss();


        }
    }

