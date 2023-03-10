package stepDefinitions.apiStepDef;

import enums.USER;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.http.ContentType;

import utilities.ConfigurationReader;



import static io.restassured.RestAssured.given;

public class US_091 {


    enum DELIVERYTYPES {
        SELLER_FLEXIBLE,
        BUYER_PICKUP_FROM_BRANCH,
        BUYER_PICKUP,
        SELLER_DELIVERY
    }

    Response response;
    String endpoint = "https://test.urbanicfarm.com/api/account/change/delivery";
    String time = "09:00-12:00";


    @Test
    public void mapBody() {
        Map<String, Object> body = new HashMap();

        List<String> deliveryTypeList = new ArrayList<>();
        deliveryTypeList.add(DELIVERYTYPES.SELLER_FLEXIBLE.name());

        body.put("freeDeliveryRange", 10);
        body.put("maxDeliveryRange", 30);
        body.put("minFreeDeliveryOrder", 5);
        body.put("perMileCost", 1);


        body.put("deliveryType", deliveryTypeList);
        Map<String, Integer> innerMap = new HashMap<>();
        innerMap.put("deliveryBy", 8973);
        innerMap.put("orderBegin", 4040);
        innerMap.put("orderEnd", 3000);

        List<Map<String, Integer>> mapFlexiableOptions = new ArrayList<>();

        mapFlexiableOptions.add(innerMap);

        body.put("flexibleDeliveryOptions", mapFlexiableOptions);


        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USER.BUYER.getToken())
                .body(body)
                .post(endpoint);

        response.prettyPrint();


    }
    @Test
    public void test01(){
        String endpoint = "https://test.urbanicfarm.com/api/account/change/delivery";
        String time = "09:00-12:00";
        String body="{\n" +
                "  \"availabilityBranch\": \"02:00-03:00\",\n" +
                "  \"deliveryType\": [\n" +
                "    \"BUYER_PICKUP_FROM_BRANCH\"\n" +
                "  ]\n" +
                "}";
     response=given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(ConfigurationReader.getProperty("buyerToken"))
                .body(body)
                .post(endpoint);
//                then().assertThat().
//                contentType(ContentType.JSON).
//                statusCode(200);

////
//        System.out.println(response.getStatusCode());
//        System.out.println("////////");
//        System.out.println(response.asString());
//        System.out.println("////////");
//        System.out.println(response.getContentType());
//        System.out.println("////////");
//        System.out.println(response.getBody().prettyPrint());

    }
    @Test
    public void test02(){
        String endpoint = "https://test.urbanicfarm.com/api/account/change/delivery";
        String time = "09:00-12:00";
        String body="{\n" +
                "  \"availability\": \"02:00-03:00\",\n" +
                "  \"deliveryType\": [\n" +
                "    \"BUYER_PICKUP\"\n" +
                "  ]\n" +
                "}";

        response=given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(ConfigurationReader.getProperty("buyerToken"))
                .body(body)
                .post(endpoint);

        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());

    }

}
