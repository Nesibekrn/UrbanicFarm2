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

    @FindBy(css = ".Sidebar_section_btn__1sp6i.h6:nth-of-type(2)")
    public WebElement addressButton;

    @FindBy(css = ".btn.btn-outline-success:nth-of-type(1)")
    public WebElement addNewAddressButton;


    //aziz
    @FindBy(xpath = "(//span[contains(text(),'Paris')])[2]")
    public WebElement addressOption;

    //aziz
    @FindBy(xpath = "(//*[text()='Mark as a delivery address'])[2]")
    public WebElement addressInformation;


    @FindBy(xpath = "(//button[@class='btn btn-outline-success ml-3'])[1]")
    public WebElement submitButtonToAddAddress;

    @FindBy(css = ".Toastify__toast-body.toastr_custom-toastr__iiU37")
    public WebElement alertAfterClickedSubmitButtonOnAddressSection;

    @FindBy(css = ".btn.btn-outline-info:nth-of-type(3)")
    public WebElement mySalesAddressButton;

    @FindBy(xpath = "//button[@name='nonSelected']")
    public WebElement nonSelectedAddressButton;

    @FindBy(css = ".alert.alert-warning>span")
    public WebElement alertMessageAfterClickedMYSalesAddressButton;

    @FindBy(css = ".mr-2.btn.btn-outline-warning")
    public WebElement editButtonOnNonSelectedAddress;

    @FindBy(css = ".btn.btn-outline-danger:nth-of-type(2)")
    public WebElement removeButtonOnNonSelectedAddress;

    @FindBy(css = "#postal")
    public WebElement zipNumberBox;

    @FindBy(css = ".text-center.mb-4")
    public WebElement alertAfterClickedRemoveButtonOnAddressSection;

    @FindBy(css = ".btn.btn-primary.mr-4")
    public WebElement yesButtonAfterClickedRemoveButtonOnAddressSection;

    @FindBy(css = ".btn.btn-primary.ml-4")
    public WebElement noButtonAfterClickedRemoveButtonOnAddressSection;

    @FindBy(xpath = "//div[text()='Address deleted']")
    public WebElement addressDeletedAlertMessageOnAddressSection;
}
