package sample.DataBase;


import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection (){

        String databaseName = "Managenie_db";
        String databaseUser = "root";
        String databasePassword = "000000";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("I'm connected");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}