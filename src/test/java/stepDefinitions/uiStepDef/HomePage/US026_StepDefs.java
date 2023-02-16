package stepDefinitions.uiStepDef.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.JSutilities;

import static stepDefinitions.Hooks.actions;

public class US026_StepDefs extends CommonPage {
    @When("user clicks to Blog button")
    public void userClicksToBlogButton() {
        JSutilities.scrollToBottom();
        BrowserUtilities.wait(2);
        JSutilities.clickWithJS(getHomePage().blogOption);
    }


}
