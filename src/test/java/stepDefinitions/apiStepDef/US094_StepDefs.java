package stepDefinitions.apiStepDef;

import com.github.javafaker.Faker;
import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.ArrayList;
import java.util.List;

import static utilities.ApiUtilities.response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;

public class US094_StepDefs {

    String token;

    List<String> HubList = new ArrayList<>();


    @When("User gets hub list")
    public void userGetsHubList() {
        response = given().spec(requestSpecification(token)).post("account/hub/getMyHubs");
//        HubList = response.jsonPath().getList("hubs.id");
        response.prettyPrint();
//        System.out.println(HubList);
    }

    @Then("User verifies the status code is {int}")
    public void userVerifiesTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());

    }

    @Given("User logs in API as Seller")
    public void userLogsInAPIAsSeller() {
        token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(), USER.SELLER.getPassword());
    }
}