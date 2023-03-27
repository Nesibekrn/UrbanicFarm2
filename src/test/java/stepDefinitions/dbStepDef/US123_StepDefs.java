package stepDefinitions.dbStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import stepDefinitions.uiStepDef.Register.US034_StepDefs;
import utilities.DatabaseUtilities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import static utilities.DatabaseUtilities.resultSet;

public class US123_StepDefs {
    @Then("user verifies following column names are present in user")
    public void userVerifiesFollowingColumnNamesArePresentInUser(DataTable dataTable) throws SQLException {
        List<String> columnNames = dataTable.column(0);
        /*
        DatabaseUtilities.executeQuery("SELECT * from user");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        for(String columnName: columnNames){//email
            boolean flag = false;
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i));
                if(rsmd.getColumnName(i).equals(columnName)){
                    flag= true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }*/
        DatabaseUtilities.executeQuery("SELECT " + columnNames.get(0) + "," + columnNames.get(1) + "," + columnNames.get(2) + " from user");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        //SELECT id, email, first_name FROM user
        for (int i = 1; i < rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i) + " " + columnNames.get(i - 1));
            int j = 0;
            if (rsmd.getColumnName(i).equals(columnNames.get(i - 1))) {
                j = 1;
            }
            Assert.assertEquals(1, j);
        }

    }

    @And("user verifies the added user exists")
    public void userVerifiesTheAddedUserExists() throws SQLException {
        DatabaseUtilities.executeQuery("SELECT * FROM user WHERE first_name='" + US034_StepDefs.firstname + "' AND email='" + US034_StepDefs.email + "'");
        if (resultSet.next()) {
            System.out.println("Kullanici bulundu");
        } else {
            System.out.println("Kullanici kaydedilmedi");
        }

        DatabaseUtilities.executeQuery("SELECT * FROM user ORDER BY id DESC");
        while (resultSet.next()){
            String email = resultSet.getString("email");
            String firstName= resultSet.getString("first_name");
            if(email.equals(US034_StepDefs.email)&& firstName.equals(US034_StepDefs.firstname)){
                System.out.println("Kullanici eklenmis");
                break;
            }
        }
    }

    @Then("user verifies following column names are present in {string} table")
    public void userVerifiesFollowingColumnNamesArePresentInTable(String tableName, DataTable dataTable) throws SQLException {
        List<String> columnNames = dataTable.column(0);
        /*
        DatabaseUtilities.executeQuery("SELECT * from user");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        for(String columnName: columnNames){//email
            boolean flag = false;
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i));
                if(rsmd.getColumnName(i).equals(columnName)){
                    flag= true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }*/
        DatabaseUtilities.executeQuery("SELECT " + columnNames.get(0) + "," + columnNames.get(1) + "," + columnNames.get(2) + " from "+ tableName);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        //SELECT id, email, first_name FROM user
        for (int i = 1; i < rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i) + " " + columnNames.get(i - 1));
            int j = 0;
            if (rsmd.getColumnName(i).equals(columnNames.get(i - 1))) {
                j = 1;
            }
            Assert.assertEquals(1, j);
        }
    }
}
