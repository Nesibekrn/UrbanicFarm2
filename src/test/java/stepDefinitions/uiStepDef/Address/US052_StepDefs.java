package stepDefinitions.uiStepDef.Address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;


import static stepDefinitions.Hooks.actions;

public class US052_StepDefs extends CommonPage {

    @Then("user clicks the Address button on left column")
    public void user_clicks_the_address_button_on_left_column() {
        getAddressPage().addressButton.click();
        BrowserUtilities.wait(1);
    }

    @When("user clicks the My Sales Address")
    public void userClicksTheMySalesAddress() {
        BrowserUtilities.wait(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        BrowserUtilities.wait(2);
        getAddressPage().mySalesAddressLink.click();
        BrowserUtilities.wait(2);
    }

    @And("user sees that the Edit button is clickable")
    public void userSeesThatTheEditButtonIsClickable() {

        actions.sendKeys(Keys.END).build().perform();
        //JSutilities.clickWithJS(getAddressPage().editButton);
        getAddressPage().editButton.click();
        Assert.assertTrue(getAddressPage().editButton.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @And("user sees that the Remove button is clickable")
    public void userSeesThatTheRemoveButtonIsClickable() {
        JSutilities.clickWithJS(getAddressPage().removeButton);
        //getAddressPage().removeButton.click();
        BrowserUtilities.wait(2);
    }


    @When("user change Zip number and clicks Submit button")
    public void userChangeZipNumberAndClicksSubmitButton() {
        getAddressPage().postalZipBox.click();
        BrowserUtilities.wait(4);
        BrowserUtilities.cleanTextFromWebelemnt(getAddressPage().postalZipBox);
        BrowserUtilities.wait(8);
        getAddressPage().postalZipBox.sendKeys("98651");
        BrowserUtilities.wait(4);
        //JSutilities.clickWithJS(getAddressPage().submitButton);
        getAddressPage().submitButton.click();
        BrowserUtilities.wait(1);
    }

    @When("user verifies the alert {string} should appear")
    public void userVerifiesTheAlertShouldAppear(String expectedAlert) {
        BrowserUtilities.wait(1);
        String actualMessage = getAddressPage().alertYourAddressSuccessfully.getText();
        Assert.assertEquals(expectedAlert,actualMessage);
        //Assert.assertTrue(getAddressPage().alertYourAddressSuccessfully.isDisplayed());
        BrowserUtilities.wait(5);
    }

    @Then("user {string} screen should be displayed")
    public void userScreenShouldBeDisplayed(String expectedMessage) {
        BrowserUtilities.wait(1);
        //Assert.assertTrue(getAddressPage().messageAreYouSureToDeleteTheAddress.isDisplayed());
        String actualMessage = getAddressPage().messageAreYouSureToDeleteTheAddress.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        BrowserUtilities.wait(3);
    }

    @When("user should display Yes-No options")
    public void userShouldDisplayYesNoOptions() {
        Assert.assertTrue(getAddressPage().yesButton.isDisplayed());
        BrowserUtilities.wait(2);
        Assert.assertTrue(getAddressPage().noButton.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @When("user selects one of the Yes-No options")
    public void user_selects_one_of_the_yes_no_options() {
        BrowserUtilities.wait(2);
        JSutilities.clickWithJS(getAddressPage().yesButton);

    }

    @Then("user verifies that the address could not be removed")
    public void userVerifiesThatTheAddressCouldNotBeRemoved() {
        BrowserUtilities.wait(2);
        Assert.assertTrue(getAddressPage().notBeRemovedMySalesAddress.isDisplayed());
//        System.out.println("getAddressPage().notBeRemovedAddress = " +
//                getAddressPage().notBeRemovedMySalesAddress);
    }


    @And("user clicks the No button")
    public void userClicksTheNoButton() {
        getAddressPage().noButton.click();
        BrowserUtilities.wait(1);
    }

    @And("user clicks the cancel button")
    public void userClicksTheCancelButton() {
        getAddressPage().cancelButton.click();
        BrowserUtilities.wait(1);
    }

    @And("user clicks the Edit button")
    public void userClicksTheEditButton() {
        BrowserUtilities.wait(1);
        actions.sendKeys(Keys.END).perform();
        getAddressPage().editButton.click();
        BrowserUtilities.wait(2);
    }

    @And("user clicks the Remove button")
    public void userClicksTheRemoveButton() {
        JSutilities.clickWithJS(getAddressPage().removeButton);
        //getAddressPage().removeButton.click();
        BrowserUtilities.wait(1);
    }

    @When("User add new address as my seller {string} if it is not exist")
    public void userAddNewAddressAsMySellerIfItIsNotExist(String address) {
        try {
            Assert.assertTrue(getAddressPage().editButton.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            getAddressPage().nonSelectedAddressButton.click();
            try { JSutilities.scrollToWebElement(getAddressPage().editButtonOnNonSelectedAddress);
                Assert.assertTrue(getAddressPage().editButtonOnNonSelectedAddress.isDisplayed());
                JSutilities.clickWithJS(getAddressPage().editButtonOnNonSelectedAddress);
                getAddressPage().markSalesAddress.click();
                getAddressPage().submitButtonToAddAddress.click();
                BrowserUtilities.wait(5);
                getAddressPage().mySalesAddressLink.click();
            } catch (Exception f) {
                f.printStackTrace();
                getAddressPage().addNewAddress(address);
                JSutilities.clickWithJS(getAddressPage().editButtonOnNonSelectedAddress);
                getAddressPage().markSalesAddress.click();
                getAddressPage().submitButtonToAddAddress.click();
                BrowserUtilities.wait(5);
                getAddressPage().mySalesAddressLink.click();
            }
        }
    }

}
