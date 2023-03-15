package stepDefinitions.apiStepDef;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US_109_StepDefs {

    String token;

    @Then("User verifies all my events info is are correct")
    public void user_verifies_all_my_events_info_is_are_correct() {
        Map<String, Object> tableMap = new HashMap<>();

        token = ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"),ConfigurationReader.getProperty("sellerPassword"));

        ApiUtilities.response = given().spec(requestSpecification(token)).formParams(tableMap).post("/account/event/getMyEvents");


    }

    @Then("User verifies status code is {int}")
    public void userVerifiesStatusCodeIs(int statusCode) {

        Assert.assertEquals(statusCode, response.statusCode());

    }
}
