package stepDefinitions.uiStepDef.Address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

public class US051_StepDef extends CommonPage {
    @And("user has entered valid login information and has logged in")
    public void userHasEnteredValidLoginInformationAndHasLoggedIn() {
        getHomePage().loginButton.click();
        getHomePage().getLoginPage().loginMethod(ConfigurationReader.getProperty("sellerEmail"), ConfigurationReader.getProperty("sellerPassword"));
    }
    @Given("User add new address as {string} if it is not exist")
    public void userAddNewAddressAsIfItIsNotExist(String address) {
        try {
            Assert.assertTrue(getAddressPage().editButton.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            getAddressPage().nonSelectedAddressButton.click();
            try { JSutilities.scrollToWebElement(getAddressPage().editButtonOnNonSelectedAddress);
                Assert.assertTrue(getAddressPage().editButtonOnNonSelectedAddress.isDisplayed());
                JSutilities.clickWithJS(getAddressPage().editButtonOnNonSelectedAddress);
                getAddressPage().markAsDeliveryAddress.click();
                getAddressPage().submitButtonToAddAddress.click();
                BrowserUtilities.wait(5);
                getAddressPage().deliveryAddress.click();
            } catch (Exception f) {
                f.printStackTrace();
                getAddressPage().addNewAddress(address);
                JSutilities.clickWithJS(getAddressPage().editButtonOnNonSelectedAddress);
                getAddressPage().markAsDeliveryAddress.click();
                getAddressPage().submitButtonToAddAddress.click();
                BrowserUtilities.wait(5);
                getAddressPage().deliveryAddress.click();
            }
        }
    }
    @Then("User click delivery address button")
    public void userClickDeliveryAddressButton() {
        getAddressPage().deliveryAddress.click();
    }
    @When("user clicks the edit button next to the desired delivery address")
    public void userClicksTheButtonNextToTheDesiredDeliveryAddress() {
        JSutilities.scrollToWebElement(getAddressPage().editButtonOnNonSelectedAddress);
        JSutilities.clickWithJS(getAddressPage().editButtonOnNonSelectedAddress);
    }
    @Then("User updates zipcode {string}")
    public void userUpdatesZipcode(String zipcode) {
        BrowserUtilities.cleanTextFromWebelemnt(getAddressPage().postalZipBox);
        getAddressPage().postalZipBox.sendKeys(zipcode);
    }

    @And("user clicks the submit button and get alert message {string}")
    public void userClicksTheButtonAndGetAlertMessage(String alert) {
       // BrowserUtilities.wait(3);
        getAddressPage().submitButtonToAddAddress.click();
        BrowserUtilities.waitForVisibility(getAddressPage().alertAfterClickedSubmitButtonOnAddressSection,2);
       Assert.assertEquals(alert,getAddressPage().alertAfterClickedSubmitButtonOnAddressSection.getText());
      BrowserUtilities.wait(5);
    }

    @When("user click remove button  and see yes and No page")
    public void userClickRemoveButtonAndSeeYesAndNoPage() {
        BrowserUtilities.waitForClickable(getAddressPage().removeButtonOnNonSelectedAddress);
       JSutilities.clickWithJS(getAddressPage().removeButtonOnNonSelectedAddress);
        BrowserUtilities.waitForClickable(getAddressPage().yesButtonAfterClickedRemoveButtonOnAddressSection);
        Assert.assertTrue(getAddressPage().yesButtonAfterClickedRemoveButtonOnAddressSection.isDisplayed());
    }

    @And("User click yes button and get alert message {string}")
    public void userClickYesButtonAndGetAlertMessage(String alert) {
       JSutilities.clickWithJS(getAddressPage().yesButtonAfterClickedRemoveButtonOnAddressSection);
       BrowserUtilities.wait(2);
        Assert.assertEquals(alert,getAddressPage().alertAfterClickedSubmitButtonOnAddressSection.getText());
    }



    }
