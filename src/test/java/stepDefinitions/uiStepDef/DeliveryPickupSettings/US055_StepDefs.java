package stepDefinitions.uiStepDef.DeliveryPickupSettings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US055_StepDefs extends CommonPage {
    @And("user clicks Buyer Picks Up checkbox")
    public void userClicksBuyerPicksUpCheckbox() {
        if(getDeliveryPickupSettingsPage().buyerPickUp.isSelected()){
            System.out.println("Buyer Pick Up Checkbox is selected.");
        }else{
            getDeliveryPickupSettingsPage().buyerPickUp.click();
        }


        if(getDeliveryPickupSettingsPage().sellerFlexible.isSelected()) {
            getDeliveryPickupSettingsPage().sellerFlexible.click();
        }


        if(getDeliveryPickupSettingsPage().sellerDelivery.isSelected()){
            getDeliveryPickupSettingsPage().sellerDelivery.click();
        }



    }

    @And("user verifies Your available hours is visible")
    public void userVerifiesYourAvailableHoursIsVisible() {
        Assert.assertTrue(getDeliveryPickupSettingsPage().pickUp_StartTime.isDisplayed());
        Assert.assertTrue(getDeliveryPickupSettingsPage().pickUp_EndTime.isDisplayed());
    }

    @And("user verifies Your available hours is functional")
    public void userVerifiesYourAvailableHoursIsFunctional() {
        Assert.assertTrue(getDeliveryPickupSettingsPage().pickUp_StartTime.isEnabled());
        Assert.assertTrue(getDeliveryPickupSettingsPage().pickUp_EndTime.isEnabled());    }

    @And("user clicks on start time and enter a valid time in Buyer Pick Up")
    public void userClicksOnStartTimeAndEnterAValidTimeInBuyerPickUp() {
        getDeliveryPickupSettingsPage().pickUp_StartTime.sendKeys("1040");
    }

    @And("user clicks on end time and enter a valid time in Buyer Pick Up")
    public void userClicksOnEndTimeAndEnterAValidTimeInBuyerPickUp() {
        getDeliveryPickupSettingsPage().pickUp_EndTime.sendKeys("1240");
    }

    @And("user clicks on start time and enter an invalid time in Buyer Pick Up")
    public void userClicksOnStartTimeAndEnterAnInvalidTimeInBuyerPickUp() {
        getDeliveryPickupSettingsPage().pickUp_StartTime.sendKeys("1240");
    }

    @And("user clicks on end time and enter an invalid time in Buyer Pick Up")
    public void userClicksOnEndTimeAndEnterAnInvalidTimeInBuyerPickUp() {
        getDeliveryPickupSettingsPage().pickUp_EndTime.sendKeys("1040");
    }

    @Then("user verifies the valid message {string}")
    public void userVerifiesTheValidMessage(String alert) {
        BrowserUtilities.waitForVisibility(getDeliveryPickupSettingsPage().alertText,5);
        Assert.assertEquals(alert,getDeliveryPickupSettingsPage().alertText.getText());

    }
}
