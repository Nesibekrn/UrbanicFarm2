package stepDefinitions.uiStepDef.DeliveryPickupSettings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import static stepDefinitions.Hooks.driver;

public class US054_StepDefs extends CommonPage {

    @And("User clicks login button on the home page")
    public void userClicksLoginButtonOnTheHomePage() {
        getDeliveryPickupSettingsPage().loginButton.click();
    }

    @And("User enters a valid email {string}")
    public void userEntersAValidEmail(String arg0) {
        getDeliveryPickupSettingsPage().email.sendKeys(ConfigurationReader.getProperty("us050Email"));

    }

    @And("user enters valid password {string}")
    public void userEntersValidPassword(String arg0) {
        getDeliveryPickupSettingsPage().passWord.sendKeys(ConfigurationReader.getProperty("us050Password"));

    }
    @Given("user clicks on name Nilanka beside the logout button")
    public void userClicksOnNameNilankaBesideTheLogoutButton() {
        BrowserUtilities.wait(3);
        getDeliveryPickupSettingsPage().nilanka.click();

    }

    @And("user verifies that current url is {string}")
    public void userVerifiesThatCurrentUrlIs(String url) {
        BrowserUtilities.wait(3);
        Assert.assertEquals(url,driver.getCurrentUrl());
    }

    @And("user clicks on Delivery & Pick up settings")
    public void userClicksOnDeliveryPickUpSettings() {
        BrowserUtilities.wait(3);
        getDeliveryPickupSettingsPage().deliveryAndPickUpSettings.click();

    }

    @And("user clicks on Buyer picks up on the vine option")
    public void userClicksOnBuyerPicksUpOnTheVineOption() {
        BrowserUtilities.wait(3);
        if (getDeliveryPickupSettingsPage().availableTime.getAttribute("style").equals("display: none;"))
            getDeliveryPickupSettingsPage().buyerPicksUpOnTheVine.click();


    }

    @And("user verifies Your available hours functional")
    public void userVerifiesYourAvailableHoursFunctional() {
        BrowserUtilities.verifyElementEnabled(getDeliveryPickupSettingsPage().startTime);
        BrowserUtilities.verifyElementEnabled(getDeliveryPickupSettingsPage().endTime);
        System.out.println(getDeliveryPickupSettingsPage().startTime.getText());
        System.out.println(getDeliveryPickupSettingsPage().endTime.getText());

    }

    @And("user verifies Your available hours visible")
    public void userVerifiesYourAvailableHoursVisible() {
        BrowserUtilities.verifyElementEnabled(getDeliveryPickupSettingsPage().yourAvailableHours);
    }


    //  ????
    @And("user clicks on start time and enter the time")
    public void userClicksOnStartTimeAndEnterTheTime() {
        BrowserUtilities.wait(3);
        getDeliveryPickupSettingsPage().startTime.sendKeys("0602am");
        // getDeliveryPickupSettingsPage().startTime.click()

    }

    @And("user clicks on end time and enter the time")
    public void userClicksOnEndTimeAndEnterTheTime() {
        BrowserUtilities.wait(3);
        getDeliveryPickupSettingsPage().endTime.sendKeys("0602pm");
    }

    @Then("user clicks on update button")
    public void userClicksOnUpdateButton() {
        BrowserUtilities.wait(3);
        getDeliveryPickupSettingsPage().upDate.click();

    }

    @Then("user verifies the message {string}")
    public void userVerifiesTheMessage(String alert) {
        // BrowserUtilities.wait(3);

        BrowserUtilities.waitForVisibility(getDeliveryPickupSettingsPage().yourDeliverySettingsHaveBeenSuccessfullyUpdate,3);
        Assert.assertEquals(alert,getDeliveryPickupSettingsPage().yourDeliverySettingsHaveBeenSuccessfullyUpdate.getText());


    }

}

