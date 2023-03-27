package stepDefinitions.dbStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import utilities.DatabaseUtilities;


import java.sql.*;
import java.util.List;

import static utilities.DatabaseUtilities.resultSet;


public class US125_StepDefs {




    @Given("Connect Database")
    public void connectDatabase() {
        DatabaseUtilities.createConnection();
    }

    @And("see all column names by sending column names query")
    public void seeAllColumnNamesBySendingColumnNamesQuery() throws SQLException{

       DatabaseUtilities.executeQuery("select id, title,unique_name, hub_title ,descr  from product");
        ResultSetMetaData rsmd = resultSet.getMetaData();
//        while ( resultSet.next()) {


   //     System.out.println("ne geliyo acaba "+ rsmd);
        System.out.println("How many cloumns there ara = "+ rsmd.getColumnCount());
        System.out.print("2. indexte hangi column var = "+rsmd.getColumnName(2));
        System.out.println(""+ rsmd.getColumnDisplaySize(4));


    }

    @And("check product columns name by sending data table")
    public void checkProductColumnsNameBySendingDataTable(DataTable dataTable) throws SQLException {
        List<String> columnNames = dataTable.column(0);
        DatabaseUtilities.executeQuery("select " + columnNames.get(0) + "," + columnNames.get(1) + "," + columnNames.get(2) + " from product");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        resultSet.next();
        System.out.println(" ");
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i) );

        }
    }

    @And("find unique name from unique_name column by using data table")
    public void findUniqueNameFromUnique_nameColumnByUsingDataTable(DataTable dataTable) throws SQLException {
        List<String> productNames=dataTable.column(0);

        for (int i = 0; i <productNames.size() ; i++) {

        DatabaseUtilities.executeQuery("select * from product where unique_name = '"+productNames.get(i)+"'");
int count=0;
while(resultSet.next()) {
    count++;
    System.out.println(resultSet.getString(2));
}
Assert.assertEquals(1,count);
}

    }
}