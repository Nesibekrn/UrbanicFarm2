package stepDefinitions.apiStepDef;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.specification;


public class US0111_stepDefs {
    Response response;

    @Then("User get All events details")
    public void userGetAllEventsDetails() {

//         response = given().contentType(ContentType.JSON)
//                .when().spec(requestSpecification(US086_StepDefs.token))
//                .post("/public/getAllEvents");
//
        given().contentType(ContentType.JSON)
                .when()
                .spec(requestSpecification(US086_StepDefs.token)).post("/public/getAllEvents")
                .then()
                .statusCode(200);

//     response.prettyPrint();


    }


}