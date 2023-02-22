package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;


public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;
    private AddressPage addressPage;
    private RegisterPage registerPage;
    private SellShareTradePage sellShareTradePage;
    private YopMail yopMail;
    private DeliveryPickupSettingsPage deliveryPickupSettingsPage;
    private OrdersPage ordersPage;
    private WelcomePage welcomePage;
    private YourProductsServicesPage yourProductsServicesPage;
    private  CartPage cartPage;




    public YourProductsServicesPage getYourProductsServicesPage() {
        if(yourProductsServicesPage==null){
            yourProductsServicesPage=new YourProductsServicesPage();
        }
        return yourProductsServicesPage;
    }

    public WelcomePage getWelcomePage() {
        if(welcomePage==null){
            welcomePage=new WelcomePage();
        }
        return welcomePage;
    }
    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public OrdersPage getOrdersPage() {
        if(ordersPage==null){
            ordersPage=new OrdersPage();
        }
        return ordersPage;
    }

    public DeliveryPickupSettingsPage getDeliveryPickupSettingsPage() {
        if (deliveryPickupSettingsPage==null) {
            deliveryPickupSettingsPage = new DeliveryPickupSettingsPage();
        }
        return deliveryPickupSettingsPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public AddressPage getAddressPage() {
        if (addressPage == null) {
            addressPage = new AddressPage();
        }
        return addressPage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public SellShareTradePage getSellShareTradePage() {
        if (sellShareTradePage == null) {
            sellShareTradePage = new SellShareTradePage();
        }
        return sellShareTradePage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage();
        }
        return accountPage;
    }

    public YopMail getYopMail() {
        if (yopMail == null) {
            yopMail = new YopMail();
        }
        return yopMail;
    }



}




