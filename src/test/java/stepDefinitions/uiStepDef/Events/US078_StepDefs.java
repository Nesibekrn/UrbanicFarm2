package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US078_StepDefs extends CommonPage {
    @And("User clicks Cancel button and verifies seeing {string} message")
    public void userClicksCancelButtonAndVerifiesSeeingMessage(String arg0) {
        BrowserUtilities.wait(5);
        getEvent().cancelButton.click();
        BrowserUtilities.wait(3);
        getEvent().yesButtonForCancellation.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getEvent().toastMessageOfEventCancelled.isDisplayed());
    }

    @Then("User verifies seeing of Canceled sign")
    public void userVerifiesSeeingOfCanceledSign() {
        Assert.assertTrue(getEvent().canceledSignMessage.isDisplayed());
        getEvent().alertCloseButton.click();
    }

    @And("User clicks Mark as Completed button and verifies seeing {string} message")
    public void userClicksMarkAsCompletedButtonAndVerifiesSeeingMessage(String arg0) {
        getEvent().markAsCompletedButton.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getEvent().toastMessageOfEventMarkedAsCompleted.isDisplayed());
        getEvent().alertCloseButton.click();

    }

    @Then("User verifies seeing of Completed sign")
    public void userVerifiesSeeingOfCompletedSign() {
        getEvent().myCompletedEventsTab.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getEvent().completedSignMessage.isDisplayed());
    }

    @And("User clicks Copy Link button and verifies seeing {string} message")
    public void userClicksCopyLinkButtonAndVerifiesSeeingMessage(String arg0) {
        BrowserUtilities.wait(3);
        getEvent().copyLinkButton.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getEvent().toastMessageOfEventLinkCopied.isDisplayed());
    }

    @Then("User clicks Close toast message about creation of Event")
    public void userClicksCloseToastMessageAboutCreationOfEvent() {
        BrowserUtilities.wait(2);
        getEvent().alertCloseButton.click();

    }

    @Then("User clicks Submit button to success new page")
    public void userClicksSubmitButtonToSuccessNewPage() {
        BrowserUtilities.scrollAndClickWithJS(getEvent().submitButton);
        BrowserUtilities.waitForVisibility(getEvent().closeOfToastMessageAboutCreationOfEvent, 8);
    }

//    @Then("User clicks Submit button to create Event")
//    public void userClicksSubmitButtonToCreateEvent() {
////        getEvent().submit2Button.click();
//        BrowserUtilities.scrollAndClickWithJS(getHomePage().ssubmitButton);
//    }
}
