package stepDefinitions.dbStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.DatabaseUtilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtilities.resultSet;

public class US128_Stepdefs extends CommonPage {

    List<String> titleFromUI = new ArrayList<>();

    @And("User clicks My Completed Events tab")
    public void userClicksMyCompletedEventsTab() {
        System.out.println("1       " + getEvent().myEventsList2.size()); // .sout (sout icine almak icin)
        for (int i = 0; i < getEvent().myEventsList2.size(); i++) {
            titleFromUI.add(getEvent().myEventsList2.get(i).getText());
        }
        getEvent().myCompletedEventsTab.click();
        BrowserUtilities.wait(1);
        System.out.println("2   " + getEvent().myEventsList2.size()); // .sout (sout icine almak icin)
        for (int i = 0; i < getEvent().myEventsList2.size(); i++) {
            titleFromUI.add(getEvent().myEventsList2.get(i).getText());
        }
        System.out.println("titleFromUI = " + titleFromUI);//.soutv (açıklamalı sout ıcın)
    }

    @Then("User verifies if all events are in correct schema and columns in DB")
    public void userVerifiesIfAllEventsAreInCorrectSchemaAndColumnsInDB() throws SQLException {
        DatabaseUtilities.executeQuery("SELECT * FROM event WHERE owner_id = 1773 AND is_active = 1");
        List<String> titleListDB = new ArrayList<>();
        while (resultSet.next()) {
            titleListDB.add(resultSet.getString("title"));
        }
        System.out.println("titleListDB = " + titleListDB);
        Assert.assertEquals(titleFromUI.size(), titleListDB.size());
        for (int i = 0; i < titleFromUI.size(); i++) {
            Assert.assertTrue(titleListDB.contains(titleFromUI.get(i)));
        }
    }
    //2. way
//    @And("User clicks My Completed Events tab")
//    public void userClicksMyCompletedEventsTab() {
//        System.out.println("1       " + getEvent().myEventsList2.size()); // .sout (sout icine almak icin)
//        for (int i = 0; i < getEvent().myEventsList2.size(); i++) {
//            titleFromUI.add(getEvent().myEventsList2.get(i).getText());
//        }
//        getEvent().myCompletedEventsTab.click();
//        BrowserUtilities.wait(1);
//        System.out.println("2   " + getEvent().myEventsList2.size()); // .sout (sout icine almak icin)
//        for (int i = 0; i < getEvent().myEventsList2.size(); i++) {
//            titleFromUI.add(getEvent().myEventsList2.get(i).getText());
//        }
//        Collections.sort(titleFromUI);//******
//    }
//
//    @Then("User verifies if all events are in correct schema and columns in DB")
//    public void userVerifiesIfAllEventsAreInCorrectSchemaAndColumnsInDB() throws SQLException {
//        DatabaseUtilities.executeQuery("SELECT COUNT(title) FROM event WHERE owner_id=1773 AND is_active=1" );//******
//        resultSet.next();
//        int count=resultSet.getInt(1);
//        System.out.println(count);
//        Assert.assertEquals(titleFromUI.size(),count );
//
//        DatabaseUtilities.executeQuery("SELECT * FROM event WHERE owner_id = 1773 AND is_active = 1");
//        List<String> titleListDB = new ArrayList<>();
//
//        while (resultSet.next()) {
//            titleListDB.add(resultSet.getString("title"));
//        }
//
//        Collections.sort(titleListDB);
//        Assert.assertEquals(titleFromUI,titleListDB);
//    }
}


