package stepDefinitions.apiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;




public class US093_StepDefs {

    String token;
    Response response;
    @Given("User login with API change flexible delivery")
    public void userLoginWithAPIChangeFlexibleDelivery() {
       token = ApiUtilities.loginWithAPI("seller_urban2@yopmail.com","Seller2/");
    }

    @When("User change flexible delivery")
    public void userChangeFlexibleDelivery(DataTable dataTable) {
        Map<String,Object> payLoad= new HashMap<>();

        Map<String,Object> innerMap = new HashMap<>();
        innerMap.put(dataTable.cell(6,0),(Integer.parseInt(dataTable.cell(6,1))));
        innerMap.put(dataTable.cell(7,0),(Integer.parseInt(dataTable.cell(7,1))));
        innerMap.put(dataTable.cell(8,0),(Integer.parseInt(dataTable.cell(8,1))));

        payLoad.put(dataTable.cell(0,0),new String[]{dataTable.cell(0,1)});
        payLoad.put(dataTable.cell(1,0),(Integer.parseInt(dataTable.cell(1,1))));
        payLoad.put(dataTable.cell(2,0),(Integer.parseInt(dataTable.cell(2,1))));
        payLoad.put(dataTable.cell(3,0),(Integer.parseInt(dataTable.cell(3,1))));
        payLoad.put(dataTable.cell(4,0),(Integer.parseInt(dataTable.cell(4,1))));
        payLoad.put(dataTable.cell(5,0),new Map[]{innerMap});

        response=given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(payLoad).post("/account/change/delivery");
        response.prettyPrint();
    }

    @Then("User verifies flexible delivery success is true")
    public void userVerifiesFlexibleDeliverySuccessIsTrue() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }
    /* İÇ İÇE MAP:
    {
    "deliveryType": [
                    "SELLER_FLEXIBLE"
                    ],
    "freeDeliveryRange": 3,
    "maxDeliveryRange": 3,
    "minFreeDeliveryOrder": 3,
    "perMileCost": 3,
     "flexibleDeliveryOptions": [
                                    {
                                    "deliveryBy": 3,
                                    "orderBegin": 3,
                                    "orderEnd": 3
                                    }
                                ]
    }
     */
}
