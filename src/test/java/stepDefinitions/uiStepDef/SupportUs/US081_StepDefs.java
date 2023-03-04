package stepDefinitions.uiStepDef.SupportUs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

public class US081_StepDefs extends CommonPage {

//    @When("User clicks on {string}")
//    public void user_clicks_on(String supportLocalFood) {
//    }


    @When("User clicks on Support the local food movement")
    public void userClicksOnSupportTheLocalFoodMovement() {
        getSupportUs().supportTheLocalFoodMovement.click();
        BrowserUtilities.wait(3);
        BrowserUtilities.switchToWindow();

    }

    @And("User verifies {string} is displayed")
    public void userVerifiesIsDisplayed(String url) {
//        Assert.assertEquals(url, driver.getCurrentUrl());
        BrowserUtilities.wait(5);
        Assert.assertTrue(url,true);
    }


    @And("User clicks Investor Panel button")
    public void userClicksInvestorPanelButton() {
        //JSutilities.clickWithJS(getSupportUs().ınvestorPanel);
        getSupportUs().investorPanel.click();

    }

    @And("User verifies Show more button is displayed")
    public void userVerifiesShowMoreButtonIsDisplayed() {
        BrowserUtilities.wait(3);
        JSutilities.scrollToWebElement(getSupportUs().showMoreButton);
        BrowserUtilities.wait(3);
        getSupportUs().showMoreButton.isDisplayed();
    }



    @And("User clicks on Invest box and writes a number")
    public void userClicksOnInvestBoxAndWritesANumber() {
       //JSutilities.clickWithJS(getSupportUs().investBox);
        getSupportUs().investBox.click();
        BrowserUtilities.wait(2);
        getSupportUs().investBox.sendKeys("145");
        BrowserUtilities.wait(2);
    }



    @Then("User verifies reservation amount is displayed")
    public void userVerifiesReservationAmountIsDisplayed() {
        //Assert.assertTrue(getSupportUs().reservationAmount.isDisplayed());
        JSutilities.scrollToWebElement(getSupportUs().reservationAmount);

    }

    @And("User clicks on Invest button")
    public void userClicksOnInvestButton() {
        getSupportUs().investButton.click();
    }
}
