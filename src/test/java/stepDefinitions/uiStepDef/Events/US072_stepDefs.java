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


    @And("when user enter this info {string} ,{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void whenUserEnterThisInfo(String Title, String Address, String Date,
                                      String Time, String Fee, String Duration,
                                      String Attendee, String Schedule,
                                      String Description, String TersAndConditions) {

          getEvent().tittle.sendKeys(Title);
          getEvent().address2.sendKeys(Address);
          getEvent().Date.sendKeys(Date);
          getEvent().Time.sendKeys(Time);
          getEvent().Fee.sendKeys(Fee);
          getEvent().Duration.sendKeys(Duration);
          getEvent().Attendee.sendKeys(Attendee);
          getEvent().Schedule.sendKeys(Schedule);
          getEvent().Description.sendKeys(Description);
          getEvent().TersAndConditions.sendKeys(TersAndConditions);

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
