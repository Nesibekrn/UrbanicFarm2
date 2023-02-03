package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {


    //niyaz US02
    @FindBy(css = "//a[text()='Login']")
    public WebElement loginButton;

    //niyaz US02
    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    public WebElement logoutButton;

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

}
