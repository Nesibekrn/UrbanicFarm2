package stepDefinitions.apiStepDef;

import com.github.javafaker.Faker;
import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static utilities.ApiUtilities.requestSpecification;

public class US120_121_StepDefs {

    String token;
    Map <String,Object> createOrder = new HashMap<>();
    Map <String,Object> product1 = new HashMap<>();
    Map <String,Object> product2 = new HashMap<>();
    Map <String,Object> product3 = new HashMap<>();
    Map <String,Object> product4 = new HashMap<>();
    List<Map> order = new ArrayList<>();

    String title = Faker.instance().name().name();

    Response response;
    @Given("User logs in with API for scheduled order")
    public void userLogsInWithAPIForScheduledOrder() {
        token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(),USER.SELLER.getPassword());
    }

    @When("User create a new scheduled order")
    public void userCreateANewScheduledOrder() {
        product1.put("id", 1);
        product1.put("wo_productQuantity", 1);
        product2.put("id", 4);
        product2.put("wo_productQuantity", 2);
        product3.put("id", 5);
        product3.put("wo_productQuantity", 2);
        product4.put("id", 6);
        product4.put("wo_productQuantity", 2);
        order.add(product1);
        order.add(product2);
        order.add(product3);
        order.add(product4);
        createOrder.put("weeklyOrderId", "");
        createOrder.put("title", title);
        createOrder.put("subTotal", 26);
        createOrder.put("deliveryCost", 10);
        createOrder.put("tip", 0);
        createOrder.put("total", "36.00");
        createOrder.put("type", "weekly");
        createOrder.put("wo_products",order);

        response = given().spec(requestSpecification(token)).contentType(ContentType.JSON).body(createOrder).post("/account/weeklyorder/createWeeklyOrder");
        response.prettyPrint();

    }

    @Then("User verifies that response is as expected")
    public void userVerifiesThatResponseIsAsExpected() {
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(title,response.jsonPath().getString("weekly_order.title"));

    }

    @When("User get scheduled order list")
    public void userGetScheduledOrderList() {
        response = given().spec(requestSpecification(token)).post("/account/weeklyorder/getWeeklyOrderList");
        response.prettyPrint();
    }

    @Then("User verifies that response is as expected for get scheduled order")
    public void userVerifiesThatResponseIsAsExpectedForGetScheduledOrder() {

        Assert.assertEquals(200,response.getStatusCode());

    }
}
