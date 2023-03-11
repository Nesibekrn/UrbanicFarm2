package stepDefinitions.uiStepDef.Events;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.*;

public class US075_StepDefs extends CommonPage {

    String eventName;

    @And("user clicks on register")
    public void userClicksOnRegister() {
        for (int i = 0; i < getEvent().registerButton.size() ; i++) {
            if (Integer.parseInt(getEvent().availableSeatNumber.get(i).getText())>0 && (Integer.parseInt(getEvent().availableSeatNumber.get(i).getText())<=Integer.parseInt(getEvent().attendeeLimitNumber.get(i).getText()))){
                BrowserUtilities.wait(1);
                BrowserUtilities.scrollAndClickWithJS(getEvent().registerButton.get(i));
                if (!driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
                    eventName=getEvent().registeredEventName.getText();
                    break;
                }

            }
        }
        if (driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
            BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerTokenOmer"), "account/events-i-organize");
            getEvent().createNewEventButton.click();
            BrowserUtilities.wait(1);
            getEvent().tittle.sendKeys(Faker.instance().name().title());
            BrowserUtilities.wait(1);

            Select select = new Select(getEvent().addressBox);
            select.selectByIndex(1);
            BrowserUtilities.wait(1);
            getEvent().dateBox.sendKeys("12.03.2023");
            BrowserUtilities.wait(1);
            getEvent().timeBox.sendKeys("15.00");
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
            for (int j = 0; j < getEvent().registerButton.size(); j++) {
                if (Integer.parseInt(getEvent().availableSeatNumber.get(j).getText()) > 0 && (Integer.parseInt(getEvent().availableSeatNumber.get(j).getText()) <= Integer.parseInt(getEvent().attendeeLimitNumber.get(j).getText()))) {
                    BrowserUtilities.wait(1);
                    BrowserUtilities.scrollAndClickWithJS(getEvent().registerButton.get(j));
                    if (!driver.getCurrentUrl().equals("https://test.urbanicfarm.com/account/events")) {
                        eventName = getEvent().registeredEventName.getText();
                        break;
                    }
                }
            }
        }

    }

    @And("user clicks on Terms and conditions box")
    public void userClicksOnTermsAndConditionsBox() {
        BrowserUtilities.wait(2);
        BrowserUtilities.scrollAndClickWithJS(getEvent().termsAndConditionsCheckBox);
        BrowserUtilities.wait(2);
    }

    @And("user clicks on Approve button")
    public void userClicksOnApproveButton() {
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


                    //Assert.fail("2. senaryo olan passsword un farkli sayfada gelmesi gerceklesti");
                }

                BrowserUtilities.scrollAndClickWithJS(commonPage.getCartPage().paypal_btnLogin_down);

            }

            BrowserUtilities.scrollAndClickWithJS(commonPage.getPayPalPage().payment_submit_btn);

           //BrowserUtilities.waitForClickable(commonPage.getPayPalPage().paymentSuccesfull);
            //BrowserUtilities.switchToWindow();

        }

    }
    @Then("user verifies valid registered message {string} if the event free")
    public void userVerifiesValidRegisteredMessageIfTheEventFree(String alert) {
        if(driver.getWindowHandles().size()==1) {
            BrowserUtilities.waitForVisibility(getEvent().registeredMessage, 5);
            Assert.assertEquals(alert, getEvent().registeredMessage.getText());
        }

    }

    @Then("user verifies valid registered message {string} if the event required fee")
    public void userVerifiesValidRegisteredMessageIfTheEventRequiredFee(String alert) {
        if(driver.getWindowHandles().size()>1) {
            BrowserUtilities.waitForVisibility(getEvent().registeredMessage, 5);
            Assert.assertEquals(alert, getEvent().registeredMessage.getText());
            BrowserUtilities.switchToWindow(0);
        }
    }

    @Then("user should see the event on the Registered Events page")
    public void userShouldSeeTheEventOnTheRegisteredEventsPage() {

        getEvent().registeredEventsButton.click();

        Assert.assertTrue(getEvent().registeredEvents.stream().anyMatch(t->t.getText().equals(eventName)));
        /*
        //YÖNTEM-2
        List<String> registeredEventsNames= new ArrayList<>();
        for (int i = 0; i < getEvent().registeredEvents.size(); i++) {
            registeredEventsNames.add(getEvent().registeredEvents.get(i).getText());
        }
        Assert.assertTrue(registeredEventsNames.stream().anyMatch(t->t.equals(eventName)));
         */

    }



}
