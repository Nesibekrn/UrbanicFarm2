package pages;

import enums.USERINFO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @FindBy(css = "[name='email']")
    private WebElement emailText;

    @FindBy(css = "[name='password']")
    private WebElement passwordText;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public void loginMethod(String email, String password) {
        emailText.sendKeys(email);
        passwordText.sendKeys(password);
        submitButton.click();
    }

    public void loginMethod(USERINFO user) {
        emailText.sendKeys(user.getEmail());
        passwordText.sendKeys(user.getPassword());
        submitButton.click();
    }

    //US37-Niyaz-
    @FindBy(xpath = "//*[text()='Forgot Password']")
    public WebElement forgotPasswordLink;
    @FindBy(xpath = "(//input[@type='email'])[2]")
    public WebElement pleaseVerifyYourEmailBox;
    @FindBy(xpath = "//*[text()='Please verify your email.']")
    public WebElement pleaseVerifyYourEmailText;
    @FindBy(xpath = "//*[text()='Verify Email']")
    public WebElement verifyEmailButton;
    @FindBy(css = ".Toastify__toast-body.toastr_custom-toastr__iiU37")
    public WebElement alertText;
    @FindBy(xpath = "//*[text()='We have sent the password reset link to your email. Check your mail box.']")
    public WebElement weHaveSentResetLinkMessage;
    @FindBy(css = ".text-center.mb-3")
    public WebElement changePasswordTitle;



}
