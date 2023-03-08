package stepDefinitions.apiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;

public class US092_StepDefs extends CommonPage {
    String token;
    Response response;
    Map<String, Object> payload = new HashMap<>();
    @Given("User logs in with API for seller delivers")
    public void userLogsInWithAPIForSellerDelivers() {
        token = ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("us050Email"), ConfigurationReader.getProperty("us050Password"));
    }

    @When("User changes availability for seller delivers the products")
    public void userChangesAvailabilityForSellerDeliversTheProducts(DataTable dataTable) {

        payload.put(dataTable.cell(0, 0), new String[]{dataTable.cell(0, 1)});
        payload.put(dataTable.cell(1, 0), dataTable.cell(1, 1));
        payload.put(dataTable.cell(2, 0), dataTable.cell(2, 1));
        payload.put(dataTable.cell(3, 0), dataTable.cell(3, 1));
        payload.put(dataTable.cell(4, 0), dataTable.cell(4, 1));
        payload.put(dataTable.cell(5, 0), new String[]{dataTable.cell(5, 1)});

        response = given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(payload).post("/account/change/delivery");
        response.prettyPrint();
    }

    @Then("User verifies that success is true")
    public void userVerifiesThatSuccessIsTrue() {
        Assert.assertEquals(true, response.jsonPath().getBoolean("success"));
    }
}
