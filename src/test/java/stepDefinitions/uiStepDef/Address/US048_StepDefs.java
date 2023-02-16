package stepDefinitions.uiStepDef.Address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US048_StepDefs extends CommonPage {

    @Then("User click address button")
    public void user_click_address_button() {

       // BrowserUtilities
       getAddressPage().addresButton.click();
        BrowserUtilities.wait(3);
    }
    @Then("User click Add New Addres button")
    public void user_click_add_new_addres_button() {
        getAddressPage().newAddresButton.click();
        BrowserUtilities.wait(3);
    }
    @Then("User verify Serach Places box")
    public void user_verify_serach_places_box() {
        Assert.assertTrue(getAddressPage().searchBox.isDisplayed());
       // getAddressPage().searchBox.isDisplayed();
    }
    @And("User click first Cancel button")
    public void userClickCancelButton() {
        getAddressPage().cancelButton1.click();
        BrowserUtilities.wait(5);
    }
    @And("User wirtes Paris in the box, sees addresses and select an address")
    public void userWirtesParisInTheBoxSeesAddressesAndSelectAnAddress() {

        getAddressPage().searchBox.sendKeys("Paris");
        BrowserUtilities.wait(3);
        getAddressPage().addresOption.click();

    }
    @Then("User verify address information entry screen")
    public void userVerifyAddressInformationEntryScreen() {
        getAddressPage().addresInformatin.isDisplayed();

    }
    @And("User clicks second cancel button")
    public void userClicksSecondCancelButton() {
        getAddressPage().cancelButton2.click();
    }
    @And("User return to the previous page and verify")
    public void userReturnToThePreviousPageAndVerify() {
        getAddressPage().previousPageAddressesButton.isEnabled();

    }


}

