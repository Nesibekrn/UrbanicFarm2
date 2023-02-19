package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import static stepDefinitions.Hooks.driver;

public class US064_StepDefs extends CommonPage {
 Select select;
   // @Given("User goes to https://test.urbanicfarm.com/")
  // public void userGoesToHttpsTestUrbanicfarmCom(String baseUrl) {
  // @Given("User go to {baseUrl}")
   //public void userGoTo(String baseUrl) {
     //  Driver.getDriver().get(ConfigurationReader.getProperty(baseUrl));
       //driver.get(url);




    @And("User click the Login link")
    public void userClickTheLoginLink() {
        getHomePage().loginButton.click();
    }

    @Then("User enter valid email address & password & clicks the login buttonu")
    public void userEnterValidEmailAddressPasswordClicksTheLoginButtonu() {
        getLoginPage().loginMethod(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
        BrowserUtilities.wait(2);
    }

    @Then("User seller rating icon clicked")
    public void userSellerRatingIconClicked() {
        BrowserUtilities.wait(4);
        getSellShareTradePage().AnySellerRating.click();
    }

    @Then("User selected seller rating from the dropdown menu")
    public void userSelectedSellerRatingFromTheDropdownMenu(WebElement element) {
    select=new Select(element);
    select.selectByIndex(2);
       System.out.println(select.getFirstSelectedOption().getText());
    }

    @Then("User displays the selected seller rating on the screen")
    public void userDisplaysTheSelectedSellerRatingOnTheScreen() {
getSellShareTradePage().AnySellerRating.isDisplayed();
    }


    @Then("User product seller rating icon clicked")
    public void userProductSellerRatingIconClicked() {
    }


    @Then("User selected product rating from the dropdown menu")
    public void userSelectedProductRatingFromTheDropdownMenu() {
    }


    @Then("User displays the selected  product rating on the screen")
    public void userDisplaysTheSelectedProductRatingOnTheScreen() {
    }



}