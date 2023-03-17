package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;

public class US084_StepDef extends CommonPage {

private static String token;
private static Response response;
Map<String,Object> sellerId = new HashMap<>();

    @Given("User goes to api for rates")
    public void userGoesToApiForRates() {
       token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(),USER.SELLER.getPassword());


    }
    @When("User get to rates of the seller")
    public void user_get_to_rates_of_the_seller() {
        sellerId.put("sellerId",567);
      response =  given().contentType(ContentType.JSON).spec(requestSpecification(token)).body( sellerId).post("/account/feedback/seller/getRates");
      response.prettyPrint();



    }
    @Then("User verify success is true")
    public void user_verify_success_is_true() {
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));

    }


}
