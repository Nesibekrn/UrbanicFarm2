package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopMail extends CommonPage{

    //US37-Niyaz-
    @FindBy(css = "#login")
    public WebElement emailBoxYopmail;
    @FindBy(css = ".material-icons-outlined.f36")
    public WebElement arrowYopmail;
    @FindBy(xpath = "(//*[text()='Reset Your Password'])[2]")
    public WebElement resetYourPasswordYopmailLink;

}
