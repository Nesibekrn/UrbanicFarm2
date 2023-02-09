package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AccountPage extends CommonPage{

    @FindBy(xpath = "//a[contains(text(),'ayten')]")
    public WebElement accountName;

    @FindBy(xpath = "(//div/span[contains(text(),'Sell-Share')])[1]")
    public WebElement salePTmodule;
}
