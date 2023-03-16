package stepDefinitions.uiStepDef.DeliveryPickupSettings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.List;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;


public class US056_StepDefs extends CommonPage {


    @Then("user clicks on delivery & pick up settings")
    public void userClicksOnDeliveryPickUpSettings() {
        getDeliveryPickupSettingsPage().deliveryPickUpSetting.click();
//        do {
//            try {
//                Assert.assertTrue(getDeliveryPickupSettingsPage().freeDeliveryRangeMileBox.isDisplayed());
//                break;
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//            getDeliveryPickupSettingsPage().deliveryPickUpSetting.click();
//
//        } while (true);


    }

    @And("user verifies All menus in the relevant area are functional and appropriate options are selected")
    public void userVerifiesAllMenusInTheRelevantAreaAreFunctionalAndAppropriateOptionsAreSelected() {
        BrowserUtilities.wait(1);
        Assert.assertTrue(getDeliveryPickupSettingsPage().buyerPicksUpOnTheVineCheckbox.isEnabled());
        Assert.assertTrue(getDeliveryPickupSettingsPage().sellerDeliversTheProductsCheckbox.isEnabled());
        Assert.assertTrue(getDeliveryPickupSettingsPage().sellerFlexibleDeliveryCheckbox.isEnabled());
        Assert.assertTrue(getDeliveryPickupSettingsPage().buyerPicksUpCheckbox.isEnabled());
        BrowserUtilities.wait(5);
        if (getDeliveryPickupSettingsPage().buyerPicksUpOnTheVineCheckbox.isSelected())
        {
            getDeliveryPickupSettingsPage().buyerPicksUpOnTheVineCheckbox.click();
        }
        if (getDeliveryPickupSettingsPage().buyerPicksUpCheckbox.isSelected())
        {
            getDeliveryPickupSettingsPage().buyerPicksUpCheckbox.click();
        }
        if (getDeliveryPickupSettingsPage().sellerFlexibleDeliveryCheckbox.isSelected())
        {
            getDeliveryPickupSettingsPage().sellerFlexibleDeliveryCheckbox.click();
        }
        if (getDeliveryPickupSettingsPage().sellerDeliversTheProductsCheckbox.isSelected()) {
            System.out.println("Appropriate option is selected");
        } else {
            getDeliveryPickupSettingsPage().sellerDeliversTheProductsCheckbox.click();
        }
    }

    @When("user leaves empty boxes on the seller delivers on the products and verifies the alert.")
    public void userLeavesEmptyBoxesOnTheSellerDeliversOnTheProductsAndVerifiesTheAlert(DataTable dataTable) {
        List<String> Ids = dataTable.column(0);
        List<String> values = dataTable.column(1);
        for (int i = 0; i < values.size(); i++) {
            WebElement element = driver.findElement(By.id(Ids.get(i)));
            if (Ids.get(i).equals("estimatedDeliveryTime")) {
                Select select = new Select(element);
                select.selectByIndex(0);
                getDeliveryPickupSettingsPage().updateButton.click();
                Assert.assertEquals("Please select an option", element.getAttribute("validationMessage"));
            } else {
                element.click();
                actions.sendKeys(Keys.END).perform();
                BrowserUtilities.cleanTextFromWebelemnt(element);
                element.sendKeys(Keys.ENTER);
                BrowserUtilities.wait(1);
                Assert.assertEquals("Please fill out this field.", element.getAttribute("validationMessage"));
                element.sendKeys(values.get(i));
            }


        }
    }

    @When("user enters invalid value user must see different alert")
    public void userEntersInvalidValueUserMustSeeDifferentAlert(DataTable dataTable) {
        List<String> degerler = dataTable.column(0);
        List<String> alerts = dataTable.column(1);


        for (int i = 0; i < getDeliveryPickupSettingsPage().arkadortlu.size(); i++) {

            for (int j = 0; j < dataTable.column(0).size(); j++) {
                if (j < 2) {


                    getDeliveryPickupSettingsPage().arkadortlu.get(i).clear();

                    getDeliveryPickupSettingsPage().arkadortlu.get(i).sendKeys(Integer.parseInt(getDeliveryPickupSettingsPage().arkadortlu.get(i).getAttribute("min")) + Double.parseDouble(degerler.get(j)) + "");

                    getDeliveryPickupSettingsPage().arkadortlu.get(i).sendKeys(Keys.ENTER);


                    Assert.assertTrue(getDeliveryPickupSettingsPage().arkadortlu.get(i).getAttribute("validationMessage").contains(alerts.get(j)));

                } else {
                    getDeliveryPickupSettingsPage().arkadortlu.get(i).clear();

                    getDeliveryPickupSettingsPage().arkadortlu.get(i).sendKeys(Integer.parseInt(getDeliveryPickupSettingsPage().arkadortlu.get(i).getAttribute("max")) + Double.parseDouble(degerler.get(j)) + "");

                    getDeliveryPickupSettingsPage().arkadortlu.get(i).sendKeys(Keys.ENTER);


                    Assert.assertTrue(getDeliveryPickupSettingsPage().arkadortlu.get(i).getAttribute("validationMessage").contains(alerts.get(j)));

                }
            }

            getDeliveryPickupSettingsPage().arkadortlu.get(i).clear();

            getDeliveryPickupSettingsPage().arkadortlu.get(i).sendKeys("3");

            Select select = new Select(getDeliveryPickupSettingsPage().estimatedDeliveryTimeBox);
            select.selectByIndex(1);

        }


    }

    @When("user enters invalid value to up to mile box user must see different alert")
    public void userEntersInvalidValueToUpToMileBoxUserMustSeeDifferentAlert(DataTable dataTable) {
        List<String> degerler = dataTable.column(0);
        List<String> alerts = dataTable.column(1);
        for (int i = 0; i < dataTable.column(0).size(); i++) {

            getDeliveryPickupSettingsPage().upToMileBox.clear();

            getDeliveryPickupSettingsPage().upToMileBox.sendKeys(Integer.parseInt(getDeliveryPickupSettingsPage().upToMileBox.getAttribute("min")) + Double.parseDouble(degerler.get(i)) + "");

            getDeliveryPickupSettingsPage().upToMileBox.sendKeys(Keys.ENTER);


            Assert.assertTrue(getDeliveryPickupSettingsPage().upToMileBox.getAttribute("validationMessage").contains(alerts.get(i)));


        }


    }

    @And("user enters valid value and see {string}")
    public void userEntersValidValueAndSee(String message) {
        getDeliveryPickupSettingsPage().upToMileBox.clear();
        getDeliveryPickupSettingsPage().upToMileBox.sendKeys("3" + Keys.ENTER);
        BrowserUtilities.wait(1);
        Assert.assertEquals(message, getDeliveryPickupSettingsPage().alert.getText());
    }
}
