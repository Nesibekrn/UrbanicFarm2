package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CommonPage{

    @FindBy(xpath = "//td[@class='text-end py-3']/p")
    public WebElement subtotal;

    @FindBy(xpath = "//button[@class='collapsible_toggle__1oudq']")
    public WebElement enterPromoCodeButton;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement promoCodeApplyButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputPromoCode;


    @FindBy(xpath = "//div[@role='alert']")
    public WebElement invalidPromoCodeMessage;


    @FindBy(xpath = "//strike/following-sibling::p")
    public WebElement discountPromoCode;

    //nesibeUS
    @FindBy(xpath = "//*[text()='PROCEED TO CHECKOUT']")
    public WebElement proceedToCheckout;
    @FindBy(xpath = "//*[text()='Next']")
    public WebElement nextButton;
    @FindBy(xpath = "//*[text()='Go To Payment']")
    public WebElement goToPaymentButton;
    @FindBy(xpath = "//*[text()='Log In']")
    public WebElement loginPayPalButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement payPalEmailBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement payPalPasswordBox;
    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement payPalLoginButton;
    @FindBy(xpath = "//button[@id='payment-submit-btn']")
    public WebElement payPalCompletePurchaseButton;
    @FindBy(xpath = "//*[text()='Payment successful']")
    public WebElement paymentSuccessfulText;


    @FindBy(xpath = "//button[@class='btn btn-primary mr-4']")
    public List<WebElement> yesButton;
    @FindBy(xpath = "//*[local-name()='svg']/*[local-name()='g'][@fill='#f44336']")
    public List<WebElement> xIconButton;

}


