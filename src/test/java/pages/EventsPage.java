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

    @FindBy(xpath="//div[@role='alert']")
    public WebElement alert;

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

    //Said US078
    @FindBy(xpath = "//span[@class='ScheduledEvents_canceled__3gHpw']")
    public WebElement canceledSignMessage;

    //Said US078
    @FindBy(xpath = "//*[@aria-label='close']")
    public WebElement alertCloseButton;

    //Said US078
    @FindBy(xpath = "//*[text()='My Completed Events']")
    public WebElement myCompletedEventsTab;

    //Said US078
    @FindBy(xpath = "(//*[text()='COMPLETED'])[1]")
    public WebElement completedSignMessage;


    //Said US078
    @FindBy(xpath = "(//*[text()='Copy Link'])[1]")
    public WebElement copyLinkButton;

    //Said US078
    @FindBy(xpath = "//*[text()='Event Link Copied to Clipboard']")
    public WebElement toastMessageOfEventLinkCopied;


    //aziz US071
    @FindBy(xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement eventCreateddAlertMassage;

    //aziz US071
    @FindBy(xpath = "(//*[text()='NEW'])[1]")
    public WebElement newSinggMassage;

  //aziz US071
    @FindBy(xpath = "//button[@class='btn btn-outline-success px-4']")
    public WebElement submitButton2;

// public class EventsPage extends CommonPage{

    @FindBy(xpath="//input[@id='addressTitle']")
    public WebElement addressTitle;

    @FindBy(xpath = "//button[@class='btn btn-outline-success mb-1']")
    public WebElement addButton;

    @FindBy(xpath = "(//button[@class='btn btn-primary ml-4'])[1]")
    public WebElement noButton;

    @FindBy(xpath="//div[@role='alert']")
    public WebElement alertDelete;

    @FindBy(xpath = "//p[@class='text-center font-weight-bold']")
    public WebElement createEvent;

   @FindBy(xpath="//input[@id='address']")
    public WebElement addressBox2;

    @FindBy(xpath = "//input[@id='states']")
    public WebElement statesBox;

    @FindBy(xpath = "//input[@id='cities']")
    public WebElement citiesBox;

    @FindBy(xpath="//input[@id='postal']")
    public WebElement postalBox;

    @FindBy(xpath = "(//h5[@class='text-center mb-4'])[1]")
    public WebElement h5;
////button[@class='events-i-organize_accordionTab__166n1 events-i-organize_accordionActive__3YSTx']
@FindBy(xpath = "//div[text()='You have not any scheduled events yet.']")
    public WebElement notScheduledEvents;

@FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton3;

//NİDA

    @FindBy (xpath =" a[text()='Events']")
    public WebElement events;
    //////a[@class='Sidebar_section_btn__1sp6i h6 Sidebar_active__1HCV5']
// a[text()='Events']
    @FindBy (xpath = "//button[@class='events_accordionTab__2Oisf events_accordionActive__gh3Yk'][text()='Scheduled Events']")
    public WebElement scheduledEvents;

    @FindBy (xpath = "//button[@class='btn btn-outline-success p-1 col-lg-3 col-12 ScheduledEvents_btn__1gJtD']")
    public List<WebElement> registerButton;

    @FindBy (xpath = "//input[@class='eventRegister_custom-checkbox__3eYP8']")
    public WebElement termsAndConditionsCheckBox;

    @FindBy (xpath = "//button[@class='eventRegister_approveBtn__1P-N2']")
    public WebElement approveButton;

    @FindBy (xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']")
    public WebElement registeredMessage;

    @FindBy (xpath = "//h6[text() = 'Attendee Limit:']//span[@class='text-muted']")
    public List<WebElement> attendeeLimitNumber;

    @FindBy (xpath = "//h6[text() = 'Available Seat:']//span[@class='text-muted']")
    public List<WebElement> availableSeatNumber;

    @FindBy (xpath = "//button[text()= 'Registered Events']")
    public WebElement registeredEventsButton;

    @FindBy (xpath = "//span[@class= 'ml-2']")
    public WebElement registeredEventName;

    @FindBy (xpath = "//h5[@class='row justify-content-center text-warning']")
    public List<WebElement> registeredEvents;


    @FindBy (xpath = "span[style=\"margin-left: 3.2rem;\"]")
    // //p[text()='Fee: ']/following::span
    public WebElement fee;

    @FindBy (xpath = "//a[text()='Events']")
    public WebElement eventsButton;

    @FindBy (xpath = "//input[@type='number']" )
    public WebElement numberOfAttendeesBox;

    @FindBy (xpath = "//input[@class='eventRegister_custom-checkbox__3eYP8']")
    public WebElement iAcceptTheTermsAndConditionsCheckBox;

    // Vural
    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateButton;
    @FindBy(css = ".eventRegister_miniBox__2Ukis.ml-4")
    public WebElement borderColor;

    //Rumeysa US074
    @FindBy (xpath = "//div[@class='CreateEvents_inlineErrormsg__2AiUS']")
    public List<WebElement> alertAddAddressMessage;

}
