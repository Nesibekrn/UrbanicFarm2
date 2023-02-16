package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;
import static utilities.Driver.getDriver;

public class US020_StepDefs {

    HomePage homePage = new HomePage();

    @Given("the user goes to {string}.")
    public void theUserGoesTo(String url) {
        driver.get(url);

    }

    @And("the user scrolls down the home page.")
    public void theUserScrollsDownTheHomePage() {
        JavascriptExecutor je4 = (JavascriptExecutor) getDriver();
        je4.executeScript("window.scrollTo(0,document.body.scrollHeight)");


    }

    @And("the user clicks the {string}.")
    public void theUserClicksThe(String arg0) {
        //WebElement aboutUs = getDriver().findElement(By.xpath("(//a[@href='/about'])[3]"));
        BrowserUtilities.wait(3);
        homePage.aboutUs.isEnabled();
        homePage.aboutUs.click();


    }


    @Then("the user verifies the About us is enabled.")
    public void theUserVerifiesTheAboutUsIsEnabled() {
        //WebElement aboutUs = getDriver().findElement(By.xpath("(//a[@href='/about'])[3]"));
        BrowserUtilities.wait(3);
        Assert.assertTrue(homePage.aboutUs.isEnabled());
    }

    @Then("the user verifies the page is {string}.")
    public void theUserVerifiesThePageIs(String expectedurl) {
        String actualurl = getDriver().getCurrentUrl();
        Assert.assertEquals(expectedurl, actualurl);


    }

    @When("the user navigate to current.")
    public void theUserNavigateToCurrent() {
        //getDriver().navigate().to("https://test.urbanicfarm.com/");
        driver.navigate().to("https://test.urbanicfarm.com/");
    }

}