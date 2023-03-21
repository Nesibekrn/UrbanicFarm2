package stepDefinitions.uiStepDef.Register;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static stepDefinitions.Hooks.*;

public class US034_StepDefs extends CommonPage {

    static Faker faker = new Faker();
    Actions actions = new Actions(driver);
    List<String> lastNames = new ArrayList<>(Arrays.asList("Apaydin", "Duyarer", "Siler", "Basar"));
    Random rand = new Random();
    public static String firstname=faker.name().firstName();
    public static String middleName=faker.name().firstName();
    public static String lastName=faker.name().lastName().replaceAll("[^A-Za-z]", "");
    public static String email=faker.internet().emailAddress().toLowerCase();

    @And("user fills out the registration form")
    public void userFillsOutTheRegistrationForm() {
//        commonPage.getRegisterPage().firstname.sendKeys(new Faker().name().firstName());
        getRegisterPage().firstname.sendKeys(faker.name().firstName());
        getRegisterPage().middleName.sendKeys(faker.name().firstName());
//        commonPage.getRegisterPage().lastName.sendKeys(faker.name().lastName());
        getRegisterPage().lastName.sendKeys(lastNames.get(rand.nextInt(4)));
        getRegisterPage().email.sendKeys(faker.internet().emailAddress().toLowerCase());
        String password = faker.internet().password(8, 30, true, true, true);
        getRegisterPage().password.sendKeys(password);
        getRegisterPage().confirmPassword.sendKeys(password);
        getRegisterPage().zipCode.sendKeys(faker.address().zipCode(), Keys.TAB);
        BrowserUtilities.wait(5);
    }

    @And("user clicks on Register button")
    public void userClicksOnRegisterButton() {
//        actions.sendKeys(Keys.END).perform();

        BrowserUtilities.wait(2);
        getRegisterPage().registerButton.click();
    }


    @Then("user verifies following elements are visible")
    public void userVerifiesFollowingElementsAreVisible(DataTable dataTable) {
        List<String> texts = dataTable.column(0);

        for (int i = 0; i < texts.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//*[text()='"+texts.get(i)+"']"));
            Assert.assertTrue(element.isDisplayed());
        }

    }

    @And("user verifies following elements are clickable")
    public void userVerifiesFollowingElementsAreClickable(DataTable dataTable) {
        List<String> texts = dataTable.column(0);

        for (int i = 0; i < texts.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//*[text()='"+texts.get(i)+"']"));
            Assert.assertTrue(element.isEnabled());
        }
    }

    @And("user verifies Welcome to Urbanic Farm is visible")
    public void userVerifiesWelcomeToUrbanicFarmIsVisible() {
        Assert.assertTrue(getRegisterPage().welcome.isDisplayed());
    }
}
