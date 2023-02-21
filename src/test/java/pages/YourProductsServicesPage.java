package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourProductsServicesPage extends CommonPage{

    //Said US060
    @FindBy(xpath = "//a[normalize-space()='Your products/services']")
    public WebElement yourProductsServices;

    //Said US060
    @FindBy(xpath = "//span[@class='col-6 col-sm-4 text-center mb-3 cursor-pointer text-secondary']")
    public WebElement vegetablesAndFruitsButton;

    //Said US060
    @FindBy(xpath = "//a[@class='GoBack_goback__6sa4O']")
    public WebElement goBackButton;
}
