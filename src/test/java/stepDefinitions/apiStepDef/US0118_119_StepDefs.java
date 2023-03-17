package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.And;
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

public class US0118_119_StepDefs {
    Map<String, Object> body = new HashMap<>();

    Response response;
    String token;
    int addressId;
    int eventId;

    @Then("User delete an event")
    public void userDeleteAnEvent() {
        body.put("eventId", eventId);
        response = given().spec(requestSpecification(token)).formParams(body).post("/account/event/delete");
        response.prettyPrint();

    }

    @Given("User create an event")
    public void userCreateAnEvent() {
        body.put("title", "meeting");
        body.put("date", "2023-03-18T23:59");
        body.put("fee", 35);
        body.put("duration", 60);
        body.put("attendeeLimit", 50);
        body.put("addressId", addressId);
        body.put("tac", "engineer");
        response = given().spec(requestSpecification(token)).formParams(body).post("/account/event/create");
        response.prettyPrint();
        eventId = response.jsonPath().getInt("event.id");
    }

    @Then("User complete an event")
    public void userCompleteAnEvent() {
        body.put("eventId", eventId);
        response = given().spec(requestSpecification(token)).formParams(body).post("/account/event/complete");
        response.prettyPrint();
    }

    @Then("User verifies the status complete")
    public void userVerifiesTheStatusComplete() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @And("User verifies success is true complete")
    public void userVerifiesSuccessIsTrueComplete() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }

    @Then("User verifies the status delete")
    public void userVerifiesTheStatusDelete() {
        Assert.assertEquals(200, response.getStatusCode());

    }

    @And("User verifies success is true delete")
    public void userVerifiesSuccessIsTrueDelete() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }

    @Given("User creat an address")
    public void userCreatAnAddress() {
        body.put("address", "Ankara");
        body.put("city", "Bolu");
        body.put("isDefault", true);
        body.put("isSellerAddress", false);
        body.put("postal", "64200");
        body.put("state", "Ege");
        body.put("title", "Online");
        body.put("emptyBasket?", true);
        response = given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(body).post("/account/address/addAddress");
        response.prettyPrint();
        addressId = response.jsonPath().getInt("address.id");
    }

    @Given("User logs in API for delete event")
    public void userLogsInAPIForDeleteEvent() {
        token = ApiUtilities.loginWithAPI(USER.BUYER2.getEmail(), USER.BUYER2.getPassword());

    }
}