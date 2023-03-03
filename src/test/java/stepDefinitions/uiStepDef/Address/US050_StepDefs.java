package stepDefinitions.uiStepDef.Address;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

public class US050_StepDefs extends CommonPage {

    @Given("user logins to website")
    public void userLoginAsBuyer() {
        BrowserUtilities.loginMethod(

                ConfigurationReader.getProperty("us050Email"),
                ConfigurationReader.getProperty("us050Password")

        );

        BrowserUtilities.wait(5);
    }

    @When("User clicks Account Name Navbar")
    public void userClicksAccountNameNavbar() {

        do {
            try {
                Assert.assertTrue(getDeliveryPickupSettingsPage().deliveryPickUpSetting.isDisplayed());
                break;
            } catch (Exception e) {
                e.printStackTrace();

            }
            getHomePage().accountName_navbar.click();

        } while (true);
    }

    @Then("User clicks Address Button")
    public void user_click_address_button() {
        getAddressPage().addressButton.click();
        BrowserUtilities.wait(1);
    }

    @Then("User clicks Add New Address Button")
    public void user_click_add_new_address_button() {
        getAddressPage().addNewAddressButton.click();
        BrowserUtilities.wait(1);
    }

    @Then("User verify Search Places box")
    public void user_verify_search_places_box() {
        Assert.assertTrue(getAddressPage().searchBox.isDisplayed());
    }

    @And("User writes Paris in the box, sees addresses and select an address")
    public void userWritesParisInTheBoxSeesAddressesAndSelectAnAddress() {
        getAddressPage().searchBox.sendKeys("Paris");
        BrowserUtilities.wait(1);
        getAddressPage().addressOption.click();
    }

    @And("User clicks Submit Button on Address Section")
    public void userClicksSubmitButtonOnAddressSection() {
        BrowserUtilities.wait(2);
        getAddressPage().submitButtonToAddAddress.click();
        BrowserUtilities.wait(2);
    }

    @And("User verifies Alert Message {string} is displayed")
    public void userVerifiesAlertMessage(String alertMessage) {
        Assert.assertTrue(getAddressPage().alertAfterClickedSubmitButtonOnAddressSection.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @Then("User verifies that {string} alert is displayed on My Sales Address Section")
    public void userVerifiesThatAlertIsDisplayedOnMySalesAddressSection(String alertMessage) {
        getAddressPage().mySalesAddressButton.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getAddressPage().alertMessageAfterClickedMYSalesAddressButton.isDisplayed());
        BrowserUtilities.wait(1);
        getAddressPage().nonSelectedAddressButton.click();
    }

    @Then("User verifies that the address Edit and Remove buttons should be operational in the Unselected Address section")
    public void userVerifiesThatTheAddressEditAndRemoveButtonsShouldBeOperationalInTheUnselectedAddressSection() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(getAddressPage().editButtonOnNonSelectedAddress.isEnabled());
        Assert.assertTrue(getAddressPage().removeButtonOnNonSelectedAddress.isEnabled());
        // Daha dinamik yapilabilir mi?
    }

    @Then("User clicks Edit Button and changes Zip Number and clicks Submit Button")
    public void userClicksEditButtonAndChangesZipNumberAndClicksSubmitButton() {
        getAddressPage().editButtonOnNonSelectedAddress.click();
        getAddressPage().zipNumberBox.sendKeys("88000");
        getAddressPage().submitButtonToAddAddress.click();
    }

    @Then("User verifies that the alert {string} should appear")
    public void userVerifiesThatTheAlertShouldAppear(String arg0) {
        BrowserUtilities.wait(1);
        Assert.assertTrue(getAddressPage().alertAfterClickedSubmitButtonOnAddressSection.isDisplayed());
        BrowserUtilities.wait(3);
    }

    @Then("User verifies that Remove Button is clickable")
    public void userVerifiesThatRemoveButtonIsClickable() {
        Assert.assertTrue(getAddressPage().removeButtonOnNonSelectedAddress.isEnabled());
    }

    @Then("User verifies that {string} alert is displayed")
    public void userVerifiesThatAlertIsDisplayed(String arg0) {
        getAddressPage().removeButtonOnNonSelectedAddress.click();
        BrowserUtilities.wait(1);
        Assert.assertTrue(getAddressPage().alertAfterClickedRemoveButtonOnAddressSection.isDisplayed());
    }

    @Then("User verifies that Yes-No options must be selected")
    public void userVerifiesThatYesNoOptionsMustBeSelected() {
        Assert.assertTrue(getAddressPage().yesButtonAfterClickedRemoveButtonOnAddressSection.isEnabled());
        Assert.assertTrue(getAddressPage().noButtonAfterClickedRemoveButtonOnAddressSection.isEnabled());
    }

    @Then("User verifies that {string} option should cancel the action")
    public void userVerifiesThatOptionShouldCancelTheAction(String arg0) {
        getAddressPage().noButtonAfterClickedRemoveButtonOnAddressSection.click();
        // ?????
    }

    @Then("User verifies that {string} option should remove the address")
    public void userVerifiesThatOptionShouldRemoveTheAddress(String arg0) {
        getAddressPage().yesButtonAfterClickedRemoveButtonOnAddressSection.click();
    }

    @Then("User verifies that {string} warning should appear")
    public void userVerifiesThatWarningShouldAppear(String arg0) {
        BrowserUtilities.wait(1);
        Assert.assertTrue(getAddressPage().addressDeletedAlertMessageOnAddressSection.isDisplayed());
    }
}
