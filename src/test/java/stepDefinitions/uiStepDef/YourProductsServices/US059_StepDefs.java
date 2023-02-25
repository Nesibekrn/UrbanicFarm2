package stepDefinitions.uiStepDef.YourProductsServices;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.JSutilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static stepDefinitions.Hooks.driver;
import static stepDefinitions.Hooks.select;

public class US059_StepDefs extends CommonPage {
    private static String addedProduct = "";
    private static int randomHub;
    Random random = new Random();

    @Given("User login as Seller to Address link")
    public void userLoginAsSellerToAddressLink() {
        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerTokenOmer"), "account/address");
    }
    @When("User add new address if it is not exist")
    public void userAddNewAddressIfItIsNotExist() {
        try {
            getAddressPage().mySalesAddressButton.click();
            Assert.assertTrue(getAddressPage().editButton.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            getAddressPage().addNewAddress("Ankara");
            getAddressPage().nonSelectedAddressButton.click();
            getAddressPage().editButtonOnNonSelectedAddress.click();
            getAddressPage().markAsSalesAddress.click();
            getAddressPage().submitButtonToAddAddress.click();
        }
    }
    @And("User goes to Your products-service")
    public void userGoesToYourProductsService() {
        getYourProductsServicesPage().yourProductsServices.click();
        driver.navigate().refresh();
    }
    public static String getRandomIndexFromList2(List<String> getString) {
        Random random1 = new Random();
        int randomIndex = random1.nextInt(getString.size());
        return getString.get(randomIndex);
    }
    @And("User click on random Hubs2")
    public void userClickOnRandomHubs2() {
        randomHub = random.nextInt(getYourProductsServicesPage().allhubs.size());
        getYourProductsServicesPage().allhubs.get(randomHub).click();
        BrowserUtilities.wait(2);
    }
    @When("Product Name, Price, Stock, Unit, Organic, Trade information added products should be displayed.")
    public void productNamePriceStockUnitOrganicTradeInformationAddedProductsShouldBeDisplayed() {
        Assert.assertTrue(getYourProductsServicesPage().addNewProduct_Name.isDisplayed());
        Assert.assertTrue(getYourProductsServicesPage().addNewProduct_Price.isDisplayed());
        Assert.assertTrue(getYourProductsServicesPage().addNewProduct_Stock.isDisplayed());
        Assert.assertTrue(getYourProductsServicesPage().addNewProduct_Unit.isDisplayed());
        // structure  programming
        List<String> list = new ArrayList<>();
        for (int i = 0; i < getYourProductsServicesPage().allAddedProducts.size(); i++) {
            list.add(getYourProductsServicesPage().allAddedProducts.get(i).getText());
        }
        // functional programming
        List<String> addProductNames = getYourProductsServicesPage().allAddedProducts.stream()
                .map(t -> t.getText())
                .collect(Collectors.toList());

        List<String> allProductNames = getYourProductsServicesPage().allProductsNames.stream()
                .map(t -> t.getAttribute("value"))
                .collect(Collectors.toList());
        allProductNames.removeAll(addProductNames);
        addedProduct = getRandomIndexFromList2(allProductNames);
        BrowserUtilities.wait(5);
        getYourProductsServicesPage().addNewProduct_Name.sendKeys(addedProduct);
        getYourProductsServicesPage().addNewProduct_Price.sendKeys("15");
        getYourProductsServicesPage().addNewProduct_Stock.sendKeys("15");
        Select select = new Select(getYourProductsServicesPage().addNewProduct_Unit);
        select.selectByIndex(5);
        BrowserUtilities.wait(2);
        //  BrowserUtilities.scrollToElement(getYourProductsServicesPage().organicButton);
        JSutilities.scrollToBottom();
        BrowserUtilities.wait(2);
        try {
            Assert.assertTrue(getYourProductsServicesPage().organicButton.isEnabled());
            getYourProductsServicesPage().organicButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(getYourProductsServicesPage().tradeButton.isEnabled());
        getYourProductsServicesPage().tradeButton.click();
        BrowserUtilities.wait(3);
        BrowserUtilities.scrollAndClickWithJS(getYourProductsServicesPage().addNewProduct_Submit);
    }
    @Then("In-Review should be visible on the added product2.")
    public void inReviewShouldBeVisibleOnTheAddedProduct2() {
        String actualProductStatus = BrowserUtilities.getStatusOfProduct(addedProduct);
        String expectedProductStatus = "IN_REVIEW";
        System.out.println(actualProductStatus);
        Assert.assertEquals(expectedProductStatus, actualProductStatus);
    }
    @Then("Approved should be visible on the added product2.")
    public void approvedShouldBeVisibleOnTheAddedProduct2() {
        driver.navigate().back();
        BrowserUtilities.wait(2);
        getYourProductsServicesPage().allhubs.get(randomHub).click();
        BrowserUtilities.wait(2);
        String actualProductStatus = BrowserUtilities.getStatusOfProduct(addedProduct);
        String expectedProductStatus = "APPROVED";
        Assert.assertEquals(expectedProductStatus, actualProductStatus);
    }
    @Then("User sees the product on WelcomePage with organic tag if it is.")
    public void userSeesTheProductOnWelcomePageWithOrganicTagIfItIs() {
        getHomePage().urbanicFarmLogo.click();
        getWelcomePage().searchBox.sendKeys(addedProduct);
        select = new Select(getWelcomePage().searchInMilesBox);
        select.selectByIndex(1);
        try {
            getWelcomePage().organicButton.click();
        }catch (Exception e){
            e.printStackTrace();
        }
        getWelcomePage().searchButton.click();
        try {
            Assert.assertTrue(getWelcomePage().organicTag.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @And("User sees the product with Avaliable for Trade link.")
    public void userSeesTheProductWithAvaliableForTradeLink() {
        Assert.assertTrue(getWelcomePage().availableForTradeButton.isDisplayed());
        BrowserUtilities.wait(3);
    }
    @When("User clicks previous hub")
    public void userClicksPreviousHub() {
        getYourProductsServicesPage().allhubs.get(randomHub).click();
    }
    @Then("It should be possible to click on the product name on the file related to the previously added product2.")
    public void itShouldBePossibleToClickOnTheProductNameOnTheFileRelatedToThePreviouslyAddedProduct2() {
        getYourProductsServicesPage().clickAddedProduct(addedProduct);
    }
    @When("the update option is clicked after the necessary corrections, \\(.....) has been succesfully updated alert should be displayed2.")
    public void theUpdateOptionIsClickedAfterTheNecessaryCorrectionsHasBeenSuccesfullyUpdatedAlertShouldBeDisplayed2() {
        getYourProductsServicesPage().update.click();
        BrowserUtilities.wait(2);
        BrowserUtilities.toastMessageAssertion(addedProduct + " has been successfully updated");
        BrowserUtilities.wait(5);
    }
    @Then("No option should cancel the operation2")
    public void noOptionShouldCancelTheOperation2() {
        getYourProductsServicesPage().no.click();
        getYourProductsServicesPage().delete.isDisplayed();
    }
    @When("Yes option is selected, the product should be removed from the page2.")
    public void yesOptionIsSelectedTheProductShouldBeRemovedFromThePage2() {
        getYourProductsServicesPage().yes.click();
        BrowserUtilities.toastMessageAssertion(addedProduct + " has been successfully deleted");
        BrowserUtilities.wait(3);
        Assert.assertTrue(
                getYourProductsServicesPage().allAddedProducts.stream()
                        .map(t -> t.getText())
                        .noneMatch(t -> t.equals(addedProduct))
        );
    }
}