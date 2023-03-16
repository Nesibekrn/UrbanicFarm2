package stepDefinitions.apiStepDef;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import static utilities.ApiUtilities.*;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.response;


public class US110_StepDefs {


    String token;




    @Then("User get attendance info.")
    public void user_get_attendance_info() {

        token = ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"), ConfigurationReader.getProperty("sellerPassword"));


        ApiUtilities.response = given().spec(requestSpecification(token)).post("https://test.urbanicfarm.com/api/account/event/getMyAttendances");

        response.prettyPrint();


        // given().spec(requestSpecification(token)).post("/account/event/getMyEvents");


    }

    @Then("User verifies the status code is {int}")
    public void user_verifies_the_status_code_is(int statusCode) {

        Assert.assertEquals(statusCode,response.statusCode());




    }


}


