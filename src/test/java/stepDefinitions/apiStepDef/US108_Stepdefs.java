package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;

public class US108_Stepdefs {

    String token;

    Response response;
    @Given("User goes to API as Seller")
    public void userGoesToAPIAsSeller() {
        token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(), USER.SELLER.getPassword());
    }

    @And("User gets all Events Details")
    public void userGetsAllEventsDetails() {
        Map<String, Object> payload = new HashMap<>();
        Map<String, Object> innerMap = new HashMap<>();
        Map<String, Object> emptyMap = new HashMap<>();
        innerMap.put("promise", emptyMap);
        payload.put("cancelToken", innerMap);
        System.out.println(payload);
        response = given().contentType(ContentType.JSON).body(payload).spec(requestSpecification(token)).post("/public/getAllEvents");
        response.prettyPrint();
    }

    @Then("User verifies if status code is {int}")
    public void userVerifiesIfStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("User verifies success is True")
    public void userVerifiesSuccessIsTrue() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }
}
