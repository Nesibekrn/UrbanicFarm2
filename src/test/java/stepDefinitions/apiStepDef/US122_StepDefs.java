package stepDefinitions.apiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;

public class US122_StepDefs {
    Response response;
    @Given("User login with US{int}Email and password")
    public void userLoginWithUSEmailAndPassword(int arg0) {
        ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
    }

    @Then("User gets the weekly order list")
    public void userGetsTheWeeklyOrderList() {
        response = given().contentType(ContentType.JSON).when()
                .spec(requestSpecification(ConfigurationReader.getProperty("buyerToken")))
                .post("/account/weeklyorder/getWeeklyOrderbyId");
        response.prettyPrint();
    }

    @Then("User checks API Status Code")
    public void userChecksAPIStatusCode() {
      Assert.assertEquals(200, response.statusCode());
    }
}
