package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}


