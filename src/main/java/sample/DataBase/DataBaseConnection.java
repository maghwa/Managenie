package sample.DataBase;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DataBaseConnection {

    //Declare JDBC Driver
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //Connection
    private static Connection conn = null;
    //Connection Info
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/students";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "marwa";

    //Connect to DB
    public static void dbConnect() {
        //Setting Mysql JDBC Driver
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Mysql JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Mysql JDBC Driver?");
            e.printStackTrace();
        }

        //Establish the Mysql Connection using Connection String
        try {
            conn = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
        }
    }
    //Close Connection
    public static void dbDisconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection Closed");
            }
        } catch (Exception e){
            System.out.println("Close Connection Failed! Check output console" + e);
            e.printStackTrace();
        }
    }
    //DB Execute Query Operation (This version is not safe from sql Injection)
    public static ResultSet dbExecuteQuery(String queryStmt) {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet crs = null;
        try {
            //Connect to DB (Establish Mysql Connection)
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");
            //Create statement
            stmt = conn.createStatement();
            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);
            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(resultSet);


        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);

        } finally {
            if (resultSet != null) {
                //Close resultSet
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                //Close Statement
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //Close connection
            dbDisconnect();
        }
        //Return resultSet
        return crs;
    }

    //DB Execute Update (For Update/Insert/Delete) Operation (This version is not safe from sql Injection)
    public static int dbExecuteUpdate(String sqlStmt) {
        int nbrRows = 0;
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Mysql Connection)
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            nbrRows = stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);

        } finally {
            if (stmt != null) {
                //Close statement
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //Close connection
            dbDisconnect();
        }
        return nbrRows;
    }

    //DB Execute Update (For Update/Insert/Delete) Operation (This version is safe from sql injection)
    public static int dbExecuteUpdatePrepared(String sqlStmt, Object[] data) {
        int nbrRows = 0;
        //Declare statement as null
        PreparedStatement stmt = null;
        try {
            //Connect to DB (Establish Mysql Connection)
            dbConnect();
            //Create Statement
            stmt = conn.prepareStatement(sqlStmt);
            //Fill data
            for(int i = 0; i < data.length; ++i) {
                Object val = data[i];
                stmt.setObject(i+1, val);
            }
            //Run executeUpdate operation with given sql statement
            nbrRows = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);

        } finally {
            if (stmt != null) {
                //Close statement
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //Close connection
            dbDisconnect();
        }
        return nbrRows;
    }
}
