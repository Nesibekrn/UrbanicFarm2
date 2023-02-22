package stepDefinitions.uiStepDef.DeliveryPickupSettings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class US057_StepDefs extends CommonPage {
    Select select;
    @When("user clicks on user name")
    public void userClicksOnUserName() {
        getDeliveryPickupSettingsPage().user.click();
    }

    @And("user clicks on delivery and pickup settings")
    public void userClicksOnDeliveryAndPickupSettings() {
        getDeliveryPickupSettingsPage().delivery.click();
    }

    @And("user clicks on seller flexible")
    public void userClicksOnSellerFlexible() {
        getDeliveryPickupSettingsPage().seller_flexible.click();
    }

    @Then("user verifies web elements with following ids are visible")
    public void userVerifiesWebElementsWithFollowingIdsAreVisible(DataTable dataTable) {
        List<String> ids = dataTable.row(0);

        for (int i = 0; i < ids.size(); i++) {
            WebElement element = driver.findElement(By.cssSelector("#" + ids.get(i)));
            Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText());
        }

    }

    @And("user verifies web elements with following ids are clickable")
    public void userVerifiesWebElementsWithFollowingIdsAreClickable(DataTable dataTable) {
        List<String> ids = dataTable.column(0);

        for (int i = 0; i < ids.size(); i++) {
            WebElement element = driver.findElement(By.cssSelector("#" + ids.get(i)));
            Assert.assertTrue(element.isEnabled());
            System.out.println(element.getText());

        }
    }

    @When("user enters number to free delivery range and asserts border color and alerts")
    public void userEntersNumberToFreeDeliveryRangeAndAssertsBorderColorAndAlerts(DataTable dataTable) {
        BrowserUtilities.cleanTextFromWebelemnt(getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange);
        getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange.clear();
        BrowserUtilities.cleanTextFromWebelemnt(getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder);
        getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder.clear();

        List<String> data = dataTable.column(0);
        List<String> rgba = dataTable.column(1);
        List<String> alerts = dataTable.column(2);
        List<String> data2 = dataTable.column(2);
        Actions actions = new Actions(driver);

        for (int i = 0; i < data.size(); i++) {
            BrowserUtilities.cleanTextFromWebelemnt(getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder);
//            BrowserUtilities.cleanTextFromWebelemnt(getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder);
            getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder.clear();
            actions.sendKeys(getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder, Keys.BACK_SPACE,Keys.BACK_SPACE).perform();
            BrowserUtilities.scrollToElement(getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange);
            getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange.sendKeys(data.get(i));
            getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder.sendKeys(data2.get(i));
//            BrowserUtilities.assertBorderColor(rgba.get(i), getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange);
            BrowserUtilities.wait(2);
            BrowserUtilities.wait(2);
            BrowserUtilities.scrollAndClickWithJS(getDeliveryPickupSettingsPage().update);
            if (alerts.get(i).equals("Please fill out this field.")) {
                Assert.assertEquals(alerts.get(i), getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder.getDomProperty("validationMessage"));
            } else
                Assert.assertEquals(alerts.get(i), getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange.getDomProperty("validationMessage"));
            BrowserUtilities.wait(2);
            BrowserUtilities.cleanTextFromWebelemnt(getDeliveryPickupSettingsPage().minFreeFlexibleDeliveryOrder);
            BrowserUtilities.cleanTextFromWebelemnt(getDeliveryPickupSettingsPage().freeFlexibleDeliveryRange);
            System.out.println(i);
        }
    }

    @When("user selects {string} for orderBegin")
    public void userSelectsForOrderBegin(String day) {
        select = new Select(getDeliveryPickupSettingsPage().deliveryBeginDay);
        select.selectByValue(day);
    }

    @And("user enters input to order begin {string}")
    public void userEntersInputToOrderBegin(String time) {
        getDeliveryPickupSettingsPage().deliveryBeginTime.sendKeys(time);
    }

    @When("user selects {string} for orderEnd")
    public void userSelectsForOrderEnd(String day) {
        select = new Select(getDeliveryPickupSettingsPage().deliveryEndDay);
        select.selectByValue(day);
    }

    @And("user enters input to order end {string}")
    public void userEntersInputToOrderEnd(String time) {
        getDeliveryPickupSettingsPage().deliveryEndTime.sendKeys(time);

    }

    @When("user selects {string} for deliverBy")
    public void userSelectsForDeliverBy(String day) {
        select = new Select(getDeliveryPickupSettingsPage().orderByDay);
        select.selectByValue(day);
    }

    @And("user enters input to deliver by {string}")
    public void userEntersInputToDeliverBy(String time) {
        getDeliveryPickupSettingsPage().orderByTime.sendKeys(time);

    }

    @And("user clicks on update button with js")
    public void userClicksOnUpdateButtonWithJs() {
        BrowserUtilities.scrollAndClickWithJS(getDeliveryPickupSettingsPage().update);
    }

    @Then("user verifies the toast message is {string}")
    public void userVerifiesTheToastMessageIs(String message) {
        BrowserUtilities.toastMessageAssertion(message);
    }
}
