package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import java.util.List;
import java.util.Set;

import static stepDefinitions.Hooks.*;

public class Deneme_stepDef {


    @Given("tag kullanarak")
    public void tagKullanarak() {

    }

    @Given("Scenario Outline {string} and {string}")
    public void scenarioOutlineAnd(String email, String password) {
     //Assert.fail();
        BrowserUtilities.loginMethod(email, password);
    }

    @Given("Configuration properties kullanarak")
    public void configurationPropertiesKullanarak() {
        BrowserUtilities.loginMethod(
                ConfigurationReader.getProperty("sellerEmail"),
                ConfigurationReader.getProperty("sellerPassword"));
    }

    @Given("Data table kullanarak")
    public void dataTableKullanarak(DataTable dataTable) {
        List<String> emails = dataTable.column(0);
        List<String> passwords = dataTable.column(1);

        for (int i = 0; i < emails.size(); i++) {
            BrowserUtilities.loginMethod(emails.get(i), passwords.get(i));
            BrowserUtilities.localClear();
            BrowserUtilities.wait(3);


        }
    }

    @Given("Scenario icinde {string} and {string}")
    public void scenarioIcindeAnd(String email, String password) {
        BrowserUtilities.loginMethod(email, password);

    }


    public static class US01_StepDefs  {


        @Given("User goes to {string}")
        public void userGoesTo(String url) {
            driver.get(url);

        }

        @Then("User verifies the url is {string}")
        public void userVerifiesTheUrlIs(String url) {
            Assert.assertEquals(url, driver.getCurrentUrl());
        }



    }

    public static class US02_StepDefs extends CommonPage {

        @Given("User verifies Urbanic Farm Logo is visible")
        public void userVerifiesUrbanicFarmLogoIsVisible() {
            Assert.assertTrue(getHomePage().urbanicFarmLogo.isDisplayed());
        }


        @And("User verifies {string} link is displayed")
        public void userVerifiesLinkIsDisplayed(String supportLink) {
            Assert.assertTrue(getHomePage().supportTheLocalFoodMovementLink.isDisplayed());
            BrowserUtilities.wait(2);
        }

        @And("User verifies {string} is visible")
        public void userVerifiesIsVisible(String str, DataTable dta) {
            List<String> headers = dta.column(0);
            for (int i = 0; i<headers.size() ; i++) {
                Assert.assertEquals(headers.get(i), getHomePage().headersList.get(i).getText());
            }
            /*for each methodu "List elementlerde kullanilabilir"
            for (WebElement each : topSubmodel) {
                       Assert.assertTrue(each.isDisplayed());
            }*/

            System.out.println(getHomePage().headersList.get(1).getText());

        }



    }

    public static class US03_StepDefs extends CommonPage {

        @Given("User verifies Blog Link is clickable and clicks")
        public void userVerifiesBlogLinkIsClickableAndClicks() {
            Assert.assertTrue(getHomePage().blogLink.isDisplayed());
            getHomePage().blogLink.click();
            BrowserUtilities.wait(2);
        }

        @Then("User verifies relevant Blog Page with url")
        public void userVerifiesRelevantBlogPageWithUrl() {
            Assert.assertEquals("https://test.urbanicfarm.com/blog/", driver.getCurrentUrl());

        }

    }

    public static class US04_StepDefs extends CommonPage {
        @When("user clicks to explore button")
        public void userClicksToExploreButton() {
            getHomePage().exploreLink.click();
        }

        @Then("user verifies relavent page is {string}")
        public void userVerifiesRelaventPageIs(String expectedUrl) {
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        }


    }

    public static class US05_StepDefs extends CommonPage {


        @When("user clicks to About Us button")
        public void userClicksToAboutUsButton() {
            getHomePage().aboutUsLink.click();
        }
        @Then("user verifies relevant page is {string}")
        public void userVerifiesRelevantPageIs(String expectedUrl) {
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        }


    }

    public static class US006_Stepdefs extends CommonPage {
            @And("User checks the Contact Us button is clickable")
        public void userChecksTheContactUsButtonIsClickable() {

            getHomePage().contactUsLink.isEnabled();

        }

        @Then("User clicks Contact Us button")
        public void userClicksContactUsButton() {

            getHomePage().contactUsLink.click();

        }

