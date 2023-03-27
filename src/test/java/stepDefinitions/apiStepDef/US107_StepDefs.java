package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import static io.restassured.RestAssured.*;
import static utilities.ApiUtilities.requestSpecification;

public class US107_StepDefs {
    String token;
    Response response;

    @Given("User logs in API as Seller for get Notifications")
    public void userLogsInAPIAsSellerForGetNotifications() {
     token=   ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(),USER.SELLER1.getPassword());

    }

    @And("User gets notifications")
    public void userGetsNotifications() {
       response= given().spec(requestSpecification(token)).post("/account/notifications/getAll");

    }

    @Then("User verifies response is expected")
    public void userVerifiesResponseIsExpected() {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        response.prettyPrint();
    }
}
