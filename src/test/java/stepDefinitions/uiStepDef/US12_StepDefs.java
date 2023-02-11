package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;

public class US12_StepDefs extends CommonPage {

    @When("User goes to login button and click")
    public void user_goes_to_login_button_and_click() {
       getHomePage().loginButton.click();
    }
    @Then("User goes to e-mail box and write address")
    public void user_goes_to_e_mail_box_and_write_address() {
        getHomePage().emailBox.sendKeys("fikritester@gmail.com");

    }
    @Then("User goes to password box and writes password")
    public void User_goes_to_password_box_and_writes_password() {
        getHomePage().passwordBox.sendKeys("A123456789a");


    }
    @Then("User clicks Submit button")
    public void user_clicks_Submit_button() {
        getHomePage().ssubmitButton.click();
        BrowserUtilities.wait(7);

    }
    @Then("User clicks Sell-Share-Trade button")
    public void user_clicks_sell_share_trade_button() {
        getHomePage().sellShareTradeButton.click();
        BrowserUtilities.wait(7);
    }

    @Then("User verify current URL")
    public void user_verify_current_url() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/home",driver.getCurrentUrl());
        BrowserUtilities.wait(3);
    }
    @Then("User closes the browser")
    public void user_closes_the_browser() {
      //  driver.close();



    }
}
