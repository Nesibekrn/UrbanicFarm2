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
    @FindBy(css = "td.align-middle.text-end svg")
    public List<WebElement> removeProductFromCart;


    @FindBy(css = "button.Basket_checkOutBtn__1946L")
    public WebElement proceedToCheckOut;

    @FindBy(css = "button.collapsible_toggle__1oudq")
    public WebElement enterPromoCode_button;

    @FindBy(css = "[placeholder='your promo code']")
    public WebElement enterPromoCode_text;

    @FindBy(id = "promo-code")
    public WebElement enterPromoCode_apply;


    @FindBy(xpath = "(//td[@class='text-end py-3'])[1]/p")
    public WebElement cartTotal_subtotal;



    @FindBy(xpath = "(//td[@class='text-end py-3'])[2]")
    public WebElement cartTotal_deliveryCost;

    @FindBy(xpath = "(//td[@class='text-end py-3'])[3]")
    public WebElement cartTotal_total;

    @FindBy(css = "button.proceed_btn__vZFGE[type='button']")
    public WebElement next;

    @FindBy(xpath = "//button[@class='proceed_btn__vZFGE'][2]")
    public WebElement goToPayment;

    @FindBy(css = ".css-ltr-1m7plzc-button-Button")
    public WebElement paypal_btnLogin_up;
    @FindBy(id = "btnLogin")
    public WebElement paypal_btnLogin_down;

}


