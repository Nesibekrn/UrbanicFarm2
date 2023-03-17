package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;

public class US102_StepDefs {

    Response response;
    String token;

    @Given("user logs in with api for get all product request")
    public void userLogsInWithApiForGetAllProductRequest() {
        token = ApiUtilities.loginWithAPI(USER.EZRA.getEmail(), USER.EZRA.getPassword());
    }

    @Given("user can get all requested products' information")
    public void userCanGetAllRequestedProductsInformation() {
        Map<String, String> InfoMap = new HashMap<>();

        InfoMap.put("relatedHub", "VEGETABLES_AND_FRUITS_HUB");

        response = given().contentType(ContentType.JSON).spec(requestSpecification(token))

                .when().body(InfoMap).post("/account/getProductRequests");

        response.prettyPrint();

    }

    @Then("user verifies the all requested product status code is {int}")
    public void userVerifiesTheRequestedProductStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());

    }

    @Then("user verifies the all requested product response")
    public void userVerifiesTheAllRequestedProductResponse() {

            Assert.assertEquals("nginx/1.23.2", response.header("server"));
            Assert.assertEquals("application/json", response.header("content-type"));
            Assert.assertEquals("Thu, 19 Nov 1981 08:52:00 GMT", response.header("expires"));
        }
    }