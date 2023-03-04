package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupportUs extends CommonPage{


    @FindBy(css = ".Navbar_navbar-anchor__2WQhH.text-white")
    public WebElement supportTheLocalFoodMovement;

    @FindBy(xpath = "//div[contains(text(),'Investor Panel')]")
    public WebElement investorPanel;

    @FindBy(xpath = "//button[@class='wf-btn-blue-o wf-btn-sm']")
    public WebElement showMoreButton;

    @FindBy(xpath = "//input[@id='perks-display']")
    public WebElement investBox;

    @FindBy(xpath = "(//span[@class='object-scale-down m-auto text-sm md:text-md'])[1]")
    public WebElement investButton;

    @FindBy(xpath = "//span[normalize-space()='Reservation amount']")
    public WebElement reservationAmount;

}
