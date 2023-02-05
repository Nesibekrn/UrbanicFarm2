package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSutilities {
    public static void scrollToBottom() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");

}
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

}
