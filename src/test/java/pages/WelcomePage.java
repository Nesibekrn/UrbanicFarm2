package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends CommonPage{

    @FindBy(xpath = "//select[@id='sellerRate']")
    public WebElement AnySellerRating;

    @FindBy(xpath = "//select[@id='productRate']")
    public WebElement AnyProductRating;
}
