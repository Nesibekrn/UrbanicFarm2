package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.FileStore;
import java.util.List;

public class HomePage extends CommonPage {


    //niyaz US02
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    public WebElement logoutButton;
    //ramazan US017
    @FindBy(xpath = "//a[contains(text(),'Discover Local Sellers Near You')]")
    public WebElement discoverLink;

    //niyaz US02
    @FindBy(xpath = "//*[@id='Urban\\u0131cFarm']")
    public WebElement urbanicFarmLogo;

    //niyaz US02
    @FindBy(xpath = "//*[text()='Support the local food movement']")
    public WebElement supportTheLocalFoodMovementLink;

    //niyaz US02
    @FindBy(xpath = "//*[@class='Navbar_linkContainer__2jWIM']//a")
    public List<WebElement> headersList;

    @FindBy(xpath = "(//*[text()='Blog'])")
    public WebElement blogLink;

    //Sevinc US16
    @FindBy(xpath = "//a[contains(text(),'blog')]" )
    public WebElement blogOption;

    //Sevinc US31
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerButton;

    //US37-Niyaz
    @FindBy(xpath = "(//*[text()='Welcome to Urbanic Farm!'])[1]")
    public WebElement welcomeTheUrbanicFarmWindowText;
    @FindBy(xpath = "//button[@class='close btn']")
    public WebElement welcomeTheUrbanicFarmWindowCloseButton;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerLink;

    //Said S. US0027
    @FindBy(css = ".Footer_social-links__FYd8U a" )
    public WebElement facebookButton;

    //Said S. US0028
    @FindBy(xpath = "//div[@class='Footer_social-links__FYd8U']//following::a" )
    public WebElement linkedInButton;

    //Said S. US006
    @FindBy(css = "a:nth-child(4)")
    public WebElement contactUsLink;

    // Vural US013
    @FindBy(xpath = "//*[text()='Contribution to the Environment and Society']")
    public WebElement contributionToTheEnvironmentAndSocietyHeading;

    // Vural US013
    @FindBy(xpath = "//*[text()='Register Now']")
    public WebElement registerNowLink;

    //Furkan US010
    @FindBy(xpath = "//button[text()='Sell your produce']")
    public  WebElement sellyourproduce;

    //ayten US020
    @FindBy(xpath = "(//a[@href='/about'])[3]")
    public WebElement aboutUs;
    //ayten US022
    @FindBy(xpath = "//a[@href='/privacy-policy']")
    public WebElement privacyPolicy;
    //ayten US023
    @FindBy(xpath = "//a[@href='/terms-of-service']")
    public WebElement termOfservice;

    //nida
    @FindBy(xpath = "//div/a[text()='Explore']")
    public WebElement exploreLink;
    //omer hoca

    @FindBy(css = "nav>a[href^='/account/home']")
    public WebElement accountName_navbar;



    //gulsum US018
    @FindBy(xpath = "(//*[text()='get the app'])[2]")
    public WebElement getTheApp;

    //gulsum US019
    @FindBy(xpath = "(//a[text()='Sell-Share-Trade'])")
    public WebElement sellShareTrade;

    //gulsum US024
    @FindBy(xpath = "(//a[@class='d-block'])")
    public WebElement address;

    //gulsum US024
    @FindBy(xpath = "(//address[contains(text(),'Dr San Jose, Californ')])")
    public WebElement addressContent;

   // ugur

    @FindBy(xpath ="//*[text()='Reduce waste, strengthen your community']" )
    public WebElement ReduceWasteStrengthenYourCommunityHeading;

    @FindBy(xpath ="//*[text()='Whats Near You']" )
    public WebElement WhatsNearYouLink;

    @FindBy(xpath ="//*[text()='Post Your Goods']" )
    public WebElement PostYourGoodsLink;


    //nida
    @FindBy (xpath = "//div/a[@href= '/about']")
    public WebElement aboutUsLink;

//Aytem Hanim
    @FindBy(xpath = "(//a[@href='/auth/login'])[1]")
    public WebElement loginmodule;
    // ramazan US36
    @FindBy(xpath = "//div[contains(text(),'Invalid creds')]")
    public WebElement invalidAlert;

    //aziz
    @FindBy(name = "email")
    public WebElement emailBox;
    //aziz
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;
    //aziz
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement ssubmitButton;
    //aziz
    @FindBy(xpath = "//div[@class='Navbar_addHub__USGHm']")
    public WebElement sellShareTradeButton;

    //Rumeysa
    @FindBy(xpath = "//a[text()='Phone:']")
    public WebElement phoneHomePage;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutButton2;

    //Furkan
    @FindBy(xpath = "//button[text()='Register now!']" )
    public WebElement registernow;

    @FindBy(xpath = "//button[text()='GO WEFUNDER']" )
    public WebElement goWefunderButton;

    //Said US060
    @FindBy(xpath = "(//span[contains(text(),'Sell-Share-Trade')])[1]")
    public WebElement sellShareTradeLink;

@FindBy(xpath = "//input[@class='ProductCard_number__1yGnR']")
    public WebElement productAdcartNumberSeenIcon;

@FindBy(xpath = "//div[@class='ProductCard_stockInfo__1vJgJ']")
    public WebElement listOfPoundAvailable;
}


