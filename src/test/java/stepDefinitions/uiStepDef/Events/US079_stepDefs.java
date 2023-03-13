package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US079_stepDefs extends CommonPage {

    @Then("User verifies that there should be an option View All if there is no any notifications")
    public void userVerifiesThatThereShouldBeAnOptionViewAllIfThereIsNoAnyNotifications() {
        getOrdersPage().markAllAsReadLink.click();
        Assert.assertTrue(getOrdersPage().viewAllLink.isDisplayed());
    }

    @Then("User verifies that if there is any notification listed there should be options as Mark all as read and Filter by unread")
    public void userVerifiesThatIfThereIsAnyNotificationListedThereShouldBeOptionsAsAnd() {
        Assert.assertTrue(getOrdersPage().markAllAsReadLink.isDisplayed());
        Assert.assertTrue(getOrdersPage().filterByUnreadLink.isDisplayed());
    }

    @Then("User verifies that there should be option to make notification read or unread")
    public void userVerifiesThatThereShouldBeOptionToMakeNotificationReadOrUnread() {
        Assert.assertFalse(getOrdersPage().markReadList.size() == 0);
        Assert.assertTrue(getOrdersPage().markUnreadList.size() != 0);
    }

    @When("User updates an event")
    public void userUpdatesAnEvent() {
        getEvent().updateButton.click();
        getEvent().dateBox.sendKeys(BrowserUtilities.getDateForFuture2(5));
        BrowserUtilities.wait(2);
        getEvent().submitButton.click();
        BrowserUtilities.wait(2);
    }

}
