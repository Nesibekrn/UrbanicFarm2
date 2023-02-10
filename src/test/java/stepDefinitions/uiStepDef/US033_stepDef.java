package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;

import static stepDefinitions.Hooks.actions;

public class US033_stepDef extends CommonPage {




    @When("user send to zip code on the register")
    public void userSendToZipCodeOnTheRegister() {
     getRegisterPage().zipCodeBox.sendKeys("1235");
    }

    @Then("zip code text suppose to be red")
    public void zipCodeTextSupposeToBeRed() {
       String actualTextColor = getRegisterPage().zipCodeBox.getCssValue("color");
        System.out.println("actualTextColor = " + actualTextColor);
    }

    @When("user click on enter")
    public void userClickOnEnter() {
        actions.sendKeys(Keys.ENTER);
    }

    @Then("user suppose to see {string} test")
    public void userSupposeToSeeTest(String expectedVaidationMessage) {
       String actualValidationMessage = getRegisterPage().zipCodeBox.getAttribute("validationMessage");
        Assert.assertEquals(expectedVaidationMessage,actualValidationMessage);
    }







}
