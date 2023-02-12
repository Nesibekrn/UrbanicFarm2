package stepDefinitions.uiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;

import static stepDefinitions.Hooks.driver;

public class US009_StepDef extends CommonPage {



    @Given("user clicks on {string}")
    public void user_clicks_on(String string) {
        WebElement GetFreshProduce = driver.findElement(By.className("section-2_shopButton__17T04"));
        GetFreshProduce.click();
    }
    @Then("verifies that current url")
    public void verifies_that_current_url() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://test.urbanicfarm.com/explore",currentUrl);
    }



}
