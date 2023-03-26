package stepDefinitions.apiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;

public class US098_Stepdefs {
    String token;
    Response response;
    Map<String,Object> payload = new HashMap<>();
    @Given("User login API with token to add product")
    public void userLoginAPIWithTokenToAddProduct() {

        token = ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"),ConfigurationReader.getProperty("sellerPassword"));
    }

    @When("User add a product")
    public void userAddAProduct(DataTable dataTable) {

        payload.put(dataTable.cell(0,0),dataTable.cell(0,1));

        payload.put(dataTable.cell(1,0),(Double.parseDouble(dataTable.cell(1,1))));
        payload.put(dataTable.cell(2,0),dataTable.cell(2,1));
        payload.put(dataTable.cell(3,0),(Integer.parseInt(dataTable.cell(3,1))));
        payload.put(dataTable.cell(4,0),(Boolean.parseBoolean(dataTable.cell(4,1))));
        payload.put(dataTable.cell(5,0),(Boolean.parseBoolean(dataTable.cell(5,1))));
        payload.put(dataTable.cell(6,0),dataTable.cell(6,1));

        response = given().spec(requestSpecification(token)).formParams(payload).post("/account/hub/product/add");
        response.prettyPrint();

    }

    @Then("User verifies success is true")
    public void userVerifiesSuccessIsTrue() {

        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }

    @And("User deletes added product")
    public void userDeletesAddedProduct(DataTable dataTable) {
        payload.put(dataTable.cell(0,0),dataTable.cell(0,1));
        payload.put(dataTable.cell(1,0),dataTable.cell(1,1));

        response = given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(payload).post("/account/hub/product/delete");
        response.prettyPrint();
    }
}
