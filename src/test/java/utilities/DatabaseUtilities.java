package utilities;


import java.sql.*;

public class DatabaseUtilities {
    private static Connection connection;
    private static Statement statement;
    public static ResultSet resultSet;

    /**
     * method database connection i olusturmak icin kullanildi
     *
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(
                    ConfigurationReader.getProperty("url"),
                    ConfigurationReader.getProperty("username"),
                    ConfigurationReader.getProperty("password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method connectionlarin kapatilmasi icin kullanildi
     * kapatilacak connection statement resultSet
     *
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static void closeConnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * method kullanacagimiz sql querry i calistirmak icin kullanildi
     *
     * @param sql
     * @author omeryttnc
     * @since 11.02.2023
     * @return
     */

    public static ResultSet executeQuery(String sql) {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void updateQuery(String sql) {
        try {
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method son eklenen urunu approve etmek icin kullanildi
     *
     * @author omeryttnc
     * @since 11.02.2023
     */
    public static void approveLastProduct() {
        updateQuery("UPDATE `hub_product` SET `product_listing_state` = 'APPROVED' WHERE `product_listing_state` LIKE 'IN_REVIEW' order BY id DESC;");

    }
    public static void deleteUsedPromoCode(){
        updateQuery("DELETE FROM promo_code_user");
    }
}
