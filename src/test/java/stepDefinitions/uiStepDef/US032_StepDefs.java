package stepDefinitions.uiStepDef;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.RegisterPage;
import utilities.BrowserUtilities;
import utilities.Driver;

import static pages.RegisterPage.*;
import static stepDefinitions.Hooks.driver;

public class US032_StepDefs extends RegisterPage {
    @And("user enter first name box")
    public void userEnterFirstNameBox() {
        registrationFirstName.sendKeys("sevinc" + Keys.ENTER);
    }
    @And("user enter last name box")
    public void userEnterLastNameBox() {
        BrowserUtilities.wait(2);
        registrationLastName.sendKeys("ozmen" + Keys.ENTER);
    }
    @Given("user enters invalid password")
    public void userEntersInvalidPassword() {
        BrowserUtilities.wait(2);
        registrationFormPassword.sendKeys("11111" + Keys.ENTER);
    }
    @Then("user verifies that the alert is displayed on the Registration Page")
    public void userVerifiesThatTheAlertIsDisplayedOnTheRegistrationPage() {
        Assert.assertEquals("Must contain at least one number and one uppercase and lowercase letter, " +
                        "and at least 8 or more characters",
                RegisterPage.registrationFormPassword.getAttribute("title"));
    }
    @And("user enters valid confirm password")
    public void userEntersValidConfirmPassword() {
        registrationFormPassword.sendKeys("12345Aa!" + Keys.ENTER);
    }
    @When("user enter invalid confirm password")
    public void userEnterInvalidConfirmPassword() {
        registrationFormConfirmEmailAdd.sendKeys("12345Aaa" + Keys.ENTER);
    }
    @Then("user verifies that the {string} alert appears")
    public void userVerifiesThatTheAlertAppears(String arg0) {
        Assert.assertEquals("Passwords Don't Match",
                RegisterPage.registrationFormConfirmEmailAdd.getAttribute("validationMessage"));

    }
}




