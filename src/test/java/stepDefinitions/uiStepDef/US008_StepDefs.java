package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;

import static stepDefinitions.Hooks.driver;

public class US008_StepDefs extends CommonPage {

    @Given("user clicks on {string} button")
    public void user_clicks_on_button(String string) {
        WebElement registerButton = driver.findElement(By.xpath("//*[text()='Register']"));
        registerButton.click();
    }

    @Then("user verifies that current url for register")
    public void user_verifies_that_current_url_for_register() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }
}