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

    //US31_Sevinc
    @FindBy(css = "#registration_form_firstname")
    public static WebElement registrationFirstName;

    @FindBy(xpath ="//input[@id='registration_form_middlename']" )
    public static WebElement getRegistrationMiddleName;

    @FindBy(css = "#registration_form_lastname")
    public static WebElement registrationLastName;
    // public static WebElement registrationFormLastName;

    @FindBy(xpath = "//*[@id=\"registration_form_email\"]")
    public static WebElement registrationFormEmailAdd;

    @FindBy(css = "#registration_form_plainPassword")
    public static WebElement registrationFormPassword;

    @FindBy(css ="#registration_form_confirmPassword" )
    public static WebElement registrationFormConfirmEmailAdd;

    @FindBy(name = "zipCode")
    public static WebElement registrationFormZipCode;

    @FindBy(xpath = "//div[text()='Welcome!']")
    public static WebElement Welcome;

}