        @Then("User verifies if Contact Us page is visible")
        public void userVerifiesIfContactUsPageIsVisible() {

            Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());

        }
    }

    public static class US007_Stepdefs extends CommonPage {
        @And("User checks the Login button is clickable")
        public void userChecksTheLoginButtonIsClickable() {

            Assert.assertTrue(getHomePage().loginButton.isDisplayed());

        }

        @Then("User clicks Login button")
        public void userClicksLoginButton() {

            getHomePage().loginButton.click();
            BrowserUtilities.wait(3);

        }

        @Then("User verifies if Login page is visible")
        public void userVerifiesIfLoginPageIsVisible() {

            Assert.assertEquals("https://test.urbanicfarm.com/auth/login", driver.getCurrentUrl());

        }
    }

    public static class US008_StepDefs extends CommonPage {

        @Given("user clicks on {string} button")
        public void user_clicks_on_button(String string) {
            WebElement registerButton = driver.findElement(By.xpath("//*[text()='Register']"));
            registerButton.click();
        }

        @Then("user verifies that current url for register")
        public void user_verifies_that_current_url_for_register() {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
        }
    }

    public static class US009_StepDef extends CommonPage {



        @Given("user clicks on {string}")
        public void user_clicks_on(String string) {
            WebElement GetFreshProduce = driver.findElement(By.className("section-2_shopButton__17T04"));
            GetFreshProduce.click();
        }
        @Then("verifies that current url")
        public void verifies_that_current_url() {
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://test.urbanicfarm.com/explore",currentUrl);
        }



    }

    public static class US10StepDef {
        @Given("User goes to home page")
        public void userGoesToHomePage() {
            driver.get("https://test.urbanicfarm.com/");
        }

        @Then("User assert sell your produce button is clickable")
        public void userAssertSellYourProduceButtonIsClickable() {
            Assert.assertTrue(commonPage.getHomePage().sellyourproduce.isEnabled());
        }

        @When("User clicks on sell your produce button")
        public void userClicksOnSellYourProduceButton() {
            commonPage.getHomePage().sellyourproduce.click();
        }

        @Then("User verified the url is {string}")
        public void userVerifiedTheUrlIs(String expectedurl) {
            Assert.assertEquals(expectedurl,driver.getCurrentUrl());
        }
    }

    public static class US11StepDef {

        @Then("User assert register now button is clickable")
        public void userAssertRegisterNowButtonIsClickable(){
            Assert.assertTrue(commonPage.getHomePage().registernow.isEnabled());
        }

        @When("User clicks on register now button")
        public void userClicksOnRegisterNowButton(){
            JSutilities.clickElementByJS(commonPage.getHomePage().registernow);
        }


    }

    public static class US12_StepDefs extends CommonPage {

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

    public static class US013_StepDefs extends CommonPage {

        @And("user goes to the {string} heading")
        public void userGoesToTheHeading(String arg0) {
            JSutilities.scrollToWebElement(getHomePage().contributionToTheEnvironmentAndSocietyHeading);
        }

        @And("user waits {int} seconds")
        public void userWaitsSeconds(int saniye) {
            BrowserUtilities.wait(saniye);
        }

        @Then("user verifies that the {string} heading is clickable")
        public void user_verifies_that_the_heading_is_clickable(String string) {
            Assert.assertTrue(getHomePage().registerNowLink.isEnabled());
        }

    }

    public static class US014_Stepdefs extends CommonPage {
        @And("user goes  the {string} heading")
        public void userGoesTheHeading(String arg0) {
            JSutilities.scrollToWebElement(getHomePage().ReduceWasteStrengthenYourCommunityHeading);
        }

        @And("user waits {int} second")
        public void userWaitsSecond(int arg0) {
            BrowserUtilities.wait(2);
        }

        @Then("user verifies  the {string} heading is clickable")
        public void userVerifiesTheHeadingIsClickable(String arg0) {
            Assert.assertTrue(getHomePage().WhatsNearYouLink.isEnabled());
            Assert.assertTrue(getHomePage().PostYourGoodsLink.isEnabled());
        }



    }

    public static class US15StepDef extends CommonPage {
        @Then("User assert the go wefunder  button is clickable")
        public void userAssertTheGoWefunderButtonIsClickable() {
            Assert.assertTrue(getHomePage().goWefunderButton.isEnabled());


        }

        @When("User clicks on go wefunder button")
        public void userClicksOnGoWefunderButton() {

            JSutilities.clickElementByJS(getHomePage().goWefunderButton);
            Set<String> allWindowHandles = driver.getWindowHandles();
            System.out.println(allWindowHandles);
            String window1Handle = driver.getWindowHandle();
            for (String eachHandle : allWindowHandles) {
                if (!eachHandle.equals(window1Handle)) {
                    driver.switchTo().window(eachHandle);
                    break;
                }
            }
        }
    }

    public static class US016_StepDefs extends CommonPage {

        //Sevinc
        @Given("user goes to {string}")
        public void user_Goes_To(String url) {
            driver.get(url);

        }
        @And("user goes to bottom page")
        public void user_Goes_To_Bottom_Page() {
            JSutilities.scrollToBottom();
            //  actions.sendKeys(Keys.END).perform();
            //BrowserUtilities.wait(3);

        }

        @And("user clicks on Blog option under the Explore Icon")
        public void user_Clicks_On_Blog_Icon_Under_The_Explore_Icon() {
            getHomePage().blogOption.click();
            //BrowserUtilities.wait(3);

        }
        @Then("user verifies that current url")
        public void user_Verifies_That_CurrentUrl_Is() {
            // Assert.assertEquals("https://test.urbanicfarm.com/blog/",driver.getCurrentUrl());
            Assert.assertEquals("https://urbanicfarm.com/blog/",driver.getCurrentUrl());

        }
    }

    public static class US017_StepDefs extends CommonPage {

        @When("User goes to bottom page")
        public void user_goes_to_bottom_page() {
           actions.sendKeys(Keys.END).perform();
            BrowserUtilities.wait(3);
        }
        @When("User click Discover Local link")
        public void User_click_Discover_Local_link() {
            getHomePage().discoverLink.click();
        }
        @Then("User verifies relevant pages url")
        public void User_verifies_relevant_pages_url() {
            Assert.assertEquals("https://test.urbanicfarm.com/explore",driver.getCurrentUrl());
        }
    }

    public static class US018_StepDefs extends CommonPage {



        @When("User scrolls down")
        public void user_scrolls_down() {
            actions.sendKeys(Keys.END).perform();
            //JSutilities.scrollToBottom();
            BrowserUtilities.wait(2);
        }

        @When("User clicks on the Get The App")
        public void user_clicks_on_the_get_the_app() {
            BrowserUtilities.wait(2);
            getHomePage().getTheApp.click();
            BrowserUtilities.wait(2);
        }

        @Then("User verifies Get The App visible")
        public void userVerifiesGetTheAppVisible() {
            Assert.assertTrue(getHomePage().getTheApp.isDisplayed());
            BrowserUtilities.wait(2);
        }


    }
}
