package stepDefinitions.uiStepDef.Welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.BrowserUtilities;

public class US063_Stepdefs extends CommonPage {
    @Given("User goes to Welcome Page")
    public void userGoesToWelcomePage() {
        BrowserUtilities.loginWithToken();
    }

    @Then("User verifies if Welcome Page appears")
    public void userVerifiesIfWelcomePageAppears() {
    }

    @And("User verifies if What are you looking for box is functional")
    public void userVerifiesIfWhatAreYouLookingForBoxIsFunctional() {
    }

    @And("User verifies if Search miles box is functional")
    public void userVerifiesIfSearchMilesBoxIsFunctional() {
    }

    @And("User verifies if Catergories box is functional")
    public void userVerifiesIfCatergoriesBoxIsFunctional() {
    }

    @And("User verifies if Search only in organic produce is functional")
    public void userVerifiesIfSearchOnlyInOrganicProduceIsFunctional() {
    }

    @And("User verifies if Search menus box is functional")
    public void userVerifiesIfSearchMenusBoxIsFunctional() {
    }

    @And("User clicks Search menus box")
    public void userClicksSearchMenusBox() {
    }

    @Then("User verifies if Price, Delivery type, Unit type options are visible")
    public void userVerifiesIfPriceDeliveryTypeUnitTypeOptionsAreVisible() {
    }

    @When("User selects any option of dropdown menu by What are you looking for box")
    public void userSelectsAnyOptionOfDropdownMenuByWhatAreYouLookingForBox() {
    }

    @And("User selects any option of dropdown menu by Search miles box")
    public void userSelectsAnyOptionOfDropdownMenuBySearchMilesBox() {
    }

    @And("User selects any option of dropdown menu by Catergories box")
    public void userSelectsAnyOptionOfDropdownMenuByCatergoriesBox() {
    }

    @And("User clicks Search only in organic produce toggle button")
    public void userClicksSearchOnlyInOrganicProduceToggleButton() {
    }

    @Then("User selects Price upto options and clicks related of Delivery type checkbox and Unit type checkbox")
    public void userSelectsPriceUptoOptionsAndClicksRelatedOfDeliveryTypeCheckboxAndUnitTypeCheckbox() {
    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {
    }

    @Then("User verifies if correct results are appearing")
    public void userVerifiesIfCorrectResultsAreAppearing() {
    }
}
