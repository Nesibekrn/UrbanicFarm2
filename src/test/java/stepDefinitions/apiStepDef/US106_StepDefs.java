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

public class US106_StepDefs {
    String token;
    Response response;

    @Given("User logs in API as for unread message")
    public void userLogsInAPIAsForUnreadMessage() {
      token = ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(), USER.SELLER1.getPassword());
    }

    @When("User get unread message count")
    public void userGetUnreadMessageCount() {
       response = given().spec(requestSpecification(token)).post("/chat/getUnreadMessagesCount");
    }

    @Then("User verify  message response is expected")
    public void userVerifyMessageResponseIsExpected() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        response.prettyPrint();
    }
}
