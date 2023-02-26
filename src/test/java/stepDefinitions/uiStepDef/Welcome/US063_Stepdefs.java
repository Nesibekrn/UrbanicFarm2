package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import static stepDefinitions.Hooks.driver;

public class US063_Stepdefs extends CommonPage {


    @Given("User goes to Welcome Page")
    public void userGoesToWelcomePage() {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("buyerToken"), "home");
    }

    @Then("User verifies if Welcome Page appears")
    public void userVerifiesIfWelcomePageAppears() {

        Assert.assertEquals("https://test.urbanicfarm.com/home", driver.getCurrentUrl());

    }

    @And("User verifies if What are you looking for box is functional")
    public void userVerifiesIfWhatAreYouLookingForBoxIsFunctional() {

        getWelcomePage().searchBox.clear();
        BrowserUtilities.wait(3);
        getWelcomePage().searchBox.click();
        Assert.assertTrue(getWelcomePage().searchBox.isEnabled());

    }

    @And("User verifies if Search miles box is functional")
    public void userVerifiesIfSearchMilesBoxIsFunctional() {

       getWelcomePage().searchInMilesBox.click();
        BrowserUtilities.wait(3);
       Assert.assertTrue(getWelcomePage().searchInMilesBox.isEnabled());

    }

    @And("User verifies if Catergories box is functional")
    public void userVerifiesIfCatergoriesBoxIsFunctional() {

        getWelcomePage().allCategories.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getWelcomePage().allCategories.isEnabled());

    }

    @And("User verifies if Search only in organic produce is functional")
    public void userVerifiesIfSearchOnlyInOrganicProduceIsFunctional() {

        getWelcomePage().toggleButtonOfOrganic.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getWelcomePage().toggleButtonOfOrganic.isEnabled());

    }

    @And("User verifies if Search menus box is functional")
    public void userVerifiesIfSearchMenusBoxIsFunctional() {

        BrowserUtilities.wait(3);
        getWelcomePage().searchSliderButton.click();
        BrowserUtilities.wait(3);
        Assert.assertTrue(getWelcomePage().searchSliderButton.isEnabled());

    }

    @And("User clicks Search menus box")
    public void userClicksSearchMenusBox() {

        getWelcomePage().searchSliderButton.click();
        BrowserUtilities.wait(10);

    }

    @Then("User verifies if Price, Delivery type, Unit type options are visible")
    public void userVerifiesIfPriceDeliveryTypeUnitTypeOptionsAreVisible() {

        BrowserUtilities.wait(3);
       // JSutilities.clickWithJS(getWelcomePage().priceFilter);

        Assert.assertEquals("Price",getWelcomePage().priceFilter3rdOption.getText());
        BrowserUtilities.wait(3);
//        Assert.assertTrue(getWelcomePage().deliveryType.isDisplayed());
//        BrowserUtilities.wait(3);
//        Assert.assertTrue(getWelcomePage().unitType.isDisplayed());
//        BrowserUtilities.wait(3);

    }

    @When("User selects any option of dropdown menu by What are you looking for box")
    public void userSelectsAnyOptionOfDropdownMenuByWhatAreYouLookingForBox() {
//        Select select = new Select(getWelcomePage().searchBox);
//        select.selectByVisibleText("Alicante Tomato");
        getWelcomePage().toggleButtonOfOrganic.click();
        BrowserUtilities.wait(3);
        getWelcomePage().searchBox.sendKeys("Alicante Tomato");
        BrowserUtilities.wait(3);
    }

    @And("User selects any option of dropdown menu by Search miles box")
    public void userSelectsAnyOptionOfDropdownMenuBySearchMilesBox() {
        Select select = new Select(getWelcomePage().searchInMilesBox);
        select.selectByIndex(2);
    }

    @And("User selects any option of dropdown menu by Catergories box")
    public void userSelectsAnyOptionOfDropdownMenuByCatergoriesBox() {
//        Select select = new Select(getWelcomePage().allCategories);
//        select.selectByIndex(2);
        getWelcomePage().allCategories.sendKeys("Vegetable & fruits");
        BrowserUtilities.wait(3);
    }

    @And("User clicks Search only in organic produce toggle button")
    public void userClicksSearchOnlyInOrganicProduceToggleButton() {

        getWelcomePage().toggleButtonOfOrganic.click();
        BrowserUtilities.wait(3);

    }

    @Then("User selects Price upto options and clicks related of Delivery type checkbox and Unit type checkbox")
    public void userSelectsPriceUptoOptionsAndClicksRelatedOfDeliveryTypeCheckboxAndUnitTypeCheckbox() {

        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(getWelcomePage().sliderOfPrice, 20, 0).build();
        action.perform();

        BrowserUtilities.wait(3);
        getWelcomePage().firstOptionOfDeliveryType.click();
        BrowserUtilities.wait(3);
        getWelcomePage().firstOptionOfUnitType.click();
        BrowserUtilities.wait(3);

    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {

        getWelcomePage().searchSliderButton.click();

    }

    @Then("User verifies if correct results are appearing")
    public void userVerifiesIfCorrectResultsAreAppearing() {

        Assert.assertTrue(getWelcomePage().verifyForAlicanteTomato.isDisplayed());

    }
}
