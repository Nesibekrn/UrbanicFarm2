package stepDefinitions.uiStepDef.YourProductsServices;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.DatabaseUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static stepDefinitions.Hooks.driver;

public class US058_StepDefs extends CommonPage {

    Random random = new Random();

    int randomHub;

    String addedProduct = "";


    @Given("User login as Seller")
    public void userLoginAsSeller() {

        BrowserUtilities.loginWithToken(ConfigurationReader.getProperty("sellerTokenOmer"), "account/hub");
    }


    @Test
    public void name() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String key1 = "af9492211b8c67a5f8bd99aacb3f8ef1";
        String key2 = "e3e1601fca9c429344c15527cd542142";

        String url = "https://test.urbanicfarm.com/";

        String value2 = ConfigurationReader.getProperty("sellerToken");
        String value1 = ConfigurationReader.getProperty("sellerToken").split("\\.")[1];
        driver.get(url);
        localStorage.setItem(key1, value1);
        localStorage.setItem(key2, value2);

        driver.get(url + "account/hub");

        BrowserUtilities.wait(20);

    }

    @And("User goes to Your products-services")
    public void userGoesToYourProductsServices() {
    }

    @And("User click on random Hubs")
    public void userClickOnRandomHubs() {
        randomHub = random.nextInt(getYourProductsServicesPage().allhubs.size());
        getYourProductsServicesPage().allhubs.get(randomHub).click();
        BrowserUtilities.wait(2);

    }

    public static String getRandomIndexFromList(List<String> getString) {
        Random random1 = new Random();

        int randomIndex = random1.nextInt(getString.size());

        return getString.get(randomIndex);

    }

    @When("Product Name, Price, Stock, Unit information added products should be displayed.")
    public void productNamePriceStockUnitInformationAddedProductsShouldBeDisplayed() {

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

        addedProduct = getRandomIndexFromList(allProductNames);
        BrowserUtilities.wait(5);
        getYourProductsServicesPage().addNewProduct_Name.sendKeys(addedProduct);


        getYourProductsServicesPage().addNewProduct_Price.sendKeys("15");
        getYourProductsServicesPage().addNewProduct_Stock.sendKeys("15");
        Select select = new Select(getYourProductsServicesPage().addNewProduct_Unit);

        select.selectByIndex(5);


        BrowserUtilities.scrollAndClickWithJS(getYourProductsServicesPage().addNewProduct_Submit);
       // getYourProductsServicesPage().addNewProduct_Submit.click();
    }

    @Then("One of the Approved, In-Review, Rejected options for each product should be visible on the file.")
    public void oneOfTheApprovedInReviewRejectedOptionsForEachProductShouldBeVisibleOnTheFile() {
BrowserUtilities.wait(5);

        for (int i = 0; i < getYourProductsServicesPage().allProductsStatus.size(); i++) {

            String actualStatus = getYourProductsServicesPage().allProductsStatus.get(i).getText();


            Assert.assertTrue(
                    actualStatus.equals("APPROVED") ||
                            actualStatus.equals("IN_REVIEW") ||
                            actualStatus.equals("REJECTED")
            );


        }
    }

    @Then("In-Review should be visible on the added product.")
    public void inReviewShouldBeVisibleOnTheAddedProduct() {

        String actualProductStatus = BrowserUtilities.getStatusOfProduct(addedProduct);
        String expectedProductStatus = "IN_REVIEW";
        System.out.println(actualProductStatus);

        Assert.assertEquals(expectedProductStatus, actualProductStatus);


    }

    @Then("User approve last added product from database")
    public void userApproveLastAddedProductFromDatabase() {
        DatabaseUtilities.approveLastProduct();
    }

    @Then("Approved should be visible on the added product.")
    public void approvedShouldBeVisibleOnTheAddedProduct() {
        driver.navigate().back();
        BrowserUtilities.wait(2);
        getYourProductsServicesPage().allhubs.get(randomHub).click();
        BrowserUtilities.wait(2);

        String actualProductStatus = BrowserUtilities.getStatusOfProduct(addedProduct);
        String expectedProductStatus = "APPROVED";

        Assert.assertEquals(expectedProductStatus, actualProductStatus);
    }

    @Then("It should be possible to click on the product name on the file related to the previously added product.")
    public void itShouldBePossibleToClickOnTheProductNameOnTheFileRelatedToThePreviouslyAddedProduct() {

        getYourProductsServicesPage().clickAddedProduct(addedProduct);
    }

    @When("The product name is clicked, the update-delete page is displayed.")
    public void theProductNameIsClickedTheUpdateDeletePageIsDisplayed() {

        Assert.assertTrue(getYourProductsServicesPage().update.isDisplayed());
        Assert.assertTrue(getYourProductsServicesPage().delete.isDisplayed());
    }

    @When("Product information should be able to be changed on this page")
    public void productInformationShouldBeAbleToBeChangedOnThisPage() {
        getYourProductsServicesPage().stockOfProduct.sendKeys(String.valueOf(random.nextInt(30)));
        getYourProductsServicesPage().priceOfProduct.sendKeys(String.valueOf(random.nextInt(30)));
    }

    @When("the update option is clicked after the necessary corrections, \\(.....) has been succesfully updated alert should be displayed.")
    public void theUpdateOptionIsClickedAfterTheNecessaryCorrectionsHasBeenSuccesfullyUpdatedAlertShouldBeDisplayed() {
        getYourProductsServicesPage().update.click();
        BrowserUtilities.wait(2);

        BrowserUtilities.toastMessageAssertion(addedProduct + " has been successfully updated");
        BrowserUtilities.wait(5);

    }


    @When("the Delete button is clicked, yes- no options should appear.")
    public void theDeleteButtonIsClickedYesNoOptionsShouldAppear() {
        getYourProductsServicesPage().delete.click();
        BrowserUtilities.wait(6);
        // TODO: 15/02/2023 buranin uzerinde durmak lazim 
    }

    @Then("Yes-No options should appear.")
    public void yesNoOptionsShouldAppear() {
        Assert.assertTrue(getYourProductsServicesPage().yes.isDisplayed());
        Assert.assertTrue(getYourProductsServicesPage().no.isDisplayed());

    }

    @When("One of the Yes-No options should be selected.")
    public void oneOfTheYesNoOptionsShouldBeSelected() {
    }

    @Then("No option should cancel the operation")
    public void noOptionShouldCancelTheOperation() {


    }

    @When("Yes option is selected, the product should be removed from the page.")
    public void yesOptionIsSelectedTheProductShouldBeRemovedFromThePage() {
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
