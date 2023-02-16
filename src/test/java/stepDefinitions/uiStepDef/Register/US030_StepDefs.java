package stepDefinitions.uiStepDef.Register;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;

import javax.lang.model.element.Name;

import static stepDefinitions.Hooks.actions;

public class US030_StepDefs extends CommonPage {
    @When("user verifies Name, Surname, Email, Password fields are functional")
    public void userVerifiesNameSurnameEmailPasswordFieldsAreFunctional() {
        Assert.assertTrue(getRegisterPage().registrationFirstName.isEnabled());
        Assert.assertTrue(getRegisterPage().registrationLastName.isEnabled());
        Assert.assertTrue(getRegisterPage().registrationFormEmailAdd.isEnabled());
        Assert.assertTrue(getRegisterPage().registrationFormPassword.isEnabled());
    }

    @When("user verifies {string}, {string}, {string}, {string} fields are not blank")
    public void userVerifiesFieldsAreNotBlank(String Name, String Surname, String Email, String Password) {
        getRegisterPage().registrationFirstName.sendKeys(Name);
        getRegisterPage().registrationLastName.sendKeys(Surname);
        getRegisterPage().registrationFormEmailAdd.sendKeys(Email);
        getRegisterPage().registrationFormPassword.sendKeys(Password);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("user verifies {string} is visible")
    public void userVerifiesIsVisible(String Allerts) {

        if (getRegisterPage().registrationFirstName.getAttribute("value").isEmpty()){
            Assert.assertEquals(Allerts,getRegisterPage().registrationFirstName.getAttribute("validationMessage"));
        }if (getRegisterPage().registrationLastName.getAttribute("value").isEmpty()){
            Assert.assertEquals(Allerts,getRegisterPage().registrationLastName.getAttribute("validationMessage"));
        }if (getRegisterPage().registrationFormEmailAdd.getAttribute("value").isEmpty()){
            Assert.assertEquals(Allerts,getRegisterPage().registrationFormEmailAdd.getAttribute("validationMessage"));

        }if (getRegisterPage().registrationFormPassword.getAttribute("value").isEmpty()){
            Assert.assertEquals(Allerts,getRegisterPage().registrationFormPassword.getAttribute("validationMessage"));
        }

    }
    /*
    ->Yöntem 2: Feature da example bölümüne <Index> için bir sütun daha eklemek gerekiyor.

    @Then("user verifies {string} is visible {string}")
    public void userVerifiesIsVisible(String Allerts, String index) {
        switch (index){
            case "1":
                Assert.assertEquals(Allerts,getRegisterPage().registrationFirstName.getAttribute("validationMessage"));
                break;
            case "2":
                 Assert.assertEquals(Allerts,getRegisterPage().registrationLastName.getAttribute("validationMessage"));
                break;
            case "3":
                Assert.assertEquals(Allerts,getRegisterPage().registrationFormEmailAdd.getAttribute("validationMessage"));
                break;
            case "4":
                Assert.assertEquals(Allerts,getRegisterPage().registrationFormPassword.getAttribute("validationMessage"));
                break;
        }
    }
     */
}
