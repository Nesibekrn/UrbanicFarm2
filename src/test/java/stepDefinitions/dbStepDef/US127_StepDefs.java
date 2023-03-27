package stepDefinitions.dbStepDef;

import com.github.javafaker.Faker;
import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.DatabaseUtilities;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.DatabaseUtilities.resultSet;

public class US127_StepDefs {

    Map<String, Object> body = new HashMap<>();

    Response response;

    String title = Faker.instance().name().title();
    int attendee_limit = Faker.instance().number().numberBetween(1,50);

    int duration = Faker.instance().number().numberBetween(30,120);
    int addressId;
    int eventId;

    @Given("User add a new event from API")
    public void userAddANewEventFromAPI() {
        body.put("address", "Ankara");
        body.put("city", "Bolu");
        body.put("isDefault", true);
        body.put("isSellerAddress", false);
        body.put("postal", "64200");
        body.put("state", "Ege");
        body.put("title", "Online");
        body.put("emptyBasket?", true);
        response = given().contentType(ContentType.JSON).spec(requestSpecification(USER.EZRA.getToken())).body(body).post("/account/address/addAddress");
        response.prettyPrint();
        addressId = response.jsonPath().getInt("address.id");

        body.put("title", title);
        body.put("date", "2023-03-18T23:59");
        body.put("fee", 35);
        body.put("duration", duration);
        body.put("attendeeLimit", attendee_limit);
        body.put("addressId", addressId);
        body.put("tac", "engineer");
        response = given().spec(requestSpecification(USER.EZRA.getToken())).formParams(body).post("/account/event/create");
        response.prettyPrint();
        eventId = response.jsonPath().getInt("event.id");
    }

    @Then("user verifies the added event exist")
    public void userVerifiesTheAddedEventExist() throws SQLException {

        DatabaseUtilities.executeQuery("SELECT * FROM event WHERE title = '" + title + "' AND duration = '" + duration + "' AND attendee_limit = '" + attendee_limit + "'");
        if (resultSet.next())
        {
            System.out.println("Event Bulundu");

        }else {
            System.out.println("Event kaydedilmedi");
        }
    }
}
