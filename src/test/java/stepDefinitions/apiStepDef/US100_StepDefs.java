package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;

public class US100_StepDefs {

    Response response;
    String token;

        @Given("user adds a product")
        public void userAddsAProduct() {

        Map<Object, Object> map = new HashMap<>();

        map.put("hubUniqueName","VEGETABLES_AND_FRUITS_HUB");
        map.put("price",12);
        map.put("productUniqueName","VEGETABLES_AND_FRUITS_HUB_ANANAS_NOIRE");
        map.put("stock",12);
        map.put("isOrganic",true);
        map.put("isTrade",true);
        map.put("unit","Pack");
        response= given().contentType(ContentType.JSON).spec(requestSpecification(token))

                .when().body(map).post("/account/hub/product/add");

        response.prettyPrint();

    }
    @Then("user verifies the product add status code is {int}")
    public void userVerifiesTheProductAddStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());
    }

        @Then("user deletes a product")
        public void userDeletesAProduct() {
        Map<Object, Object> map = new HashMap<>();

        map.put("hubUniqueName","VEGETABLES_AND_FRUITS_HUB");
        map.put("productUniqueName","VEGETABLES_AND_FRUITS_HUB_ANANAS_NOIRE");

        response= given().contentType(ContentType.JSON).spec(requestSpecification(token))

                .when().body(map).post("/account/hub/product/delete");

        response.prettyPrint();

    }




    @Then("user verifies product delete the status code  {int}")
    public void userVerifiesProductDeleteTheStatusCode(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());
    }

    @Given("user logs in with api for product")
    public void userLogsInWithApiForProduct() {
        token = ApiUtilities.loginWithAPI(USER.EZRA.getEmail(), USER.EZRA.getPassword());
    }
}
