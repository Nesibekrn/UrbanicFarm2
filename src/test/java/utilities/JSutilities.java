package utilities;

import org.openqa.selenium.JavascriptExecutor;

public class JSutilities {
    public static void scrollToBottom() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");

}
}
