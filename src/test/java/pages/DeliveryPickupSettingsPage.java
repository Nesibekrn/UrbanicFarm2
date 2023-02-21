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


    }

