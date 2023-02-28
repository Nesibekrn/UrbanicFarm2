package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends  CommonPage{


//User clicks Account Name Navbar
@FindBy(xpath="//span[text()='Alicante Tomato']")
    public WebElement productName;
@FindBy(xpath = "//span[text()='Unit Price:']")
    public WebElement productPrice;
@FindBy(xpath = "//span[text()='Qty:']")
    public WebElement productLb;

@FindBy(xpath = "//span[text()='Unit Total:']")
    public WebElement productTotal;
@FindBy(xpath = "//img[@class='rounded']")
    public WebElement productImage;

@FindBy(xpath = "//span[text()='Rate the product']")
    public WebElement rateTheProduct;

@FindBy(xpath = "//a[text()='rate the seller']")
    public WebElement rateTheSeller;

@FindBy(xpath = "//*[@class='cursor-pointer'][last()]")
    public WebElement cursorPointer;

@FindBy(xpath = "//*[@class='sc-bdnxRM bQSYRq']")
    public WebElement commitBox;

@FindBy(xpath="(//button[@type='button'])[2]")
    public WebElement submitButton;

@FindBy(xpath="//div[@role='alert']")
    public WebElement alert;
}
