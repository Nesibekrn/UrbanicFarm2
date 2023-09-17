package stepDefinitions;


import com.github.javafaker.Faker;
import enums.USERINFO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utilities.BrowserUtilities;
import utilities.DatabaseUtilities;
import utilities.Driver;


public class Hooks {
    public static WebDriver driver;



    public static Actions actions;
    public static boolean isCookiesDeleted = true;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;
    public static Faker faker;
    public static Select select;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();

    }
    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        BrowserUtilities.localClear();


    }


    @Before("@DB")
    public void setupDatabase() {
        DatabaseUtilities.createConnection();
    }

    @After("@DB")
    public void closeDatabase() {
        DatabaseUtilities.closeConnection();
    }



}
