package stepDefinitions.apiStepDef;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import enums.USERINFO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.response;

public class US086_StepDefs {

    public static String token;

    public static RequestSpecification requestSpec;
    Map<String, String> map = new HashMap<>();



    public static RequestSpecification requestSpecification(USERINFO user){
        requestSpec = new RequestSpecBuilder().addHeader("Authorization", "Bearer " + user.getToken()).
                setBaseUri("https://test.urbanicfarm.com/api").build();
        return requestSpec;

    }

    public static RequestSpecification requestSpecification(String token){
        requestSpec = new RequestSpecBuilder().addHeader("Authorization", "Bearer " + token).
                setBaseUri("https://test.urbanicfarm.com/api").build();
        return requestSpec;

    }









    ObjectMapper objectMapper=new ObjectMapper();

    @Given("User login with APİ")
    public String userLoginWithAPİ() throws JsonProcessingException {
    map.put("email", "seller_urban2@yopmail.com");
    map.put("password", "Seller2/");

    String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
    String json2=new Gson().toJson(map);


    //SERIALIZATION





    response = given().formParams(map).baseUri("https://test.urbanicfarm.com/api").post("/public/login");
    response.prettyPrint();

   token=  response.jsonPath().getString("token");
    return token;


    }








    @Then("user gets the address info")
    public void userGetsTheAddressInfo() throws IOException {
        Map<String, Object> jackson =new HashMap<>();
        Map<String,Object> gson=new HashMap<>();
      response=given().spec(requestSpecification(token)).post("/account/address/getAddress");
      response.prettyPrint();


        jackson=objectMapper.readValue((JsonParser) response,Map.class);

        gson=new Gson().fromJson((Reader) response,Map.class);

        //DESERIALIZATION

    }


    @Then("User verifies the response")
    public void user_verifies_the_response() {
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));

    }
}
