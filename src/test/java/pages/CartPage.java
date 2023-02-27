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

    @FindBy(xpath = "//button[@class='btn btn-primary mr-4']")
    public List<WebElement> yesButton;
    @FindBy(xpath = "//*[local-name()='svg']/*[local-name()='g'][@fill='#f44336']")
    public List<WebElement> xIconButton;

}


