package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import stepDefinitions.Hooks;
import utilities.BrowserUtilities;


public class US080_StepDefs extends CommonPage {

    String red = "rgba(255, 0, 0, 1)";


    @Given("The Contact us head at the top of the Welcome Page should appear")
    public void the_contact_us_head_at_the_top_of_the_welcome_page_should_appear() {

        Assert.assertEquals("Contact Us", getWelcomePage().contactUsButtonOnMainPage.getText());


        //  JavascriptExecutor je4 = (JavascriptExecutor) getDriver();
        // je4.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    @Given("Contact us head should be clickable")
    public void contact_us_head_should_be_clickable() {
        getWelcomePage().contactUsButtonOnMainPage.click();

        Assert.assertTrue(getWelcomePage().contactUsButtonOnMainPage.isDisplayed());

    }

    @Given("the Contact us head is clicked, the Get in Touch page should appear")
    public void the_contact_us_head_is_clicked_the_get_in_touch_page_should_appear() {

        Assert.assertEquals("GET IN TOUCH", getWelcomePage().getInTouchText.getText());


    }

    @Then("SEND MESSAGE is clicked without entering any information, alerts such as Please enter a valid name")
    public void send_message_is_clicked_without_entering_any_information_alerts_such_as_please_enter_a_valid_name() {

        getWelcomePage().sendMessageButton.click();
        Assert.assertEquals("", getWelcomePage().nameBox.getText());
        Assert.assertEquals("Please enter a valid name.", getWelcomePage().pleaseEnterAValidNameErrorMessage.getText());


        BrowserUtilities.assertTextColor(red, getWelcomePage().pleaseEnterAValidEmailErrorMessage); //find the error message by color


        Assert.assertEquals("", getWelcomePage().emailBoxInContactPage.getText());
        Assert.assertEquals("Please enter a valid email address.", getWelcomePage().pleaseEnterAValidEmailErrorMessage.getText());


        Assert.assertEquals("", getWelcomePage().messageBoxInContactPage.getText());
        Assert.assertEquals("", getWelcomePage().messageBoxInContactPage.getText());


    }

    @Then("Please enter a valid email address,")
    public void please_enter_a_valid_email_address() {

        getWelcomePage().emailBoxInContactPage.sendKeys(getWelcomePage().fakeEmailAddress);

        String s = getWelcomePage().emailBoxInContactPage.getText();

        // Assert.assertTrue(getWelcomePage().emailBoxInContactPage.getText().contains("@"));


    }

    @Then("Please enter a message with at least {int} characters.\" should be displayed.")
    public void please_enter_a_message_with_at_least_characters_should_be_displayed(Integer int1) {
        Assert.assertEquals("Please enter a message with at least 10 characters.", getWelcomePage().pleaseEnterAValidMessageErrorMessage.getText());



    }

}
