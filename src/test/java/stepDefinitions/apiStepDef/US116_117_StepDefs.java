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
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US116_117_StepDefs {

    String token;

    Map<String, Object> updateEvent = new HashMap<>();
    List<Integer> eventIds;

    @Given("User logs in with Api")
    public void user_logs_in_with_api() {
        token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(), USER.SELLER.getPassword());

    }


    @When("User gets all my events info")
    public void userGetsAllMyEventsInfo() {
        response = given().spec(requestSpecification(token)).post("/account/event/getMyEvents");
        eventIds = response.jsonPath().getList("events.id");

        response.prettyPrint();
    }

    @And("User update an event")
    public void userUpdateAnEvent() {
//        List<String> eventId = (dataTable.column(0));
//        List<String> title = dataTable.column(1);

        for (int i = 0; i < eventIds.size(); i++) {
            updateEvent.put("eventId", eventIds.get(i));
            updateEvent.put("title", Faker.instance().artist().name());

            response = given().spec(requestSpecification(token)).formParams(updateEvent).post("/account/event/update");
            response.prettyPrint();
        }


    }

    @And("User verifies success is true for Event")
    public void userVerifiesSuccessIsTrueForEvent() {


        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }

    @Then("User cancel an event")
    public void userCancelAnEvent() {

//        for (int i = 0; i < eventIds.size(); i++) {
//            updateEvent.put("eventId", eventIds.get(i));
//
//            response = given().spec(requestSpecification(token)).formParams(updateEvent).post("/account/event/cancel");
//            response.prettyPrint();
//        }

        updateEvent.put("eventId", "890");

        response = given().spec(requestSpecification(token)).formParams(updateEvent).post("/account/event/cancel");
        response.prettyPrint();

//    @Then("User verifies status code is {int}")
//    public void userVerifiesStatusCodeIs(int statusCode) {
//        Assert.assertEquals(statusCode, response.statusCode());
//        Assert.assertTrue(response.jsonPath().getBoolean("success"));
//
//    }

    }
}
