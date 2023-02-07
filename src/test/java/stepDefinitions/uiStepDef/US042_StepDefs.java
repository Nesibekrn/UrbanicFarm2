package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;

import static utilities.Driver.getDriver;

public class US042_StepDefs {

    @When("the user clicks login module button")
    public void theUserClicksLoginModuleButton() {
        WebElement loginmodule  = getDriver().findElement(By.xpath("(//a[@href='/auth/login'])[1]"));
        BrowserUtilities.wait(2);
        loginmodule.click();

    }

    @And("the user fill out valid email {string} in username text box")
    public void theUserFillOutValidEmailInUsernameTextBox(String email) {
        WebElement emailtextbox  = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailtextbox.sendKeys(email);

    }

    @And("the user fill out valid email {string} in password text box")
    public void theUserFillOutValidEmailInPasswordTextBox(String password) {
        WebElement passwordtextbox  = getDriver().findElement(By.xpath("//input[@name='password']"));
  passwordtextbox.sendKeys(password);
    }

    @And("the user clicks login button on the login page")
    public void theUserClicksLoginButtonOnTheLoginPage() {

        WebElement loginbutton  = getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginbutton.click();
        BrowserUtilities.wait(2);
    }

    @Then("the user verifes page is {string}")
    public void theUserVerifesPageIs(String url) {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Then("the user verifies account name is displayed")
    public void theUserVerifiesAccountNameIsDisplayed() {
        WebElement accountName  = getDriver().findElement(By.xpath("//a[contains(text(),'ayten')]"));
        BrowserUtilities.wait(2);
                Assert.assertTrue(accountName.isDisplayed());
    }

    @And("the user clicks Sale-Pay-Trade module")
    public void theUserClicksSalePayTradeModule() {
        WebElement salePTmodule = getDriver().findElement(By.xpath("(//div/span[contains(text(),'Sell-Share')])[1]"));
        BrowserUtilities.wait(2);
        salePTmodule.click();

    }

    @Then("the user verifies Sale-Pay-Trade modele is enabled")
    public void theUserVerifiesSalePayTradeModeleIsEnabled() {
        WebElement salePTmodule = getDriver().findElement(By.xpath("(//div/span[contains(text(),'Sell-Share')])[1]"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(salePTmodule.isEnabled());

    }

    @And("the user clicks events button")
    public void theUserClicksEventsButton() {
        WebElement eventsButton = getDriver().findElement(By.xpath("(//a[contains(text(),'Events')])[1]"));
        BrowserUtilities.wait(3);
        Assert.assertTrue(eventsButton.isEnabled());
        BrowserUtilities.wait(2);
        eventsButton.click();



        

    }
}
