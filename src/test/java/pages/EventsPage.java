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

    //Sevinc
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    public WebElement AddButton;

    @FindBy(id = "addressTitle")
    public WebElement AddressTitle;

    @FindBy(id = "address")
    public WebElement Address3;

    @FindBy(id = "states")
    public WebElement States;

    @FindBy(id = "cities")
    public WebElement City;

    @FindBy(id = "postal")
    public WebElement PostalCode;

    @FindBy(xpath = "//a[contains(text(),'Address')]")
    public WebElement accountAddress;

    @FindBy(xpath = "//button[@class='btn btn-outline-success ml-3']")
    public WebElement submitButtonS;

    @FindBy(xpath = "(//*[@class='card-title'])[9]")
    public WebElement confAddress;

    @FindBy(xpath = "//*[@class='card-title']")
    public List<WebElement> confAddressList;

    //Said US078
    @FindBy(xpath = "//a[@class='Sidebar_section_btn__1sp6i h6 Sidebar_active__1HCV5']")
    public WebElement myEvenetsButton;

    //Said US078
    @FindBy(xpath = "//button[@class='events-i-organize_btnCreate__2AWbt']")
    public WebElement createNewEventButton;

    //Said US078
    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleBox;

    //Said US078
    @FindBy(xpath = "//select[@id='address2']")
    public WebElement addressBox;

    //Said US078
    @FindBy(xpath = "//input[@id='date']")
    public WebElement dateBox;

    //Said US078
    @FindBy(xpath = "//input[@id='time']")
    public WebElement timeBox;

    //Said US078
    @FindBy(xpath = "//input[@id='fee']")
    public WebElement feeeBox;

    //Said US078
    @FindBy(xpath = "//input[@id='duration']")
    public WebElement durationBox;

    //Said US078
    @FindBy(xpath = "//input[@id='attendeeLimit']")
    public WebElement attendeeLimitBox;

    //Said US078
    @FindBy(xpath = "//textarea[@id='tac']")
    public WebElement termsAndConditionsBox;

    //Said US078
    @FindBy(xpath = "//*[@fill-rule='evenodd']")
    public WebElement closeOfToastMessageAboutCreationOfEvent;

    //Said US078
    @FindBy(xpath = "//button[@class='btn btn-outline-warning p-1 col-lg-3 col-12 ScheduledEvents_btn__1gJtD']")
    public WebElement cancelButton;

    //Said US078
    @FindBy(xpath = "(//button[@class='btn btn-primary mr-4'])[1]")
    public WebElement yesButtonForCancellation;

    //Said US078
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement toastMessageOfEventCancelled;

    //Said US078
    @FindBy(xpath = "//button[@class='btn btn-outline-primary p-1 col-lg-5 col-12 ScheduledEvents_btn__1gJtD']")
    public WebElement markAsCompletedButton;

    //Said US078
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement toastMessageOfEventMarkedAsCompleted;

    //Said US078
    @FindBy(xpath = "//button[@class='btn btn-outline-danger p-1 col-lg-3 col-12 ScheduledEvents_btn__1gJtD']")
    public WebElement delete2Button;

    //Said US078
    @FindBy(xpath = "(//button[@class='btn btn-primary mr-4'])[1]")
    public WebElement yesButtonForDeleting;

    //Said US078
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement toastMessageOfEventDeleted;

}
