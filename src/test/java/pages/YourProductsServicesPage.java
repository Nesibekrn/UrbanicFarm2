package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static stepDefinitions.Hooks.driver;

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
    //omer
    @FindBy(xpath = "//div[@class='row m-0 p-2 align-items-center']/span")
    public List<WebElement> allhubs;

    @FindBy(xpath = "//a[contains(@class,'HubManagement_productTitle__2ke7R')]")
    public List<WebElement> allAddedProducts;


    @FindBy(xpath = "//datalist[@id='productName']/option")
    public List<WebElement> allProductsNames;

    @FindBy(xpath = "//span[contains(@class,'HubManagement_badge__2jPOb')]")
    public List<WebElement> allProductsStatus;

    @FindBy(xpath = "//input[@id='selectProductName']")
    public WebElement addNewProduct_Name;


    @FindBy(xpath = "//input[@id='hubManagePrice']")
    public WebElement addNewProduct_Price;


    @FindBy(xpath = "//input[@id='hubManageStock']")
    public WebElement addNewProduct_Stock;

    @FindBy(xpath = "//select[@id='selectProductUnit']")
    public WebElement addNewProduct_Unit;


    @FindBy(xpath = "//button[@id='hubManageSaveButton']")
    public WebElement addNewProduct_Submit;


    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement update;


    @FindBy(xpath = "//a[@class='btn btn-danger']")
    public WebElement delete;

    @FindBy(xpath = "(//div[@class='text-center mb-2']/a)[1]")
    public WebElement yes;


    @FindBy(xpath = "(//div[@class='text-center mb-2']/a)[2]")
    public WebElement no;


    public void clickAddedProduct(String productName) {
        (driver.findElement(By.xpath("//a[text()='" + productName + "']"))).click();
    }

}
