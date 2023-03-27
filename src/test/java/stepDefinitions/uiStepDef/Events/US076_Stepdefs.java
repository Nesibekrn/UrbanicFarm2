package stepDefinitions.uiStepDef.Events;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.BrowserUtilities.assertTextColor;

public class US076_Stepdefs extends CommonPage {
    String eventName;
    Response response;
    Integer eventId;

    int adressId;
    @Then("user clicks on events")
    public void userClicksOnEvents() {

        getEvent().eventsButton.click();

    }

    @And("user clicks on Register button on events page")
    public void userClicksOnRegisterButtonOnEventsPage() {

        for (int i = 0; i < getEvent().registerButton.size() ; i++) {
            if (Integer.parseInt(getEvent().availableSeatNumber.get(i).getText())>0 && (Integer.parseInt(getEvent().availableSeatNumber.get(i).getText())<=Integer.parseInt(getEvent().attendeeLimitNumber.get(i).getText()))){
                BrowserUtilities.scrollAndClickWithJS(getEvent().registerButton.get(i));
                BrowserUtilities.wait(1);
                if (!driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
                    eventName=getEvent().registeredEventName.getText();
                    break;
                }try{getEvent().alertCloseButton.click();}
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        if (driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {

            Map<String, Object> adressPayLoad = new HashMap<>();
            adressPayLoad.put("isDefault",false);
            adressPayLoad.put("isSellerAddress",false);
            adressPayLoad.put("address","Mavi");
            adressPayLoad.put("city","Bolu");
            adressPayLoad.put("postal","06152");
            adressPayLoad.put("state","Akdeniz");
            adressPayLoad.put("title","Online");
            adressPayLoad.put("emptyBasket?",false);
            response = given().contentType(ContentType.JSON).
                    spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).body(adressPayLoad).post("/account/address/addAddress");
            adressId = response.jsonPath().getInt("address.id");

            Map<String,Object> payLoad= new HashMap<>();
            payLoad.put("title", Faker.instance().name().title());
            payLoad.put("date",BrowserUtilities.getDateForFuture3(1)+"T23:59");
            payLoad.put("fee",1);
            payLoad.put("duration",50);
            payLoad.put("attendeeLimit",10);
            payLoad.put("addressId",adressId);
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
                    }getEvent().alertCloseButton.click();
                }
            }
        }

    }

    @Given("enter data and verifies approve button is disabled and frame color is red")
    public void enterDataAndVerifiesApproveButtonIsDisabledAndFrameColorIsRed(DataTable dataTable) {
        List<String> numberOfAttendee = dataTable.column(1);
        List<String> alertMessage = dataTable.column(2);
        List<String > color = dataTable.column(3);

        BrowserUtilities.wait(2);

        BrowserUtilities.cleanTextFromWebelemnt(getEvent().numberOfAttendeesBox);
        getEvent().numberOfAttendeesBox.sendKeys(Integer.parseInt(getEvent().numberOfAttendeesBox.getAttribute("min")) + Integer.parseInt(numberOfAttendee.get(0)) + "");
        Assert.assertEquals(alertMessage.get(0),getEvent().numberOfAttendeesBox.getAttribute("validationMessage"));
        Assert.assertEquals(color.get(0),getEvent().borderColor.getCssValue("box-shadow").split("\\.")[0]);
        Assert.assertFalse(getEvent().approveButton.isEnabled());
        BrowserUtilities.wait(1);

        BrowserUtilities.cleanTextFromWebelemnt(getEvent().numberOfAttendeesBox);
        Assert.assertEquals(alertMessage.get(1),getEvent().numberOfAttendeesBox.getAttribute("validationMessage"));
        Assert.assertEquals(color.get(1),getEvent().borderColor.getCssValue("box-shadow").split("\\.")[0]);
        Assert.assertFalse(getEvent().approveButton.isEnabled());
        BrowserUtilities.wait(1);

        BrowserUtilities.cleanTextFromWebelemnt(getEvent().numberOfAttendeesBox);
        getEvent().numberOfAttendeesBox.sendKeys(numberOfAttendee.get(2));
        BrowserUtilities.wait(1);
        Assert.assertEquals(alertMessage.get(2),getEvent().numberOfAttendeesBox.getAttribute("validationMessage"));
        Assert.assertEquals(color.get(2),getEvent().borderColor.getCssValue("box-shadow").split("\\.")[0]);
        Assert.assertFalse(getEvent().approveButton.isEnabled());
        BrowserUtilities.wait(1);

        BrowserUtilities.cleanTextFromWebelemnt(getEvent().numberOfAttendeesBox);
        getEvent().numberOfAttendeesBox.sendKeys(Integer.parseInt(getEvent().numberOfAttendeesBox.getAttribute("max")) + Integer.parseInt(numberOfAttendee.get(3)) + "");
        Assert.assertTrue(getEvent().numberOfAttendeesBox.getAttribute("validationMessage").contains(alertMessage.get(3)));
        Assert.assertEquals(color.get(3),getEvent().borderColor.getCssValue("box-shadow").split("\\.")[0]);
        Assert.assertFalse(getEvent().approveButton.isEnabled());
        BrowserUtilities.wait(1);

        BrowserUtilities.cleanTextFromWebelemnt(getEvent().numberOfAttendeesBox);
        getEvent().numberOfAttendeesBox.sendKeys(numberOfAttendee.get(4));
        Assert.assertEquals(color.get(4),getEvent().borderColor.getCssValue("box-shadow").split("\\.")[0]);
        Assert.assertFalse(getEvent().approveButton.isEnabled());
        BrowserUtilities.wait(1);
    }

    @When("User doesn't click to checkbox approve button is disabled")
    public void userDoesnTClickToCheckboxApproveButtonIsDisabled() {
        Assert.assertFalse(getEvent().iAcceptTheTermsAndConditionsCheckBox.isSelected());
        Assert.assertFalse(getEvent().approveButton.isEnabled());
    }

    @Then("User clicks to checkbox")
    public void userClicksToCheckbox() {
        getEvent().iAcceptTheTermsAndConditionsCheckBox.click();
    }

    @And("User clicks to approve button")
    public void userClicksToApproveButton() {
        getEvent().approveButton.click();
        BrowserUtilities.wait(5);
        if(driver.getWindowHandles().size()>1){
            BrowserUtilities.switchToWindow(1);

            if (BrowserUtilities.isDisplayed(commonPage.getCartPage().paypal_btnLogin_up)) {
                JSutilities.clickWithJS(getCartPage().paypal_btnLogin_up);
                BrowserUtilities.wait(3);
            }
            if (BrowserUtilities.isDisplayed(commonPage.getPayPalPage().email)) {
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
    @And("User clicks to register button of registered event")
    public void userClicksToRegisterButtonOfRegisteredEvent() {
        BrowserUtilities.wait(1);
        try{BrowserUtilities.scrollAndClickWithJS(getEvent().registerButton.get(1));}catch(Exception e){
            e.printStackTrace();
        }
    }
    @And("User verifies {string} alert is disabled")
    public void userVerifiesAlertIsDisabled(String alert) {
        BrowserUtilities.wait(1);
        Assert.assertEquals(alert,getEvent().alert.getText());
        Map<String,Integer> payLoad2=new HashMap<>();
        payLoad2.put("eventId",eventId);
        response=given().spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).formParams(payLoad2).post("/account/event/delete");
        response.prettyPrint();

        Map<String,Object> adressDeletePayload =new HashMap<>();
        adressDeletePayload.put("addressId",adressId);
        response=given().contentType(ContentType.JSON)
                .spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer")))
                .body(adressDeletePayload).post("/account/address/delete");

    }
    }



