package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

public class US064_StepDefs extends CommonPage {


    Select select;







    @And("User click the Login link")
    public void userClickTheLoginLink() {
        BrowserUtilities.wait(1);
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
        getWelcomePage().AnySellerRating.click();
    }

    @Then("User selected seller rating from the dropdown menu")
    public void userSelectedSellerRatingFromTheDropdownMenu() {
    select=new Select(getWelcomePage().AnySellerRating);
    select.selectByIndex(2);
       //System.out.println(select.getFirstSelectedOption().getText());
    }

    @Then("User displays the selected seller rating on the screen")
    public void userDisplaysTheSelectedSellerRatingOnTheScreen() {
     // getSellShareTradePage().AnySellerRating.isDisplayed();
   Assert.assertEquals("3",select.getFirstSelectedOption().getText());
    }


    @Then("User product rating icon clicked")
    public void userProductRatingIconClicked() {
        BrowserUtilities.wait(4);
        getWelcomePage().AnyProductRating.click();
    }


    @Then("User selected product rating from the dropdown menu")
    public void userSelectedProductRatingFromTheDropdownMenu() {
        select=new Select(getWelcomePage().AnyProductRating);
        select.selectByIndex(2);
    }


    @Then("User displays the selected  product rating on the screen")
    public void userDisplaysTheSelectedProductRatingOnTheScreen() {
    Assert.assertEquals("3",select.getFirstSelectedOption().getText());
    }



}