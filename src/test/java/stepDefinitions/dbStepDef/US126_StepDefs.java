package stepDefinitions.dbStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.DatabaseUtilities;

import java.sql.SQLException;

import static utilities.DatabaseUtilities.executeQuery;
import static utilities.DatabaseUtilities.resultSet;

public class US126_StepDefs {
    @Given("user connect to the database")
    public void userConnectToTheDatabase() {
        DatabaseUtilities.createConnection();
    }

    @And("user send the query to the promo code table")
    public void userSendTheQueryToThePromoCodeTable() throws SQLException {
        DatabaseUtilities.executeQuery("select * from promo_code where discount_type = 'percentage'");
//       resultSet=executeQuery("select * from promo_code");
        while (resultSet.next()) {

            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString("code"));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString("discount_type"));
        }
    }

    @And("user send query for code colum om the promo code table")
    public void userSendQueryForCodeColumOmThePromoCodeTable() throws SQLException {
        DatabaseUtilities.executeQuery("select * from promo_code where code = 'Jackie Funk' and id = '10'");
        resultSet.next();
        System.out.println(resultSet.getString("code"));
        System.out.println(resultSet.getString("id"));
    }
}
