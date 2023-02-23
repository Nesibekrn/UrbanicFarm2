package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePage extends CommonPage{

    //aziz US065
    @FindBy(xpath = "//span[.='Local seller near you']")
    public WebElement localSellerNearYouText;

    @FindBy(css = ".ProductCard_userName__MaY5h")
    public List<WebElement> allSellersList;

    @FindBy(css = ".m-0.mb-1.text-start.text-white.ProductCard_productTitle__3K4rg")
    public List<WebElement> allProductList;

    @FindBy(id = "page2")
    public WebElement page2;

    @FindBy(xpath = "//button[@class='ProductCard_minus__37stn']")
    public WebElement iconOfMinus;

    @FindBy(xpath = "//button[@class='ProductCard_plus__1B39j']")
    public WebElement iconOfPlus;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement addCartButton;

    @FindBy(xpath = "//button[@class='col-12 mt-2 w-75 btn btn-success ProductCard_addCartBtn___oxgf']")
    public List< WebElement> listOfAddCartProduct;

    @FindBy(css = ".Toastify__toast-body.toastr_custom-toastr__iiU37")
    public WebElement addAlertMessage;
    @FindBy(xpath = "//span[@class='Navbar_cartText__1jkrK'] ")
    public WebElement numberOfCart;
}
