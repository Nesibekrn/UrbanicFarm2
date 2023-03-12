package stepDefinitions.uiStepDef.Events;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static stepDefinitions.Hooks.*;
import static utilities.ApiUtilities.requestSpecification;

public class US075_StepDefs extends CommonPage {

    String eventName;
    Response response;
    Integer eventId;


    @And("User clicks on register")
    public void UserClicksOnRegister() {
        for (int i = 0; i < getEvent().registerButton.size() ; i++) {
            if (Integer.parseInt(getEvent().availableSeatNumber.get(i).getText())>0 && (Integer.parseInt(getEvent().availableSeatNumber.get(i).getText())<=Integer.parseInt(getEvent().attendeeLimitNumber.get(i).getText()))){
                BrowserUtilities.scrollAndClickWithJS(getEvent().registerButton.get(i));
                BrowserUtilities.wait(1);
                if (!driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
                    eventName=getEvent().registeredEventName.getText();
                    break;
                }
            }
        }
        if (driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
            /* Create Event Yöntem-2
            BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerTokenOmer"), "account/events-i-organize");
            getEvent().createNewEventButton.click();
            BrowserUtilities.wait(1);
            getEvent().tittle.sendKeys(Faker.instance().name().title());
            BrowserUtilities.wait(1);

            Select select = new Select(getEvent().addressBox);
            select.selectByIndex(1);
            BrowserUtilities.wait(1);
            getEvent().dateBox.sendKeys(BrowserUtilities.getDateForFuture2(1));
            BrowserUtilities.wait(1);
            getEvent().timeBox.sendKeys(BrowserUtilities.getTimeForFuture(0)+"P");
            BrowserUtilities.wait(1);
            getEvent().feeeBox.sendKeys("1");
            BrowserUtilities.wait(1);
            getEvent().durationBox.sendKeys("30");
            BrowserUtilities.wait(1);
            getEvent().attendeeLimitBox.sendKeys("40");
            BrowserUtilities.wait(1);
            getEvent().termsAndConditionsBox.sendKeys("Agree");
            BrowserUtilities.wait(1);
            BrowserUtilities.scrollAndClickWithJS(getEvent().submitButton);
            BrowserUtilities.wait(5);

           BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("buyerToken"), "account/events");
             */

            Map<String,Object> payLoad= new HashMap<>();
            payLoad.put("title",Faker.instance().name().title());
            payLoad.put("date",BrowserUtilities.getDateForFuture3(1)+"T23:59");
            payLoad.put("fee",1);
            payLoad.put("duration",50);
            payLoad.put("attendeeLimit",10);
            payLoad.put("addressId",764);
            payLoad.put("tac","null");
            response=given().spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).formParams(payLoad).post("/account/event/create");
            response.prettyPrint();
            eventId=response.jsonPath().getInt("event.id");
            driver.navigate().refresh();
            BrowserUtilities.waitForPageToLoad(10);
            for (int j = 0; j < getEvent().registerButton.size(); j++) {
                if (Integer.parseInt(getEvent().availableSeatNumber.get(j).getText()) > 0 && (Integer.parseInt(getEvent().availableSeatNumber.get(j).getText()) <= Integer.parseInt(getEvent().attendeeLimitNumber.get(j).getText()))) {
                    BrowserUtilities.scrollAndClickWithJS(getEvent().registerButton.get(j));
                    BrowserUtilities.wait(1);
                    if (!driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
                        eventName = getEvent().registeredEventName.getText();
                        break;
                    }
                }
            }
        }

    }

    @And("User clicks on Terms and conditions box")
    public void UserClicksOnTermsAndConditionsBox() {
        BrowserUtilities.wait(2);
        BrowserUtilities.scrollAndClickWithJS(getEvent().termsAndConditionsCheckBox);
    }

    @And("User clicks on Approve button")
    public void UserClicksOnApproveButton() {
        BrowserUtilities.wait(2);
        BrowserUtilities.scrollAndClickWithJS(getEvent().approveButton);
        BrowserUtilities.wait(2);
        if(driver.getWindowHandles().size()>1){

            BrowserUtilities.switchToWindow(1);

            if (BrowserUtilities.isDisplayed(commonPage.getCartPage().paypal_btnLogin_up)) {
                commonPage.getCartPage().paypal_btnLogin_up.click();
                BrowserUtilities.wait(3);
            }


            if (BrowserUtilities.isDisplayed(commonPage.getPayPalPage().email)) {

//            BrowserUtilities.cleanTextFromWebelemnt(commonPage.getPayPalPage().email);
                commonPage.getPayPalPage().email.clear();
                commonPage.getPayPalPage().email.sendKeys(ConfigurationReader.getProperty("paypal_username"));


                if (BrowserUtilities.isDisplayed(commonPage.getPayPalPage().password)) {
                    commonPage.getPayPalPage().password.sendKeys(ConfigurationReader.getProperty("paypal_password"));
                } else {
                    commonPage.getCartPage().next.click();
                    commonPage.getPayPalPage().password.sendKeys(ConfigurationReader.getProperty("paypal_password"));
                }
                BrowserUtilities.scrollAndClickWithJS(commonPage.getCartPage().paypal_btnLogin_down);
            }
            BrowserUtilities.scrollAndClickWithJS(commonPage.getPayPalPage().payment_submit_btn);
        }
    }
    @Then("User verifies valid registered message {string} if the event free")
    public void UserVerifiesValidRegisteredMessageIfTheEventFree(String alert) {
        if(driver.getWindowHandles().size()==1) {
            BrowserUtilities.waitForVisibility(getEvent().registeredMessage, 5);
            Assert.assertEquals(alert, getEvent().registeredMessage.getText());
        }

    }

    @Then("User verifies valid registered message {string} if the event required fee")
    public void UserVerifiesValidRegisteredMessageIfTheEventRequiredFee(String alert) {
        if(driver.getWindowHandles().size()>1) {
            BrowserUtilities.waitForVisibility(getEvent().registeredMessage, 5);
            Assert.assertEquals(alert, getEvent().registeredMessage.getText());
            BrowserUtilities.switchToWindow(0);
        }
    }

    @Then("User should see the event on the Registered Events page")
    public void UserShouldSeeTheEventOnTheRegisteredEventsPage() {

        getEvent().registeredEventsButton.click();

        BrowserUtilities.wait(2);
        Assert.assertTrue(getEvent().registeredEvents.stream().anyMatch(t->t.getText().equals(eventName)));
        BrowserUtilities.wait(2);
        /*
        //YÖNTEM-2
        List<String> registeredEventsNames= new ArrayList<>();
        for (int i = 0; i < getEvent().registeredEvents.size(); i++) {
            registeredEventsNames.add(getEvent().registeredEvents.get(i).getText());
        }
        Assert.assertTrue(registeredEventsNames.stream().anyMatch(t->t.equals(eventName)));
         */

        Map<String,Integer> payLoad2=new HashMap<>();
        payLoad2.put("eventId",eventId);
        response=given().spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).formParams(payLoad2).post("/account/event/delete");
        response.prettyPrint();
        /* Delete Event Yöntem-2
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerTokenOmer"), "account/events-i-organize");
        try{getEvent().deleteButton.click();}
        catch (Exception e ){
            e.printStackTrace();
        }
         */
    }



}
