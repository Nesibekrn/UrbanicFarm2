package stepDefinitions.uiStepDef.Events;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;

public class US074_StepDefs extends CommonPage {

    @Then("User see the alert messages {string},{string}")
    public void userSeeTheAlertMessages(String message, String number) {
      String alertMessage [] = message.split(",");
      int size = Integer.parseInt(number);
      int displayed = 0;
        for (String alert:alertMessage) {
            Assert.assertTrue(getEvent().alertAddAddressMessage.stream().anyMatch(t->t.getText().equals(alert)));
        }
        for (WebElement element:getEvent().alertAddAddressMessage
             ) {
            if (element.isDisplayed())
                displayed +=1;
        }

        Assert.assertEquals(size,displayed);




    }
}
