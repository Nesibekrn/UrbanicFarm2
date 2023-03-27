package stepDefinitions.apiStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.driver;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US115_StepDefs extends CommonPage {

    @And("User creates new Event")
    public void userCreatesNewEvent() {

        response = given().spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).post("/account/address/getAddress");
        //response.prettyPrint();
        List<Integer> ids= response.jsonPath().getList("addresses.id");

        Random random = new Random();
        int id = ids.get(random.nextInt(ids.size()));

        Map<String,Object> payLoad= new HashMap<>();
        payLoad.put("title", Faker.instance().name().title());
        payLoad.put("date",BrowserUtilities.getDateForFuture3(1)+"T23:59");
        payLoad.put("fee",1);
        payLoad.put("duration",50);
        payLoad.put("attendeeLimit",10);
        payLoad.put("addressId",id);
        payLoad.put("tac","null");
        response=given().spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).formParams(payLoad).post("/account/event/create");
        response.prettyPrint();

    }

    @Then("User verifies that the status code is {int}")
    public void userVerifiesThatTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());

    }

    @And("User verifies the success is true")
    public void userVerifiesTheSuccessIsTrue() {
        Assert.assertTrue( response.jsonPath().getBoolean("success"));
    }


}
