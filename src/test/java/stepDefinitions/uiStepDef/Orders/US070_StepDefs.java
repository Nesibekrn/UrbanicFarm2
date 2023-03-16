package stepDefinitions.uiStepDef.Orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class US070_StepDefs extends CommonPage {


    Random random = new Random();


    @And("User clicks add to cart button")
    public void userClicksAddToCartButton() {
        int anyOrderOnWelcomePage = random.nextInt(getOrdersPage().listAddCartButton.size());
        getOrdersPage().listAddCartButton.get(anyOrderOnWelcomePage).click();

    }

    @And("User verifies the {string} warning is displayed")
    public void userVerifiesTheWarningIsDisplayed(String alert) {
        BrowserUtilities.wait(1);
        Assert.assertTrue(getOrdersPage().alert.getText().contains(alert));
        
    }

    @When("User clicks on the sellers account")
    public void userClicksOnTheSellersAccount() {

        int anySeller = random.nextInt(getOrdersPage().productUserName.size());
        BrowserUtilities.wait(1);

        JSutilities.clickWithJS(getOrdersPage().productUserName.get(anySeller));
        BrowserUtilities.wait(1);


    }

    @And("user verifies goes to {string} page")
    public void userVerifiesGoesToPage(String url) {

        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("User selects any order")
    public void user_selects_any_order() {
        BrowserUtilities.wait(1);
        int anyOrder = random.nextInt(getOrdersPage().addCartButtonList.size());
        BrowserUtilities.wait(1);

        JSutilities.clickWithJS(getOrdersPage().addCartButtonList.get(anyOrder));
        BrowserUtilities.wait(1);


    }

    @When("User clicks {string}")
    public void user_clicks(String viewMap) {
        JSutilities.scrollToWebElement(getOrdersPage().iframeMap);
        driver.switchTo().frame(getOrdersPage().iframeMap);

        JSutilities.clickWithJS(getOrdersPage().viewLargerMap);
        BrowserUtilities.wait(1);

        driver.switchTo().parentFrame();
        BrowserUtilities.switchToWindow();

    }

    @When("User verifies map opened on other page")
    public void user_verifies_map_opened_on_other_page() {

        BrowserUtilities.wait(1);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.google.com/maps"));

    }

}
