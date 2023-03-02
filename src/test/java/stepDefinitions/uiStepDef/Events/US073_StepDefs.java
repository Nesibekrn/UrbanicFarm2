package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

public class US073_StepDefs extends CommonPage {

    @And("User click on Add button")
    public void userClickOnAddButton() {
        BrowserUtilities.scrollAndClickWithJS(getEvent().AddButton);
//        getEvent().AddButton.click();

    }
    @And("when user enter this info {string} ,{string},{string},{string},{string}")
    public void whenUserEnterThisInfo(String AddressTitle, String Address, String State, String City, String ZipCode) {
        getEvent().AddressTitle.sendKeys(AddressTitle);
        getEvent().Address3.sendKeys(Address);
        getEvent().States.sendKeys(State);
        getEvent().City.sendKeys(City);
        getEvent().PostalCode.sendKeys(ZipCode);

    }
    @Then("User clicks My events Submit button")
    public void userClicksMyEventsSubmitButton() {
        BrowserUtilities.wait(3);
        BrowserUtilities.scrollAndClickWithJS(getEvent().submitButtonS);
    }
//     this message is not display
//    @Then("user verifies the  {string} message")
//    public void userVerifiesTheMessage(String arg0) {
//
//
//    }


    @And("User click on Address button")
    public void userClickOnAddressButton() {
        BrowserUtilities.scrollAndClickWithJS(getEvent().accountAddress);
    }

    @And("user goes to bottom of the page")
    public void userGoesToBottomOfThePage() {
        BrowserUtilities.wait(3);
        JSutilities.scrollToBottom();
        BrowserUtilities.wait(5);
    }

    @Then("user verifies that Added address is display")
    public void userVerifiesThatAddedAddressIsAppear() {
//        Assert.assertTrue();
//        Assert.assertEquals(getEvent().confAddress.getText(),);
        Assert.assertTrue(getEvent().confAddress.isDisplayed());


    }
}