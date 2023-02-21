package stepDefinitions.uiStepDef.YourProductsServices;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US060_StepDefs extends CommonPage {

    @Then("User clicks Address link by menu")
    public void userClicksAddressLinkByMenu() {

        BrowserUtilities.wait(1);
       // getAddressPage().addressButton.click();
        JSutilities.clickWithJS(getAddressPage().addressButton);
        BrowserUtilities.wait(1);

    }

        @Then("User clicks Add New Address")
    public void userClicksAddNewAddress() {
        BrowserUtilities.wait(1);
        getAddressPage().addNewAddressLink.click();
        // driver.navigate().refresh();
        BrowserUtilities.wait(1);

    }

    @Then("User enters Postal Code to creat new addres")
    public void userEntersPostalCodeToCreatNewAddres() {

        BrowserUtilities.wait(1);
        getAddressPage().postalBoxSearchBar.sendKeys("34791");
        BrowserUtilities.wait(1);
        getAddressPage().optionalAddress.click();
        BrowserUtilities.wait(1);

    }

    @Then("User clicks delivery & sales addresses and clicks to Submit button")
    public void userClicksDeliverySalesAddressesAndClicksToSubmitButton() {
        getAddressPage().markAsDeliveryAddress.click();
        getAddressPage().markAsSalesAddress.click();
        getAddressPage().submitButtonToCreateAddress.click();
        BrowserUtilities.wait(1);

    }


    @Then("User clicks Your Products Services in menu")
    public void userClicksYourProductsServicesInMenu() {

        getYourProductsServicesPage().yourProductsServices.click();
        BrowserUtilities.wait(1);

    }

    @And("User clicks to Vegetables and fruits button")
    public void userClicksToVegetablesAndFruitsButton() {

        getYourProductsServicesPage().vegetablesAndFruitsButton.click();
        BrowserUtilities.wait(1);

    }

    @When("User clicks Go back button")
    public void userClicksGoBackButton() {

        getYourProductsServicesPage().goBackButton.click();
        BrowserUtilities.wait(1);

    }

    @Then("user verifies if Go back button is working")
    public void userVerifiesIfGoBackButtonIsWorking() {

        Assert.assertEquals("https://test.urbanicfarm.com/account/hub", driver.getCurrentUrl());

    }

    @Then("User enters registered email address & password & clicks the login button")
    public void userEntersRegisteredEmailAddressPasswordClicksTheLoginButton() {

        getLoginPage().loginMethod("shuhrat@yopmail.com", "123456Sh");
      //  BrowserUtilities.waitForVisibility(getHomePage().welcomeTheUrbanicFarmWindowCloseButton, 50);
      //  getHomePage().welcomeTheUrbanicFarmWindowCloseButton.click();

    }
    @Then("User clicks Account Name Navbar link by menu")
    public void userClicksAccountNameNavbarLinkByMenu() {
        getHomePage().accountName_navbar.click();
    }

    @And("User deletes existing address")
    public void userDeletesExistingAddress() {

        getAddressPage().removeExistingAddressButton.click();
        getAddressPage().confirmingOfRemoveExistingAddress.click();

    }
}
