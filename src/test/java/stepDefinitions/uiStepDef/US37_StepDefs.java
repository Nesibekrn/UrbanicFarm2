package stepDefinitions.uiStepDef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.Set;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class US37_StepDefs extends CommonPage {
    @When("User clicks Forgot Password Link")
    public void user_clicks_forgot_password_link() {
        getLoginPage().forgotPasswordLink.click();
    }
    @Then("User verifies Please verify your email Text is visible")
    public void user_verifies_please_verify_your_email_text_is_visible() {
        Assert.assertTrue(getLoginPage().pleaseVerifyYourEmailText.isDisplayed());
    }
    @Then("User enters a valid email")
    public void user_enters_a_valid_email() {
        getLoginPage().pleaseVerifyYourEmailBox.sendKeys("nyz123@yopmail.com");
    }
    @Then("User clicks Verify Email Button")
    public void user_clicks_verify_email_button() {
        getLoginPage().verifyEmailButton.click();
    }
    @Then("User verifies {string} message is visible")
    public void user_verifies_message_is_visible(String message) {
        try {
            Assert.assertEquals(message,getLoginPage().weHaveSentResetLinkMessage.getText());
        }catch (Exception e){
            getHomePage().registerLink.click();
            getRegisterPage().firstNameBox.sendKeys("Niyaz");
            getRegisterPage().lastNameBox.sendKeys("cskn");
            getRegisterPage().emailBox.sendKeys("nyz123@yopmail.com");
            getRegisterPage().passwordRegistrationBox.sendKeys("A12345z.");
            getRegisterPage().confirmPasswordRegistrationBox.sendKeys("A12345z.");
            getRegisterPage().submitRegistrationButton.click();
            Assert.assertTrue(getHomePage().welcomeTheUrbanicFarmWindowText.isDisplayed());
            getHomePage().welcomeTheUrbanicFarmWindowCloseButton.click();
            getHomePage().logoutButton.click();
            getHomePage().loginButton.click();
            getLoginPage().forgotPasswordLink.click();
            getLoginPage().pleaseVerifyYourEmailBox.sendKeys("nyz123@yopmail.com");
            getLoginPage().verifyEmailButton.click();
        }
    }
    @Then("User clicks Reset Your Password Link on the yopmail")
    public void user_clicks_reset_your_password_link_on_the_yopmail() {
        driver.get("https://yopmail.com/");
        getYopMail().emailBoxYopmail.sendKeys(Keys.END);
        BrowserUtilities.cleanTextInBox(getYopMail().emailBoxYopmail);
        getYopMail().emailBoxYopmail.sendKeys("nyz123");
        getYopMail().arrowYopmail.click();
        driver.switchTo().frame(2);
        BrowserUtilities.wait(2);
        actions.sendKeys(Keys.END);
        getYopMail().resetYourPasswordYopmailLink.click();
    }
    @Then("User verifies Change Password title")
    public void user_verifies_change_password_title() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        String window1Handle=driver.getWindowHandle();
        for (String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        Assert.assertTrue(getLoginPage().changePasswordTitle.isDisplayed());
    }
    @Then("User enters a valid new password into the New Password box and Confirm Password box")
    public void user_enters_a_valid_new_password_into_the_new_password_box_and_confirm_password_box() {
        getRegisterPage().passwordRegistrationBox.sendKeys("B12345z.");
        getRegisterPage().confirmPasswordRegistrationBox.sendKeys("B12345z.");
    }
    @Then("User clicks submit button")
    public void user_clicks_submit_button() {
        getRegisterPage().submitRegistrationButton.click();
    }
    @Then("User verifies {string} alert is displayed")
    public void user_verifies_alert_is_displayed(String alert) {
        BrowserUtilities.waitForVisibility(getLoginPage().alertText,3);
        Assert.assertEquals(alert,getLoginPage().alertText.getText());
    }
    @Then("User verifies to navigate to the Login Page")
    public void user_verifies_to_navigate_to_the_login_page() {
        Assert.assertEquals("https://test.urbanicfarm.com/auth/login",driver.getCurrentUrl());
    }
    @Then("User enters an invalid email")
    public void user_enters_an_invalid_email() {
        getLoginPage().pleaseVerifyYourEmailBox.sendKeys("nyz1234@yopmail.com");
    }
    @Then("User enters old password into the New Password box and Confirm Password box")
    public void user_enters_old_password_into_the_new_password_box_and_confirm_password_box() {
        getRegisterPage().passwordRegistrationBox.sendKeys("B12345z.");
        getRegisterPage().confirmPasswordRegistrationBox.sendKeys("B12345z.");
    }
}