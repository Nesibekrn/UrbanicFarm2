package stepDefinitions.apiStepDef;

import enums.USER;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ApiUtilities;

import static utilities.ApiUtilities.response;

public class US082_StepDefs {
    public static
    String token;
    @Given("user connects to the {string} api")
    public void userConnectsToTheApi(String arg0) {
        token = ApiUtilities.loginWithAPI(USER.SELLER1.getEmail(), USER.SELLER1.getPassword());
    }
    @Then("the user verifies that the status code is {int}")
    public void theUserVerifiesThatTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }
}

