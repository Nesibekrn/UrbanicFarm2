package stepDefinitions.apiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.ApiUtilities;
import utilities.ConfigurationReader;

import static enums.USER.SELLER;
import static utilities.ApiUtilities.response;

public class US087_StepDefs {

    String token;

    @Given("User login with APİ user")
    public void userLoginWithAPİUser() {
        token = ApiUtilities.loginWithAPI(SELLER.getEmail(), SELLER.getPassword());
        ApiUtilities.loginWithAPI(ConfigurationReader.getProperty("sellerEmail"),ConfigurationReader.getProperty("sellerPassword"));

    }

    @When("User adds addresses {string},{string},{string},{string},{string},{string},{string},{string}")
    public void userAddsAddresses(String address, String city, String isDefault, String isSellerAddress, String postal, String state, String title, String emptyBasket) {

        ApiUtilities.Address.addAddress(address, city, Boolean.parseBoolean(isDefault),
                Boolean.parseBoolean(isSellerAddress), postal, state, title, Boolean.parseBoolean(emptyBasket), token);
        response.prettyPrint();
    }
}
