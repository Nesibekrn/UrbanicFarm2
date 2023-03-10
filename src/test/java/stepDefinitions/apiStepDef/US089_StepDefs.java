package stepDefinitions.apiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.ApiUtilities.response;

public class US089_StepDefs {
    String token;
    Integer addressId;

    @Given("User logs in with api for deletion address")
    public void userLogsInWithApiForDeletionAddress() {
        token= ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"),ConfigurationReader.getProperty("sellerPassword"));
    }
    @When("User add an address")
    public void userAddAnAddress(DataTable dataTable) {
        List<String> keys=dataTable.column(0);
        List<String> values=dataTable.column(1);
        Map<String,Object> addAddress=new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            addAddress.put(keys.get(i),values.get(i));
        }
        response = given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(addAddress).post("/account/address/addAddress");
        response.prettyPrint();
        addressId=response.jsonPath().getInt("address.id");
    }
    @When("User deletes existing address from api")
    public void userDeletesExistingAddressFromApi() {
        Map<String,Object>payload=new HashMap<>();
        payload.put("addressId",addressId);
        response=given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(payload).post("/account/address/delete");
        response.prettyPrint();
    }

    @Then("User verifies that success is true")
    public void userVerifiesThatSuccessIsTrue() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }


}
