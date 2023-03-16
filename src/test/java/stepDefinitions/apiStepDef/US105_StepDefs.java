package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;

public class US105_StepDefs {

    String token;
    Response response;
    @Given("User logs in API as for notification")
    public void userLogsInAPIAsForNotification() {
        token = ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(),USER.SELLER1.getPassword() );
    }

    @When("User get all conversations")
    public void userGetAllConversations() {
       response = given().spec(requestSpecification(token)).post("/chat/getConversations");

    }

    @Then("User verify response is expected")
    public void userVerifyResponseIsExpected() {
        Assert.assertEquals(200, response.getStatusCode());

        response.prettyPrint();
    }
}
