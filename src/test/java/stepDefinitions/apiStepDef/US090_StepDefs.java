package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class US090_StepDefs {
    Response response;
    String token;
    String endpoint;
    @Given("The user connects to the api")
    public void theUserConnectsToTheApi() {
        token = ApiUtilities.loginWithAPI(USER.BUYER3.getEmail(), USER.BUYER3.getPassword());
    }

    @When("The user change available hours buyer picks up from branch")
    public void theUserChangeAvailableHoursBuyerPicksUpFromBranch() {
        endpoint = "https://test.urbanicfarm.com/api/account/change/delivery";

        String body="{\n" +
                "  \"availability\": \"02:00-03:00\",\n" +
                "  \"deliveryType\": [\n" +
                "    \"BUYER_PICKUP_FROM_BRANCH\"\n" +
                "  ]\n" +
                "}";

        response=given()
                .contentType(ContentType.JSON)
                .when().auth().
                oauth2(token)
                .body(body)
                .post(endpoint);



        System.out.println("Status Code =" +response.getStatusCode());
        System.out.println("ContentType=" + response.getContentType());
        System.out.println("show info = "+ response.prettyPrint());


    }
}
