package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellShareTradePage extends CommonPage{

    @FindBy(css = ".ml-2.Navbar_cartText__1jkrK")
    public WebElement cartLink;

    @FindBy(xpath = "//a[normalize-space()='Contact us']" )
    public WebElement contactUsLinkSell;

    //Said S. US0046
    @FindBy(css = ".h4")
    public WebElement welcomeToUrbanicFarmCloseButton;

    //ramazan US045
    @FindBy(className = "Notifications_notificationIcon__3fwZN")
    public WebElement userClicksTheNotificationButton;


    //ramazan US04
    @FindBy(className = "Notifications_notificationDownEmpty__JLqO3")
    public WebElement userVerifiesNotificationPageIsVisible;

    //ayten US042
    @FindBy(xpath ="(//a[@href='/account/events'])[2]")
    public WebElement eventsButton;


    //aziz
    @FindBy(xpath = "(//*[text()='Scheduled delivery'])[1]")
    public WebElement scheduledDeliveryLink;
    //aziz
    @FindBy(xpath = "//a[@class='Sidebar_section_btn__1sp6i h6 '][9]")
    public WebElement relevantPageText;
    //aziz
    @FindBy(xpath = "//div[@class='CheckDistrictModal_x-btn__sVOij']")
    public WebElement relevantPageClose;

}
