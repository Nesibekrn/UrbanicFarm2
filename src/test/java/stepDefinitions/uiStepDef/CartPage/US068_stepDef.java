package stepDefinitions.uiStepDef.CartPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.util.List;

public class US068_stepDef extends CommonPage {

    @Given("User on the Cart page")
    public void userOnTheCartPage() {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerToken"), "basket");
    }
    double  subtotalText;
    @And("User should see total amount")
    public void userShouldSeeTotalAmount() {
        BrowserUtilities.wait(3);
        subtotalText=Double.valueOf(getCartPage().subtotal.getText().replace("$",""));
      Assert.assertTrue(getCartPage().subtotal.isDisplayed());
    }
    // $8.00
    // 8.00

    @When("User enter a valid promo code in the {string} menu")
    public void userEnterAValidPromoCodeInTheMenu(String code) {
        getCartPage().enterPromoCodeButton.click();
        getCartPage().inputPromoCode.sendKeys(code);
    }

    @And("User click the apply button")
    public void userClickTheApplyButton() {
        getCartPage().promoCodeApplyButton.click();
    }
    double discount;
    @Then("User should update total Amount")
    public void userShouldUpdateTotalAmount() {
      Assert.assertTrue(getCartPage().discountPromoCode.isDisplayed());
      discount= Double.valueOf(getCartPage().discountPromoCode.getText().replace("$",""));
     Assert.assertTrue(subtotalText>discount);

    }

    @And("the promo code should be applied correctly {string}")
    public void thePromoCodeShouldBeAppliedCorrectly(String promoCode) {
        double remainTotal=0;
        switch (promoCode) {
            case "dolar10":
                remainTotal = subtotalText - 10;
                break;
            case "dolar20":
                remainTotal = subtotalText - 20;
                break;
            case "dolar30":
                remainTotal = subtotalText - 30;
                break;
            case "percentage10":
                remainTotal = subtotalText - (subtotalText / 100 * 10);
                break;
            case "percentage20":
                remainTotal = subtotalText - (subtotalText / 100 * 20);
                break;
            case "percentage30":
                remainTotal = subtotalText - (subtotalText / 100 * 30);
                break;
        }
        Assert.assertTrue(remainTotal== (double) discount);
    }

    /// US068_TC002 scenario

    // id crz6qgq3d
    @When("User enter an invalid promo code in the {string} menu after then click the {string} button and see an alert message saying")
    public void userEnterAnInvalidPromoCodeInTheMenuAfterThenClickTheButtonAndSeeAnAlertMessageSaying(String promoCode, String message, DataTable dataTable) {

        List<String> promoList= dataTable.column(0);
        List<String> mess= dataTable.column(1);
        getCartPage().enterPromoCodeButton.click();
        for (int i = 0; i < promoList.size(); i++) {
            getCartPage().inputPromoCode.sendKeys(promoList.get(i));
            getCartPage().promoCodeApplyButton.click();
            BrowserUtilities.wait(2);
             Assert.assertEquals(mess.get(i) ,getCartPage().invalidPromoCodeMessage.getText() );
             BrowserUtilities.wait(5);
        }
    }
}


