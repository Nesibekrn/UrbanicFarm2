package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

import java.util.List;

public class US038_StepDefs extends CommonPage {

    @Then("User verifies {string} is visible on Sell Share Trade-A")
    public void userVerifiesIsVisibleOnSellShareTrade(String headers, DataTable dataTable) {
        List<String> navbar = dataTable.column(0);
        for (int i = 0; i < navbar.size(); i++) {
            Assert.assertEquals(navbar.get(i),getSellShareTradePage().navbarA.get(i).getText());
        }
    }

    @Then("User verifies {string} is visible on Sell Share Trade-Div")
    public void userVerifiesIsVisibleOnSellShareTradeDiv(String headers, DataTable dataTable) {
        List<String> navbar = dataTable.column(0);
        for (int i = 0; i < navbar.size(); i++) {
            Assert.assertTrue(getSellShareTradePage().navbarDiv.get(i).isDisplayed());
        }
    }


}
