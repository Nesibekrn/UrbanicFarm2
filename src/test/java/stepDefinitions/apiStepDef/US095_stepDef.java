package stepDefinitions.apiStepDef;

import enums.USER;
import enums.USERINFO;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class US095_stepDef {
    String token;
    public static Response response;
    public static RequestSpecification specification;
   public static Map<String,String> map=new HashMap<>();
    public static String uri = "https://test.urbanicfarm.com/api";

    public static RequestSpecification requestSpecification(USERINFO user){
        return specification=new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + user.getToken())
                .setBaseUri(uri)
                .setRelaxedHTTPSValidation()  // if site certification expire olursa diye kulanilir .Mecburu degil.
                .build();

    }

    @Given("user login in with api")
    public void userLoginInWithApi() {
        token=ApiUtilities.loginWithAPI(USER.SELLER.getEmail(), USER.SELLER.getPassword());
    }

    @Then("User crate new Hub info {string}")
    public void userCrateNewHubInfo(String hub) {
        createHub(hub);

   response.prettyPrint();
    }
    public static void createHub(String hubName) {
        map.put("hubUniqueName",hubName);
        response=given().contentType(ContentType.JSON).
                body(map).spec(requestSpecification(USERINFO.SELLER)).
                post("/account/hub/create");
        response.prettyPrint();

    }
}
