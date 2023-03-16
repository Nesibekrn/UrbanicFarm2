package stepDefinitions;

import enums.USER;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ApiUtilities;

public class US112_113_Stepdefs {

    String token;

    @Given("User logs in as Seller with API")
    public void userLogsInAsSellerWithAPI() {
        token = ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(), USER.SELLER1.getPassword());
    }

    @And("User creates Event")
    public void userCreatesEvent() {

    }

    @And("User gets Register")
    public void userGetsRegister() {
    }

    @Then("User verifies success message is true")
    public void userVerifiesSuccessMessageIsTrue() {
    }

    @Then("User verifies if status code is {int}")
    public void userVerifiesIfStatusCodeIs(int arg0) {
    }

    @And("User Go To Payment")
    public void userGoToPayment() {
    }
}
