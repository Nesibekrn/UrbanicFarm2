package stepDefinitions;

import enums.USER;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;

public class US112_113_Stepdefs {
    Map<String, Object> body = new HashMap<>();

    Response response;
    String token;
    String tokenBuyer;
    int addressId;
    int eventId;
    int attendanceId;

    @Given("User logs in as Seller with API")
    public void userLogsInAsSellerWithAPI() {
        token = ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(), USER.SELLER1.getPassword());
        tokenBuyer = ApiUtilities.loginWithAPI(USER.BUYER.getEmail(), USER.BUYER.getPassword());
            }

    @And("User creates Event")
    public void userCreatesEvent() {
        body.put("title", "meeting");
        body.put("date", "2023-03-18T23:59");
        body.put("fee", 35);
        body.put("duration", 60);
        body.put("attendeeLimit", 50);
        body.put("addressId", addressId);
        body.put("tac", "engineer");
        response = given().spec(requestSpecification(tokenBuyer)).formParams(body).post("/account/event/create");
        response.prettyPrint();
        eventId = response.jsonPath().getInt("event.id");
    }

    @And("User gets Register")
    public void userGetsRegister() {
        body.put("eventId", eventId );
        body.put("numberOfAttendees", "4");
        response = given().
                contentType(ContentType.JSON).
                spec(requestSpecification(token)).
                body(body).
                post("/account/event/register");
        attendanceId = response.jsonPath().getInt("attendanceId");
        response.prettyPrint();
    }

    @Then("User verifies success message is true")
    public void userVerifiesSuccessMessageIsTrue() {
        Assert.assertTrue(response.jsonPath().getBoolean("success") );
    }

    @Then("User verifies if status code is {int} on Event")
    public void userVerifiesIfStatusCodeIsOnEvent(int arg0) {
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
       // Assert.assertEquals(200, response.getStatusCode());
    }

    @And("User Go To Payment")
    public void userGoToPayment() {
        body.put("attendanceId", attendanceId);
        response = given().
                contentType(ContentType.JSON).
                spec(requestSpecification(token)).
                body(body).
                post("/account/event/attendance/gotopayment");
        response.prettyPrint();
    }

    @And("User creates Address")
    public void userCreatesAddress() {
        body.put("address", "Ankara");
        body.put("city", "Bolu");
        body.put("isDefault", true);
        body.put("isSellerAddress", false);
        body.put("postal", "64200");
        body.put("state", "Ege");
        body.put("title", "Online");
        body.put("emptyBasket?", true);
        response = given().contentType(ContentType.JSON).spec(requestSpecification(tokenBuyer)).body(body).post("/account/address/addAddress");
        response.prettyPrint();
        addressId = response.jsonPath().getInt("address.id");
    }
}
