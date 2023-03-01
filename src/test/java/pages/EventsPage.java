package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends CommonPage{

    @FindBy(css = ".CreateEvents_inlineErrormsg__2AiUS")
    public List<WebElement> allAlertMessageText;

    @FindBy(xpath = "//button[text()='Create New Event']")
    public WebElement createNewAddressButton;


    @FindBy(id = "title")
    public WebElement tittle;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "date")
    public WebElement Date;

    @FindBy(id = "time")
    public WebElement Time;

    @FindBy(id = "fee")
    public WebElement Fee;

    @FindBy(id = "duration")
    public WebElement Duration;

    @FindBy(id = "attendeeLimit")
    public WebElement Attendee;

    @FindBy(id = "schedule")
    public WebElement Schedule;

    @FindBy(id = "description")
    public WebElement Description;

    @FindBy(id = "tac")
    public WebElement TersAndConditions;

@FindBy(xpath = "//a[text()='My Events']")
    public WebElement MyEvents;

@FindBy(xpath="//input[@id='title']")
    public WebElement titleName;

@FindBy(xpath="//button[@class='btn btn-outline-success px-4']")
    public WebElement submitButton;

@FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteButton;

@FindBy(xpath = "(//button[text()='Yes'])[1]")
    public WebElement yesButton;
@FindBy(xpath="//*[text()='My Scheduled Events']")
    public WebElement MyScheduledEvents;

}
