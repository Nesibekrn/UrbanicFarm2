package stepDefinitions.apiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
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
    Integer addressIdN;

    @Given("User logs in with api for deletion address")
    public void userLogsInWithApiForDeletionAddress() {
        token= ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"),ConfigurationReader.getProperty("sellerPassword"));
    }
    @When("User add an address")
    public void userAddAnAddress(DataTable dataTable) {
        List<String> keys=dataTable.column(0);
        List<String> values=dataTable.column(1);
        System.out.println("key list"+keys);
        System.out.println("value list"+values);

        Map<String,Object> addAddressN=new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            addAddressN.put(keys.get(i),values.get(i));
        }
        System.out.println("map"+addAddressN);
        response = given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(addAddressN).post("/account/address/addAddress");
        response.prettyPrint();
        addressIdN=response.jsonPath().getInt("address.id");
        System.out.println(addressIdN);
    }
    @When("User deletes existing address from api")
    public void userDeletesExistingAddressFromApi() {
        Map<String,Object>payload=new HashMap<>();
        payload.put("addressId",addressIdN);
        response=given().contentType(ContentType.JSON).spec(requestSpecification(token)).body(payload).post("/account/address/delete");
        response.prettyPrint();
    }



}
