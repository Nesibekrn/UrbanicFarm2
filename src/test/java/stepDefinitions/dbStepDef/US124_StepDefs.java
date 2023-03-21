package stepDefinitions.dbStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;
import utilities.DatabaseUtilities;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.requestSpecification;
import static utilities.DatabaseUtilities.resultSet;

public class US124_StepDefs {

    public static String address= Faker.instance().address().fullAddress();
    public static String city= Faker.instance().address().city();
    public static String postal= Faker.instance().address().zipCode();
    public static String state= Faker.instance().address().state();
    public static String title= Faker.instance().name().title();

    @Given("user adds an address from api")
    public void userAddsAnAddressFromApi() {
         Response response;

       Map<String, Object> payload=new HashMap<>();
        payload.put("address", address);
        payload.put("city", city);
        payload.put("isDefault", true);
        payload.put("isSellerAddress", false);
        payload.put("postal", postal);
        payload.put("state", state);
        payload.put("title", title);
        payload.put("emptyBasket?", false);

        response = given().
                contentType(ContentType.JSON).
                spec(requestSpecification(ConfigurationReader.getProperty("sellerTokenOmer"))).
                body(payload).
                post("/account/address/addAddress");

        response.prettyPrint();

    }

    @Then("user verifies the added address exists")
    public void userVerifiesTheAddedAddressExists() throws SQLException {

        DatabaseUtilities.executeQuery("SELECT * FROM address WHERE title='"+title+"' AND city='"+city+ "' AND state='"+state+"'");
        if(resultSet.next()) {
            System.out.println("adres bulundu");

        }
        else{
            System.out.println("kullanici kaydedilmedi");
        }


    }

}
