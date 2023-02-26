package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.Random;

public class US065_StepDefs extends CommonPage {

    Random random = new Random();


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
        int numberOfSellers1 = getWelcomePage().allSellersList.size();

    }

    @And("User is able to choose any seller")
    public void userIsAbleToChooseAnySaller() {
        int anyseller = random.nextInt(getWelcomePage().allSellersList.size());
        Assert.assertTrue(getWelcomePage().allSellersList.
                get(anyseller).isEnabled());
    }

    @Then("User verifies Products are listed in separate sections")
    public void userVerifiesProductsAreListedInSeparateSections() {
        int numberOfSellers = getWelcomePage().allSellersList.size();
        int numberOfProducts = getWelcomePage().allProductList.size();

        Assert.assertEquals(numberOfProducts, numberOfSellers);


    }

    @Then("User verifies Product quantity icons plus minus are clickable")
    public void userVerifiesProductQuantityIconsPlusMinusAreClickable() {
        for (int j = 0; j < 5; j++) {
            getWelcomePage().iconOfPlus.click();

        }
        for (int j = 0; j < 5; j++) {
            getWelcomePage().iconOfMinus.click();

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

    @Then("User verifies the product is added to the cart.")
    public void userVerifiesTheProductIsAddedToTheCart() {
        for (int i = 0; i < 4; i++) {
            getWelcomePage().listOfAddCartProduct.get(i).click();
            Assert.assertEquals(getWelcomePage().numberOfCart.isDisplayed(), getWelcomePage().addAlertMessage.isDisplayed());
        }
    }


    @Then("User verifies {string} warning is displayed")
    public void userVerifiesWarningIsDisplayed(String message) {
        Assert.assertTrue(getWelcomePage().addAlertMessage.getText().contains(message));
    }

}


