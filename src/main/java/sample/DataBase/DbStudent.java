//
//package sample.DataBase;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import sample.Models.Student;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//public class DbStudent {
//    //*******************************
//    //SELECT Students
//    //*******************************
//    public static ObservableList<Student> loadStudents () {
//        //Declare a SELECT statement
//        String selectStmt = "SELECT * FROM info";
//        //Execute SELECT statement
//
//        //Get ResultSet from dbExecuteQuery method
//        ResultSet rsstds = DataBaseConnection.dbExecuteQuery(selectStmt);
//        //Send ResultSet to the getStudentList method and get Student object
//        ObservableList<Student> stdList = getStudentList(rsstds);
//        //Return Student object
//        return stdList;
//
//    }
//    //Select * from info operation
//    private static ObservableList<Student> getStudentList(ResultSet rs) {
//        //Declare a observable List which comprises of Student objects
//        ObservableList<Student> stdList = FXCollections.observableArrayList();
//        try {
//            while (rs.next()) {
//                Student std = new Student( rs.getString("first name"), rs.getNString("last name"), rs.getNString("email"),rs.getString("matricule") );
//                //Add Student to the ObservableList
//                stdList.add(std);
//            }
//        } catch (SQLException e) {
//            System.out.println("Unable to read data : " + e);
//        }
//        //return stdList (ObservableList of Students)
//        return stdList;
//    }
//    //*************************************
//    //UPDATE a Student's name
//    //*************************************
//    public static void updateName (int stdId, String stdName) {
//        //Declare a UPDATE statement
//        String updateStmt =
//                "   UPDATE info\n" +
//                        "      SET name = '" + stdName + "'\n" +
//                        "    WHERE id = " + stdId + ";";
//        //Execute UPDATE operation
//        DataBaseConnection.dbExecuteUpdate(updateStmt);
//
//    }
//    //*************************************
//    //DELETE a Student
//    //*************************************
//    public static void deleteStdWithId (int stdId) {
//        //Declare a DELETE statement
//        String updateStmt =
//                "   DELETE FROM info\n" +
//                        "         WHERE id ="+ stdId +";";
//        //Execute UPDATE operation
//
//        DataBaseConnection.dbExecuteUpdate(updateStmt);
//
//    }
//    // Using prepared statement method
//    public static int deleteStd(int stdId) {
//        //Declare a DELETE statement
//        String updateStmt =
//                "   DELETE FROM info\n" +
//                        "         WHERE id = ?;";
//        //Execute UPDATE operation
//        Object[] data = {stdId};
//        return DataBaseConnection.dbExecuteUpdatePrepared(updateStmt, data);
//
//    }
//    //*************************************
//    //INSERT an Student
//    //*************************************
//    public static int insertStudent (Student s) {
//        //Declare a INSERT statement
//        String updateStmt =
//                "INSERT INTO info\n" +
//                        "(name)\n" +
//                        "VALUES\n" +
//                        "('"+s.getFirstName()+"');";
//        //Execute INSERT operation
//
//        return DataBaseConnection.dbExecuteUpdate(updateStmt);
//
//    }
//}
//
