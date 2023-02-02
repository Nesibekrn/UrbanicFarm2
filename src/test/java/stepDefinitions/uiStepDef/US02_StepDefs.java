package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.List;

public class US02_StepDefs extends CommonPage  {

    @Given("User verifies Urbanic Farm Logo is visible")
    public void userVerifiesUrbanicFarmLogoIsVisible() {
        Assert.assertTrue(getHomePage().urbanicFarmLogo.isDisplayed());
    }


    @And("User verifies {string} link is displayed")
    public void userVerifiesLinkIsDisplayed(String supportLink) {
        Assert.assertTrue(getHomePage().supportTheLocalFoodMovementLink.isDisplayed());
        BrowserUtilities.wait(2);
    }

    @And("User verifies {string} is visible")
    public void userVerifiesIsVisible(String str, DataTable dta) {
        List<String> headers = dta.column(0);
        for (int i = 0; i<headers.size() ; i++) {
            Assert.assertEquals(headers.get(i), getHomePage().headersList.get(i).getText());
        }
        /*for each methodu "List elementlerde kullanilabilir"
        for (WebElement each : topSubmodel) {
                   Assert.assertTrue(each.isDisplayed());
        }*/

        System.out.println(getHomePage().headersList.get(1).getText());

    }


}
