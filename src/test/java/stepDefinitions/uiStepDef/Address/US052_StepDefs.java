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


    @Then("user clicks the Add New Address")
    public void userClicksTheAddNewAddress() {
        getAddressPage().addNewAddressButton.click();
        BrowserUtilities.wait(1);
    }

    @Then("user clicks the Search Places box")
    public void userClicksTheSearchPlacesBox() {
        getAddressPage().searchPlacesBox.click();
        BrowserUtilities.wait(1);

    }

    @Then("user writes {string} in the box, sees addresses and select an address")
    public void userWritesInTheBoxSeesAddressesAndSelectAnAddress(String selectAddress) {
        getAddressPage().searchPlacesBox.sendKeys("Netherlands");
        BrowserUtilities.wait(1);
        getAddressPage().addressOptions.click();
        BrowserUtilities.wait(1);



    }

    @Then("user marks the Mark as sales address section on the page that opens")
    public void userMarksTheMarkAsSalesAddressSectionOnThePageThatOpens() {

        //getAddressPage().markSalesAddress.click();
        JSutilities.clickWithJS(getAddressPage().markSalesAddress);
        BrowserUtilities.wait(1);

    }

    @Then("user clicks Submit button on Address section")
    public void userClicksSubmitButtonOnAddressSection() {
        JSutilities.clickWithJS(getAddressPage().submitButtonToAddAddress);
        BrowserUtilities.wait(2);
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
//        Assert.assertTrue(getAddressPage().editButton.isDisplayed());
       BrowserUtilities.wait(2);
    }

    @And("user sees that the Remove button is clickable")
    public void userSeesThatTheRemoveButtonIsClickable() {
        JSutilities.clickWithJS(getAddressPage().removeButton);
       //getAddressPage().removeButton.click();
        BrowserUtilities.wait(2);
    }

//    @And("user clicks the Edit button")
//    public void userClicksTheEditButton() {
//        actions.sendKeys(Keys.END).perform();
//        getAddressPage().editButton.click();
//        Assert.assertTrue(getAddressPage().editButton.isDisplayed());
//        BrowserUtilities.wait(2);
//    }
//
//    @And("user clicks the Remove button")
//    public void userClicksTheRemoveButton() {
//        JSutilities.clickWithJS(getAddressPage().removeButton);
//        //getAddressPage().removeButton.click();
//        BrowserUtilities.wait(2);
//    }


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
    public void userVerifiesTheAlertShouldAppear(String alertSuccessfullyUpdated) {
        BrowserUtilities.wait(1);
        String expectedMessage = "Your Address successfully updated";
        String actualMessage = getAddressPage().alertYourAddressSuccessfully.getText();
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
       Assert.assertEquals(expectedMessage,actualMessage);
        Assert.assertTrue(getAddressPage().alertYourAddressSuccessfully.isDisplayed());
        BrowserUtilities.wait(5);
    }

    @Then("user {string} screen should be displayed")
    public void userScreenShouldBeDisplayed(String arg0) {
        BrowserUtilities.wait(1);
        Assert.assertTrue(getAddressPage().messageAreYouSureToDeleteTheAddress.isDisplayed());
        BrowserUtilities.wait(3);
    }

    @When("user should display {string} options")
    public void userShouldDisplayOptions(String arg0) {
        Assert.assertTrue(getAddressPage().yesButton.isDisplayed());
        BrowserUtilities.wait(3);
        Assert.assertTrue(getAddressPage().noButton.isDisplayed());
        BrowserUtilities.wait(3);
    }

    @And("user selects one of the {string} options")
    public void userSelectsOneOfTheOptions(String arg0) {
        //List<>
//        Assert.assertTrue(getAddressPage().yesButton.isEnabled());
//        Assert.assertTrue(getAddressPage().noButton.isEnabled());
    }

    @Then("user verifies that the address could not be removed")
    public void userVerifiesThatTheAddressCouldNotBeRemoved() {
        BrowserUtilities.wait(5);
        Assert.assertTrue(getAddressPage().notBeRemovedAddress.isDisplayed());
        BrowserUtilities.wait(5);
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
}
