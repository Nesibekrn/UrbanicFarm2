package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.Driver.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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


    @FindBy(xpath = "//*[text()='Orders']")
    public WebElement ordersLink;
    @FindBy(xpath = "//div[contains(@class,'active')]")
    public WebElement activeOrderStatus;
    @FindBy(xpath = "//*[@class='mr-2']/select")
    public WebElement orderStatusDropdown;
    @FindBy(xpath = "//*[@class='Notifications_infoCommonText__1SAdH']")
    public WebElement notificationText;
    @FindBy(xpath = "//*[@class='Notifications_infoCommonText__1SAdH']")
    public List<WebElement> notificationList;
    @FindBy(xpath = "//*[text()='Mark all as read']")
    public WebElement markAllAsReadLink;
    @FindBy(xpath = "//*[@class='Notifications_notificationDownIcon__2wt8u']")
    public WebElement notificationXButton;
    @FindBy(xpath = "//*[@class='Notifications_sliderNone__31Amf']")
    public WebElement markReadCheckbox;
    @FindBy(xpath = "//*[@class='Notifications_slider__CvU2V']")
    public WebElement markUnreadCheckbox;
    @FindBy(xpath = "//*[@class='Notifications_slider__CvU2V']")
    public List<WebElement> markUnreadList;
    @FindBy(xpath = "//*[@class='Notifications_sliderNone__31Amf']")
    public List<WebElement> markReadList;
    @FindBy(xpath = "//*[text()='View all']")
    public WebElement viewAllLink;

}
