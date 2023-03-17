package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US101_StepDefs {

    Response response;
    String token;

    @Given("user logs in with api for new product request")
    public void userLogsInWithApiForNewProductRequest() {
        token = ApiUtilities.loginWithAPI(USER.EZRA.getEmail(), USER.EZRA.getPassword());
    }
    @Given("user can request for a new product")
    public void userCanRequestForANewProduct(DataTable dataTable){

            List<String> key = dataTable.column(0);
            List<String> value = dataTable.column(1);

            Map<String, String> newMap = new HashMap<>();

            for (int i = 0; i < key.size(); i++) {
                newMap.put(key.get(i), value.get(i));

            }
            response = given().spec(requestSpecification(token)).formParams(newMap).post("/account/newProductRequest");
            response.prettyPrint();
        }


    @Then("user verifies the request product status code is {int}")
    public void userVerifiesTheRequestProductStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());

    }

    @Then("User verifies the request product response")
    public void userVerifiesTheRequestProductResponse() {


        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertEquals("nginx/1.23.2",response.header("server"));
        Assert.assertEquals("application/json",response.header("content-type"));
        Assert.assertEquals("16",response.header("content-length"));
    }

}
