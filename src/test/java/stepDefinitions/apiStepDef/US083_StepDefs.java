package stepDefinitions.apiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class US083_StepDefs {
    Response response;


    @Given("user sends post request using the api {string}")
    public void userSendsPostRequestUsingTheApi(String URL){

        // String endPoint = "https://test.urbanicfarm.com/api";
        Map<String, String> map = new HashMap<>();

        map.put("email","seller_urban@yopmail.com");
        map.put("message","IT'S OKAY");
        map.put("name","aynur");
        map.put("subject","BUYING");

        response= RestAssured.given().contentType("application/json")
                .when().body(map).post(URL);
        response.prettyPrint();
    }

    @Then("user verifies the status code  {int}")
    public void userVerifiesTheStatusCode(int statusCode){
        // response.then().assertThat().statusCode(200);
        Assert.assertEquals(statusCode,response.statusCode());
    }


    @And("user verifies the server in header")
    public void userVerifiesTheServerInHeader(){

        Assert.assertEquals("nginx/1.23.2",response.header("server"));


    }


}





