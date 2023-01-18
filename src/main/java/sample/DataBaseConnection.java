package sample;
import java.sql.*;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection (){

        String databaseName = "Managenie";
        String databaseUser = "root";
        String databasePassword = "00000000";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
