package stepDefinitions.apiStepDef;

import io.cucumber.java.en.And;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static stepDefinitions.apiStepDef.US103_StepDefs.token;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US104_StepDefs {
    @And("the user connects to the getmyBuys api")
    public void theUserConnectsToTheGetmyBuysApi() {
        response=given().spec(requestSpecification(token)).post("/account/order/get/myBuys");
        response.prettyPrint();
    }

    @And("the user verifies buyer ids numbers more than one")
    public void theUserVerifiesBuyerIdsNumbersMoreThanOne() {
        List<Object> id = response.jsonPath().getList("id");
        Assert.assertTrue(id.size()>1);

    }
}
