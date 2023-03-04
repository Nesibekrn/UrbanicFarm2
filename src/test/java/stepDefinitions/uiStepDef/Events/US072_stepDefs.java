package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

public class US072_stepDefs extends CommonPage {



    @And("User goes to My Event page")
    public void userGoesToMyEventPage() {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerTokenOmer"),"account/events-i-organize");
    }



    @Given("User goes to click Create New Event")
    public void userGoesToClickCreateNewEvent() {
        getEvent().createNewAddressButton.click();
    }


    @And("when user enter this info {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void whenUserEnterThisInfo(String Title, String Address, String Date,
                                      String Time, String Fee, String Duration,
                                      String Attendee, String Schedule,
                                      String Description, String TersAndConditions) {

        getEvent().tittle.sendKeys(Title);
        BrowserUtilities.wait(1);
        getEvent().tittle.sendKeys(Title);
        BrowserUtilities.wait(1);
        getEvent().address2.sendKeys(Address);
        BrowserUtilities.wait(1);
        getEvent().Date.sendKeys(Date);
        BrowserUtilities.wait(1);
        getEvent().Time.sendKeys(Time);
        BrowserUtilities.wait(1);
        getEvent().Fee.sendKeys(Fee);
        BrowserUtilities.wait(1);
        getEvent().Duration.sendKeys(Duration);
        BrowserUtilities.wait(1);
        getEvent().Attendee.sendKeys(Attendee);
        BrowserUtilities.wait(1);
        getEvent().Schedule.sendKeys(Schedule);
        BrowserUtilities.wait(1);
        getEvent().Description.sendKeys(Description);
        BrowserUtilities.wait(1);
        getEvent().TersAndConditions.sendKeys(TersAndConditions);
        BrowserUtilities.wait(1);

    }


    @Then("User  check alert message{string},{string}")
    public void userCheckAlertMessage(String AlertMessage, String numberConvert) {

        String alertMessage[]=AlertMessage.split(",");

         int size=Integer.parseInt(numberConvert);

        for ( String  message : alertMessage) {

        Assert.assertTrue(getEvent().allAlertMessageText.stream().anyMatch(t->t.getText().equals(message)));

        }

        Assert.assertEquals(getEvent().allAlertMessageText.size(), size);

    }


}
