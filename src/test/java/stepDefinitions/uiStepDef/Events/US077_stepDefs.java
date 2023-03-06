package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

    public class US077_stepDefs extends CommonPage {
        /*
        @Then("User clicks My events Submit button")
        public void userClicksMyEventsSubmitButton() {
            BrowserUtilities.wait(3);
            BrowserUtilities.scrollAndClickWithJS(getEvent().submitButtonS);
            BrowserUtilities.scrollAndClickWithJS(getHomePage().ssubmitButton);
        }
    */
        @And("User clicks My Events link")
        public void userClicksMyEventsLink() {
            getEvent().MyEvents.click();

        }

        @And("User clicks Create New Event button")
        public void userClicksCreateNewEventButton() {
            getEvent().createNewAddressButton.click();
        }

        @And("User verifies  the Create Event Page")
        public void userVerifiesTheCreateEventPage() {
            Assert.assertTrue(getEvent().createEvent.isDisplayed());
        }

        @And("User clicks on the Add button")
        public void userClicksOnTheAddButton() {
            getEvent().addButton.click();
        }

        @And("User enters Adress info {string},{string},{string},{string},{string}")
        public void userEntersAdressInfo(String AddressTitle, String Address, String State, String City, String Postal) {
           BrowserUtilities.wait(1);
            getEvent().addressTitle.sendKeys(AddressTitle);

            getEvent().addressBox2.sendKeys(Address);
            getEvent().statesBox.sendKeys(State);
            getEvent().citiesBox.sendKeys(City);
            getEvent().postalBox.sendKeys(Postal);
        }

        @And("click Submit button")
        public void clickSubmitButton() {
            getEvent().submitButtonS.click();
        }

        @And("User fills the Create Event Page {string},{string},{string},{string},{string},{string},{string}")
        public void userFillsTheCreateEventPage(String Title, String Address, String Date, String Time, String Duration, String Attendee , String TersAndConditions) {
            getEvent().tittle.sendKeys(Title);
            getEvent().tittle.sendKeys(Title);
            getEvent().address2.sendKeys(Address);
            getEvent().Date.sendKeys(Date);
            BrowserUtilities.wait(1);
            getEvent().Time.sendKeys(Time);
            BrowserUtilities.wait(1);
            getEvent().Duration.sendKeys(Duration);
            BrowserUtilities.wait(1);
            getEvent().Attendee.sendKeys(Attendee);
            BrowserUtilities.wait(1);
            getEvent().TersAndConditions.sendKeys(TersAndConditions);
            BrowserUtilities.wait(1);

        }

        @And("User click Submit button")
        public void userClickSubmitButton() {
           BrowserUtilities.wait(3);
           BrowserUtilities.scrollAndClickWithJS(getEvent().submitButton);
          // BrowserUtilities.waitForClickable(getEvent().submitButton).click();
          // BrowserUtilities.waitForVisibility(getEvent().submitButton,2).click();
            // getEvent().submitButtonS.click();
        }



        @And("User clicks the Delete button on the My Scheduled Events page that open")
        public void userClicksTheDeleteButtonOnTheMyScheduledEventsPageThatOpen() {
           //BrowserUtilities.wait(2);
            BrowserUtilities.waitForClickable(getEvent().delete2Button).click();
            //BrowserUtilities.waitForClickable(getEvent().delete2Button);
            //getEvent().delete2Button.click();
        }

        @And("User sees {string} text")
        public void userSeesText(String string) {
            getEvent().h5.isDisplayed();
        }

        @And("User clicks the No button")
        public void userClicksTheNoButton() {
            getEvent().noButton.click();
        }


        @And("User clicks the Delete button on the My Schedulded Event page that open")
        public void userClicksTheDeleteButtonOnTheMyScheduldedEventPageThatOpen() {
            getEvent().delete2Button.click();
        }

        @And("User click the Yes button")
        public void userClickTheYesButton() {
            getEvent().yesButton.click();
        }

        @And("User sees {string} message")
        public void userSeesMessage
                (String string) {
            getEvent().alertDelete.isDisplayed();
        }

        @And("User sees {string} text and event is not in Scheduled Events List")
        public void userSeesTextAndEventIsNotInScheduledEventsList(String string) {

           Assert.assertTrue(getEvent().notScheduledEvents.isDisplayed());
        }
    }




