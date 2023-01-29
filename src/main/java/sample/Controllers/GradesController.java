package sample.Controllers;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.DataBase.DataBaseConnection;
import sample.Models.Grade;
import sample.Models.Student;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sample.Controllers.BasicController.*;
import static sample.Controllers.BasicController.checkAbsence;

public class GradesController implements Initializable {
        int i = 0;
        Grade grade =new Grade();
        @FXML
        private Button MenuB;

        @FXML
        private ImageView MenuIcon;

        @FXML
        private TableColumn<Grade,Integer> Student;

        @FXML
        private TableColumn<Student,Integer> Grade;

        @FXML
        private Pane MenuSlider;

        @FXML
        private TextField searchfield;


        @FXML
        private Button Home;

        @FXML
        private ImageView HomeIcon;

        @FXML
        private Button Calender;

        @FXML
        private ImageView CalenderIcon;

        @FXML
        private Button Courses;

        @FXML
        private ImageView CourseIcon;

        @FXML
        private Button Grades;

        @FXML
        private ImageView GradesIcon;

        @FXML
        private Button Todolist;

        @FXML
        private ImageView TodolistIcon;

        @FXML
        private Button Absence;

        @FXML
        private ImageView AbsenceIcon;

        @FXML
        private Button Profile;

        @FXML
        private ImageView ProfileIcon;

        @FXML
        private Button Help;

        @FXML
        private ImageView HelpIcon;

        @FXML
        private Button Logout;

        @FXML
        private ImageView LogoutIcon;

        @FXML
        private Button Edit;

        @FXML
        private ImageView EditIcon;
        @FXML
        private TableView<Grade> GradeTableView;

        ObservableList<Grade> GradeObservableList = FXCollections.observableArrayList();
        @FXML
        void Menu(ActionEvent event) {


                i++;


                if (i % 2 != 0) {
                        TranslateTransition slideout = new TranslateTransition();
                        slideout.setDuration(Duration.seconds(0.4));
                        slideout.setNode(MenuSlider);
                        System.out.println("1");
                        slideout.setToX(-60);
                        slideout.play();

                } else if (i % 2 == 0) {
                        TranslateTransition slidein = new TranslateTransition();
                        slidein.setDuration(Duration.seconds(0.4));
                        slidein.setNode(MenuSlider);
                        System.out.println("2");
                        slidein.setToX(0);

                        slidein.play();

                }


        }
        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
                DataBaseConnection connectNow = new DataBaseConnection();
                Connection connectDB = connectNow.getConnection();

                String GradeViewQuery = "SELECT S_id,Grade FROM Grades;";
                String StudentViewQuery = "SELECT first_name,last_name WHERE Student_id== S_id;";


                try {

                        Statement statement = connectDB.createStatement();
                        ResultSet queryOutput = statement.executeQuery(GradeViewQuery);
                        ResultSet queryOutput1 = statement.executeQuery(StudentViewQuery);

                        while (queryOutput.next()){


                                int queryStudent = queryOutput.getInt("Grade");
                                int queryGrade = queryOutput.getInt("S_id");


                                //Populate the Observable list of products
                                GradeObservableList.add(new Grade(queryStudent,queryGrade));


                        }

                        // Correspending each Column in interface with column in database

                        Student.setCellValueFactory(new PropertyValueFactory<>("idStudent"));
                        Grade.setCellValueFactory(new PropertyValueFactory<>("Mark"));



                        // insert Values oF GradesObservableList in the StudentTableView
                        GradeTableView.setItems(GradeObservableList);

                        //initial filtered list
                        FilteredList<Grade> filteredData = new FilteredList<>(GradeObservableList, b -> true);

                        searchfield.textProperty().addListener((observable ,oldValue, newValue)-> {
                                filteredData.setPredicate(student -> {

                                        if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                                                return true;
                                        }

                                        String searchKeyword = newValue.toLowerCase();

                                        if (grade.getIdStudent().toString().toLowerCase().indexOf(searchKeyword) > -1){
                                                return true;
                                        } else if (grade.getMark().toString().toLowerCase().indexOf(searchKeyword) > -1) {
                                                return true;

                                        }else {
                                                return false;
                                        }
                                });
                        });

                        SortedList<Grade> sortedData = new SortedList<>(filteredData);

                        sortedData.comparatorProperty().bind(GradeTableView.comparatorProperty());

                        GradeTableView.setItems(sortedData);


                }catch (SQLException e){
                        Logger.getLogger(GradesController.class.getName()).log(Level.SEVERE , null , e);
                        e.printStackTrace();
                }

        }


        @FXML
        void GoGrades(ActionEvent event) throws IOException {
                checkGrades();

        }

        @FXML
        void GoTodoList(ActionEvent event) throws IOException {
                checkTodoList();

        }

        @FXML
        void GoSchedule(ActionEvent event) throws IOException {
                checkSchedule();
        }

        @FXML
        void Logout(ActionEvent event) throws IOException {
                checkLogout();
        }


        @FXML
        void GoCourse(ActionEvent event) throws IOException {
                checkCourse();
        }


        @FXML
        void GoHelp(ActionEvent event) throws IOException {
                checkHelp();

        }

        @FXML
        void GoProfile(ActionEvent event) throws IOException {
                checkProfile();
        }

        @FXML
        void GoAbsence(ActionEvent event) throws IOException {
                checkAbsence();

        }

        @FXML
        void GoHome(ActionEvent event) throws IOException {
                checkHome();

        }

        @FXML
        void GoStudent(ActionEvent event) throws IOException {
                checkStudent();

        }
}