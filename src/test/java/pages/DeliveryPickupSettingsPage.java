package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPickupSettingsPage extends  CommonPage{

        //Sevinc
        @FindBy(xpath = "//a[contains(text(),'Login')]" )
        public WebElement loginButton;

        @FindBy(xpath = "//input[@placeholder='Email']" )
        public WebElement email;

        @FindBy(xpath = "//input[@placeholder='Password']" )
        public WebElement passWord;

        @FindBy(xpath = "//button[contains(text(),'Login')]" )
        public WebElement loginButtonLoginPage;

        @FindBy(xpath = "//body/div[@id='__next']/div[4]/div[1]/nav[1]/a[4]" )
        public WebElement nilanka;

        @FindBy(xpath = "//a[contains(text(),'Delivery & Pick up settings')]" )
        public WebElement deliveryAndPickUpSettings;

        @FindBy(xpath = "//input[@id='BUYER_PICKUP_FROM_BRANCH']" )
        public WebElement buyerPicksUpOnTheVine;

        @FindBy(xpath = "//body/div[@id='__next']/div[4]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]")
        public WebElement yourAvailableHours;

        @FindBy(xpath = "//input[@id='startTime2']" )
        public WebElement startTime;

        @FindBy(xpath = "//input[@id='endTime2']" )
        public WebElement endTime;

        @FindBy(xpath = "//button[contains(text(),'Update')]" )
        public WebElement upDate;

        @FindBy(xpath = "//div[contains(text(),'Your delivery settings have been successfully upda')]" )
        public WebElement yourDeliverySettingsHaveBeenSuccessfullyUpdate;

        @FindBy(xpath = "//div[@id='availabilityBranch']" )
        public WebElement availableTime;

        //nida
        @FindBy (xpath= "//a[@class='Navbar_textLink__f6_Al cursor-pointer ml-4 mr-3 text-capitalize']" )
        public WebElement navbarName;

        @FindBy (xpath = "//span[@class='h4']")
        public WebElement welcomeAlertClose;

        @FindBy (xpath = "//input[@id='BUYER_PICKUP']\n")
        public WebElement buyerPickUp;

        @FindBy (xpath = "//input[@id='startTime']")
        public WebElement pickUp_StartTime;

        @FindBy (xpath = "//input[@id='endTime']")
        public WebElement pickUp_EndTime;

        @FindBy (xpath = "//div[@class='Toastify__toast-body toastr_custom-toastr__iiU37']\n")
        public WebElement alertText;

        @FindBy (xpath = "//button[@class='btn btn-outline-success ml-3 mt-3']")
        public WebElement pickUp_UpDate;

        @FindBy (xpath = "//input[@id='SELLER_DELIVERY']")
        public WebElement sellerDelivery;

        @FindBy (xpath = "//input[@id='SELLER_FLEXIBLE']")
        public WebElement sellerFlexible;
//Ezra
        @FindBy(css = ".Navbar_textLink__f6_Al.cursor-pointer.ml-4.mr-3.text-capitalize")
        public WebElement user;

        @FindBy(css = "[href='/account/delivery']")
        public WebElement delivery;

        @FindBy(id = "SELLER_FLEXIBLE")
        public WebElement seller_flexible;

        @FindBy(css = "#freeFlexibleDeliveryRange")
        public WebElement freeFlexibleDeliveryRange;

        @FindBy(css = "#minFreeFlexibleDeliveryOrder")
        public WebElement minFreeFlexibleDeliveryOrder;

        @FindBy(css = "[type='submit']")
        public WebElement update;

        @FindBy(css = "#_deliveryBeginDay")
        public WebElement deliveryBeginDay;
        @FindBy(css = "#_deliveryBeginTime")
        public WebElement deliveryBeginTime;
        @FindBy(css = "#_deliveryEndDay")
        public WebElement deliveryEndDay;
        @FindBy(css = "#_deliveryEndTime")
        public WebElement deliveryEndTime;
        @FindBy(css = "#_orderByDay")
        public WebElement orderByDay;
        @FindBy(css = "#_orderByTime")
        public WebElement orderByTime;




}

