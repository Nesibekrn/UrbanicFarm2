package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;


public class US085_StepDef extends CommonPage {

private static String token;
private static Response response;
Map<String,Object> new_phone = new HashMap<>();

    @Given("User goes to api for change account info")
    public void userGoesToApiForChangeAccountInfo() {
        token = ApiUtilities.loginWithAPI(USER.SELLER.getEmail(),USER.SELLER.getPassword());
    }

    @When("User change phone number as {int}")
    public void userChangePhoneNumberAs(int phone) {
        new_phone.put("new phone", 956224488);
        response=given().spec(requestSpecification(token)).formParams(new_phone).post("/account/change/phone");
        response.prettyPrint();
    }

    @Then("User verify new phone number as {string}")
    public void userVerifyNewPhoneNumberAs(String  newPhone) {
        Assert.assertEquals(newPhone,response.jsonPath().getString("phone"));
    }
}
