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

    //nesibe
    @FindBy(xpath = "//*[@id='mapSearchBox']")
    public WebElement searchBox;//what are u looking for?

    @FindBy(xpath = "//*[@id='searchMapButton']")
    public WebElement searchButton;

    @FindBy(xpath = "//select[@id='location']")
    public WebElement searchInMilesBox;

    @FindBy(xpath = "//input[@name='isOrganic']")
    public WebElement organicButton;

    @FindBy(xpath = "//span[.='Organic']")
    public WebElement organicTag;

    @FindBy(xpath = "//*[text()='Available for Trade']")
    public WebElement availableForTradeButton;

    @FindBy(xpath = "//select[@id='allCategories']")
    public WebElement allCategories;

    //Said & Aziz US063
    @FindBy(xpath = "//button[@class='btn p-0 SearchBarOptions_sliderButton__1oak8']")
    public WebElement searchSliderButton;

    //Said & Aziz US063
    @FindBy(xpath = "//label[@for='priceFilter']")
    public WebElement priceFilter;

    //Said & Aziz US063
    @FindBy(xpath = "//*[text()='Price']")
    public WebElement priceFilter2ndOption;

    //Said & Aziz US063
    @FindBy(xpath = "//span[@id='priceFilterPreview']/..")
    public WebElement priceFilter3rdOption;

    //Said & Aziz US063
    @FindBy(xpath = "(//span[@class='text-muted font-weight-bold'])[1]")
    public WebElement deliveryType;

    //Said & Aziz US063
    @FindBy(xpath = "(//span[@class='text-muted font-weight-bold'])[2]")
    public WebElement unitType;

    //Said & Aziz US063
    @FindBy(xpath = "//input[@id='priceFilter']")
    public WebElement sliderOfPrice;

    //Said & Aziz US063
    @FindBy(xpath = "(//input[@name='deliveryFilter'])[1]")
    public WebElement firstOptionOfDeliveryType;

    //Said & Aziz US063
    @FindBy(xpath = "(//input[@name='unitTypeFilter'])[1]")
    public WebElement firstOptionOfUnitType;

    //Said & Aziz US063
    @FindBy(xpath = "//button[@class='ProductCard_productBtn__3OdlW']")
    public WebElement verifyForAlicanteTomato;

    //Said & Aziz US063
    @FindBy(xpath = "//span[@class='SearchBarOptions_slider__1xZ3L SearchBarOptions_round__3BMhA']")
    public WebElement toggleButtonOfOrganic;

    //Said & Aziz US063
    @FindBy(xpath = "//body/div[@id='__next']/div/div/div[@class='row m-0 Map_container__1LjV9']/div[@class='col-xl-8 col-lg-8 col-md-8 col-sm-8 Map_search_area__3F17y']/div[@id='mainId']/div[@class='SearchBarOptions_filterContainers__15rsk']/div[@id='searchFilters']/div[@class='SearchBarOptions_rangeOptionsContainer__1iicd']/div[1]")
    public WebElement priceBlock;
    @FindBy(xpath = "//select[@id='sellerRate']")
    public WebElement AnySellerRating;

    @FindBy(xpath = "//select[@id='productRate']")
    public WebElement AnyProductRating;
    //nesibe US067
    @FindBy(xpath = "//*[@class='Notifications_notificationIconContainer__2jS5E']")
    public WebElement notificationIcon;
}
