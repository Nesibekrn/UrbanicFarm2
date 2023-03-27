package stepDefinitions.dbStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.DatabaseUtilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static utilities.DatabaseUtilities.resultSet;

public class US129_StepDefs extends CommonPage {
    String message = Faker.instance().hipster().word();

    List<String> contents = new ArrayList<>();
    @And("User sends a message from UI")
    public void userSendsAMessageFromUI() {
        getHomePage().sendMessageIcon.click();
        Random random= new Random();
        int index = random.nextInt(getHomePage().sendMessageParticipant.size());
        getHomePage().sendMessageParticipant.get(index).click();
        getHomePage().enterToSendMessage.click();
        getHomePage().enterToSendMessage.sendKeys(message+ Keys.ENTER);

    }

    @When("User gets message data from Data Base")
    public void userGetsMessageDataFromDataBase() throws SQLException {
        DatabaseUtilities.executeQuery("SELECT content FROM message WHERE owner_id = 1773");

        while (resultSet.next()){
            contents.add(resultSet.getString("content"));
        }
        System.out.println(contents);
    }

    @Then("User verifies sended message is exists in Data Base")
    public void userVerifiesSendedMessageIsExistsInDataBase() {

        Assert.assertTrue(contents.contains(message));
    }
}
