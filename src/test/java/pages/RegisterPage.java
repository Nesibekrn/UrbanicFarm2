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
    public  WebElement registrationFirstName;

    @FindBy(xpath ="//input[@id='registration_form_middlename']" )
    public WebElement registrationMiddleName;

    @FindBy(css = "#registration_form_lastname")
    public  WebElement registrationLastName;

    @FindBy(xpath = "//*[@id=\"registration_form_email\"]")
    public  WebElement registrationFormEmailAdd;

    @FindBy(css = "#registration_form_plainPassword")
    public  WebElement registrationFormPassword;

    @FindBy(css = "#registration_form_confirmPassword")
    public WebElement registrationFormConfirmPassword;

    @FindBy(css ="#registration_form_confirmPassword" )
    public  WebElement registrationFormConfirmEmailAdd;

    @FindBy(name = "zipCode")
    public  WebElement registrationFormZipCode;

    @FindBy(xpath = "//div[text()='Welcome!']")
    public  WebElement Welcome;
//ezra hoca
@FindBy(css = "#registration_form_firstname")
public WebElement firstname;

    @FindBy(css = "#registration_form_middlename")
    public WebElement middleName;

    @FindBy(css = "#registration_form_lastname")
    public WebElement lastName;

    @FindBy(css = "#registration_form_email")
    public WebElement email;

    @FindBy(css = "#registration_form_plainPassword")
    public WebElement password;

    @FindBy(css = "#registration_form_confirmPassword")
    public WebElement confirmPassword;
    @FindBy(css = "[name='zipCode']")
    public WebElement zipCode;

    @FindBy(css = ".btn.alazea-btn")
    public WebElement registerButton;
    @FindBy(xpath = "//h1")
    public WebElement welcome;

    //Rumeysa
    @FindBy(xpath = "//*[@name='zipCode']")
    public WebElement zipCodeBox;



}
