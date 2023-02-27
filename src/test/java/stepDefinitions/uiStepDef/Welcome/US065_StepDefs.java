package stepDefinitions.uiStepDef.Welcome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.sql.SQLOutput;
import java.util.Random;

public class US065_StepDefs extends CommonPage {

    Random random = new Random();
    @And("User on the Home page")
    public void userOnTheHomePage() {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("azizToken"), "home");

    }
    @When("User verifies welcome page is displayed")
    public void userVerifiesWelcomePageIsDisplayed() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(getWelcomePage().localSellerNearYouText.isDisplayed());

    }

    @Then("User verifies a list of sellers under the heading local sellers near you")
    public void userVerifiesAListOfSellersUnderTheHeadingLocalSellersNearYou() {
        for (int i = 0; i < getWelcomePage().allSellersList.size(); i++) {
            Assert.assertTrue(getWelcomePage().allSellersList.get(i).isDisplayed());
        }
    }

    @And("User is able to choose any seller")
    public void userIsAbleToChooseAnySeller() {
        int anyseller = random.nextInt(getWelcomePage().allSellersList.size());
        while (getWelcomePage().allSellersList.get(anyseller).getText().equals(getHomePage().accountName_navbar.getText())){
            anyseller=random.nextInt(getWelcomePage().allSellersList.size());
        }
        Assert.assertTrue(getWelcomePage().allSellersList.get(anyseller).isEnabled());
    }


    @Then("User verifies Products are listed in separate sections")
    public void userVerifiesProductsAreListedInSeparateSections() {
        int numberOfSellers = getWelcomePage().allSellersList.size();
        int numberOfProducts = getWelcomePage().allProductList.size();
        Assert.assertEquals(numberOfProducts, numberOfSellers);
    }

    @Then("User verifies Product quantity icons plus minus are clickable")
    public void userVerifiesProductQuantityIconsPlusMinusAreClickable() {
        int i=2;
        int j=4;
        String value1 = getHomePage().listOfPoundAvailable.getText().split(" ")[0];
        System.out.println(value1);

        if(Integer.parseInt(value1)>i){
            for ( i = 2; i <=5 ; i++) {
                getWelcomePage().iconOfPlus.click();
                Assert.assertEquals(getHomePage().productAdcartNumberSeenIcon.getAttribute("value"), String.valueOf(i));
            }
        }else if(Integer.parseInt(value1)>j){
            for ( j = 4; j>=1 ; j--) {
                getWelcomePage().iconOfMinus.click();
                Assert.assertEquals(getHomePage().productAdcartNumberSeenIcon.getAttribute("value"), String.valueOf(j));
            }
       }else{
            System.out.println("There is no item in the home ....");
        }
    }


    @Then("User verifies add to Cart button is clickable")
    public void userVerifiesAddToCartButtonIsClickable() {
        Assert.assertTrue(getWelcomePage().addCartButton.isEnabled());
    }

    @When("User clicks on the add to Cart button")
    public void userClicksOnTheAddToCartButton() {
        getWelcomePage().addCartButton.click();
        BrowserUtilities.wait(2);
        Assert.assertTrue(getWelcomePage().addAlertMessage.isDisplayed());
    }
    @Then("User verifies {string} warning is displayed")
    public void userVerifiesWarningIsDisplayed(String message) {
        int anyseller = random.nextInt(getWelcomePage().allSellersList.size());
        if(getWelcomePage().allSellersList.get(anyseller).getText().equals(getHomePage().accountName_navbar.getText())) {
            Assert.assertTrue(getWelcomePage().addAlertMessage.getText().contains(message));
        }
    }
    @Then("User verifies the product is added to the cart.")
    public void userVerifiesTheProductIsAddedToTheCart() {
        int anyseller = random.nextInt(getWelcomePage().allSellersList.size());
        if(!getWelcomePage().allSellersList.get(anyseller).getText().equals(getHomePage().accountName_navbar.getText())){
            for (int i = 1; i <=7; i=i+2) {
                getWelcomePage().listOfAddCartProduct.get(i).click();
                Assert.assertEquals(getWelcomePage().numberOfCart.isDisplayed(), getWelcomePage().addAlertMessage.isDisplayed());
            }
            for (int i = getCartPage().xIconButton.size(); i>=0; i--) {
                getCartPage().xIconButton.get(i).click();
                for (int j = i; j>=0; j--) {
                    getCartPage().yesButton.get(j).click();
                }
            }
            Assert.assertEquals(getWelcomePage().numberOfCart.getText(),String.valueOf(4));
        }
    }
}

