package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonPage{

    //US37 -Niyaz-
    @FindBy(css = "#registration_form_firstname")
    public WebElement firstNameBox;
    @FindBy(css = "#registration_form_lastname")
    public WebElement lastNameBox;
    @FindBy(css = "#registration_form_email")
    public WebElement emailBox;
    @FindBy(css = "#registration_form_plainPassword")
    public WebElement passwordRegistrationBox;
    @FindBy(css = "#registration_form_confirmPassword")
    public WebElement confirmPasswordRegistrationBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitRegistrationButton;

}
