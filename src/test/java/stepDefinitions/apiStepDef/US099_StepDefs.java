package stepDefinitions.apiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US099_StepDefs {

    String token;


    @Given("User logs in with API for updating the product")
    public void user_logs_in_with_api_for_updating_the_product() {

        token = ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"), ConfigurationReader.getProperty("sellerPassword"));


    }

    @When("user updates the product")
    public void user_updates_the_product(DataTable dataTable) {
        List<String> key = dataTable.column(0);
        List<String> value = dataTable.column(1);

        Map<String, Object> tableMap = new HashMap<>();

        for (int i = 0; i < key.size(); i++) {
            tableMap.put(key.get(i), value.get(i));

        }
        response = given().spec(requestSpecification(token)).formParams(tableMap).post("/account/hub/product/update");
        response.prettyPrint();
    }


    @Then("user verifies that update function works")
    public void userVerifiesThatUpdateFunctionWorks(DataTable dataTable) {

        List<String> key = dataTable.column(0);
        List<String> value = dataTable.column(1);

        for (int i = 0; i < key.size(); i++) {
            Assert.assertEquals(value.get(i),response.jsonPath().getString(key.get(i)));


        }
    }
}
