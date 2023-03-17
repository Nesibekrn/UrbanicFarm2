package stepDefinitions.apiStepDef;

import com.github.javafaker.Faker;
import enums.USER;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.faker;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US116_StepDefs {

    String token;

    List<Integer> eventIds;

    @Given("User logs in with Api")
    public void user_logs_in_with_api() {
        token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(), USER.SELLER.getPassword());

//        ApiUtilities.requestSpecification(token);
//        response.prettyPrint();


    }


    @When("User gets all my events info")
    public void userGetsAllMyEventsInfo() {
        response = given().spec(requestSpecification(token)).post("/account/event/getMyEvents");
        eventIds = response.jsonPath().getList("events.id");

        response.prettyPrint();
    }

    @And("User update an event")
    public void userUpdateAnEvent() {
        Map<String, Object> updateEvent = new HashMap<>();
//        List<String> eventId = (dataTable.column(0));
//        List<String> title = dataTable.column(1);

        for (int i = 0; i < eventIds.size(); i++) {
            updateEvent.put("eventId", eventIds.get(i));
            updateEvent.put("title", Faker.instance().artist().name());

            response = given().spec(requestSpecification(token)).formParams(updateEvent).post("/account/event/update");
            response.prettyPrint();
        }


    }

    @And("User verifies success is true")
    public void userVerifiesSuccessIsTrue() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }

//    @Then("User verifies status code is {int}")
//    public void userVerifiesStatusCodeIs(int statusCode) {
//        Assert.assertEquals(statusCode, response.statusCode());
//        Assert.assertTrue(response.jsonPath().getBoolean("success"));
//
//    }
}
