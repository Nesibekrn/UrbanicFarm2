package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends CommonPage{


    //aziz
    @FindBy(xpath ="//*[text()='Address']")
    public WebElement addresButton;
    //aziz
    @FindBy(xpath = "//*[text()='Add New Address']")
    public WebElement newAddresButton;
    //aziz
    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;
    //aziz
    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton1;
    //aziz
    @FindBy(xpath = "(//span[contains(text(),'Paris')])[2]")
    public WebElement addresOption;
    //aziz
    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement addresInformatin;
    //aziz
    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton2;
    // aziz
    @FindBy(xpath = "//*[text()='ADDRESSES']")
    public WebElement previousPageAddressesButton;

}
