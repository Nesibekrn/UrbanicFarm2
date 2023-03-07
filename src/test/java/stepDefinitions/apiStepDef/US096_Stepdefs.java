package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.specification.RequestSpecification;
import utilities.ApiUtilities;
import static io.restassured.RestAssured.*;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US096_Stepdefs {

    String token;
    @Given("User logs in as seller with API")
    public void userLogsInAsSellerWithAPI() {
       token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(), USER.SELLER.getPassword());
    }

    @Then("User gets Hub info")
    public void userGetsHubInfo() {
           response = given().spec(requestSpecification(token)).post("account/hub/getHubDetails/VEGETABLES_AND_FRUITS_HUB");
           response.prettyPrint();
    }

}
