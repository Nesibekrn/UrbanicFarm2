package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

public class US066_StepDefs extends CommonPage {

    String plusButtonNumber, productWraps, finalTotal;
    int tableListQuantity;


    @Given("User goes to {string} as seller")
    public void userGoesToAsSeller(String url) {

        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("buyerToken"), url);

    }

    @When("User login should click on Basket button")
    public void user_login_should_click_on_basket_button() {

        getWelcomePage().numberOfCart.click();

    }

    @And("User click on increase Quantity plus button")
    public void userClickOnIncreaseQuantityPlusButton() {

        productWraps = getWelcomePage().productWrapAmount.getText();
        finalTotal = getWelcomePage().finalTotalElement.getText();

        plusButtonNumber = getWelcomePage().plusButtonNumberElement.getAttribute("value");//7

        BrowserUtilities.wait(2);
        getWelcomePage().plusButton.click();
        BrowserUtilities.wait(2);

        System.out.println("plusButtonNumber = " + plusButtonNumber);

        Assert.assertNotEquals(plusButtonNumber, getWelcomePage().plusButtonNumberElement.getAttribute("value"));

    }

    @And("Are you sure you want to delete the product? warning should appear")
    public void areYouSureYouWantToDeleteTheProductWarningShouldAppear() {

        getWelcomePage().removeButton.click();//trying to remove the item
        Assert.assertEquals("Are you sure you want to delete the product?", getWelcomePage().areYouSureWarningMessage.getText());

    }

    @Then("User clicks on no then yes")
    public void userClicksOnNoThenYes() {

        tableListQuantity = getWelcomePage().itemList.size();

        getWelcomePage().noProductDeleteButton.click();

        BrowserUtilities.wait(1);


        getWelcomePage().removeButton.click();//trying to remove the item
        BrowserUtilities.wait(3);
        getWelcomePage().yesProductDeleteButton.click();

        System.out.println("tableListQuantity = " + tableListQuantity);
        BrowserUtilities.wait(2);

        System.out.println("tableListQuantity = " + tableListQuantity);

        System.out.println("getWelcomePage().itemList.size() = " + getWelcomePage().itemList.size());

        Assert.assertNotEquals(getWelcomePage().itemList.size(),tableListQuantity);


    }

    @Then("Total should change in product wraps")
    public void totalShouldChangeInProductWraps() {
        Assert.assertNotEquals(getWelcomePage().productWrapAmount.getText(), productWraps);

    }

    @And("Final Total should change in product wraps")
    public void finalTotalShouldChangeInProductWraps() {
        Assert.assertNotEquals(getWelcomePage().finalTotalElement.getText(), finalTotal);

    }
}
