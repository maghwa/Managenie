package sample.Controllers;

import sample.DataBase.DataBaseConnection;

import java.sql.Connection;
import java.sql.*;

public class QuotedayController {

    public static String getRandomStringFromDB() {
        DataBaseConnection connection = new DataBaseConnection();
        Connection connectDB = connection.getConnection();
        String quote = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {

            // Get a random string from the database

            statement = connectDB.createStatement();
            resultSet = statement.executeQuery("SELECT quote FROM quotes ORDER BY RAND() LIMIT 1");

            if (resultSet.next()) {
                quote = resultSet.getString("quote");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connectDB.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return quote;
    }
}
