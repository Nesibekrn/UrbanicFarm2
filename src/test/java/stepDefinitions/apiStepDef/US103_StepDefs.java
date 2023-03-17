package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ApiUtilities;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US103_StepDefs {

    public static
    String token;

    @Given("the user connects to the {string} api")
    public void theUserConnectsToTheApi(String arg0) {
        token = ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(), USER.SELLER1.getPassword());

    }

    @And("the user connects to the getBasketDetails api")
    public void theUserConnectsToTheGetBasketDetailsApi() {
        response = given().spec(requestSpecification(token)).post("/public/basket/getBasketDetails");
        response.prettyPrint();
    }
}