package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.Driver.getDriver;

public class OrdersPage extends  CommonPage{
    @FindBy(xpath = "//a[@href='/account/orders']")
    public WebElement order;
    @FindBy(xpath = " //section[@class='card mb-2']")
    public List<WebElement> orderlist;
    @FindBy(xpath = "//a[contains(text(),'View order details')]")
    public WebElement orderviewdetails;
    @FindBy(xpath = "//div/span[contains(text(),'Order Details')]")
    public WebElement orderDetail;
    @FindBy(xpath = "//h5[contains(text(),'Order summary')]")
    public WebElement orderSummary;
    @FindBy(xpath = "//h5[contains(text(),'Order content')]")
    public WebElement orderContent;
    @FindBy(xpath = "//a[contains(text(),'Seller page')]")
    public WebElement sellerPage;
    @FindBy(xpath = "(//span[contains(text(),'Seller address')])[1]")
    public WebElement sellerAdress;
    @FindBy(xpath = "(//div[@role='button'])[1]")
    public WebElement address2page;


}
