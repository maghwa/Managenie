package sample.Controllers;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.DataBase.DataBaseConnection;
import sample.Models.Attendance;
import sample.Models.Classe;
import sample.Models.Course;
import sample.Models.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sample.Controllers.BasicController.*;
import static sample.Controllers.BasicController.checkAbsence;

public class AbsenceController implements Initializable {

    private Attendance attendance = new Attendance();
    ObservableList<Attendance> AbsenceObservableList = FXCollections.observableArrayList();

    int i = 0;
    @FXML
    private Button Absence;
    @FXML
    private TextField SearchField;
    @FXML
    private TableView<Attendance> AbsenceTableView;

    @FXML
    private TableColumn<Attendance, Boolean> AbsentColl;

    @FXML
    private Button Calender;

    @FXML
    private ChoiceBox<Course> CorurseBox;

    @FXML
    private Button Courses;

    @FXML
    private Button Edit;

    @FXML
    private ImageView EditIcon;

    @FXML
    private Button Grades;

    @FXML
    private Button Help;

    @FXML
    private Button Home;

    @FXML
    private TableColumn<Attendance, Boolean> JustifCol;
    @FXML
    private TableColumn<Attendance, Date> DateofA;

    @FXML
    private Button Logout;

    @FXML
    private Button MenuB;

    @FXML
    private ImageView MenuIconOpen;

    @FXML
    private Pane MenuSlider;

    @FXML
    private TableColumn<Attendance, String> SNameColumn;

    @FXML
    private Button Profile;

    @FXML
    private Button Todolist;

    @FXML
    private Button Validate;

    @FXML
    private ChoiceBox<Classe> classBox;


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
    @FXML
    void GoGrades(ActionEvent event) throws IOException {
        checkGrades();

    }

    @FXML
    void GoTodoList(ActionEvent event)throws IOException {
        checkTodoList();

    }

    @FXML
    void GoSchedule(ActionEvent event) throws IOException {
        checkSchedule();
    }
    @FXML
    void Logout(ActionEvent event) throws IOException{
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
    void GoAbsence(ActionEvent event)throws IOException {
        checkAbsence();

    }
    @FXML
    void GoHome (ActionEvent event) throws IOException {
        checkHome();

    }
    @FXML
    void GoStudent(ActionEvent event)throws IOException {
        checkStudent();

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String AbsenceViewQuery = "SELECT * FROM Absence " ;
        String StudentViewQuery = "SELECT first_name,last_name FROM students " ;


        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(StudentViewQuery);

            while (queryOutput.next()){


                String queryFirstName = queryOutput.getString("first_name");
                String queryLastName = queryOutput.getString("last_name");
                Date queryDate = queryOutput.getDate("DateofA");
                Boolean queryAbs = queryOutput.getBoolean("Absent");
                Boolean queryJust = queryOutput.getBoolean("Justif");

                String studentName = queryFirstName +" "+queryLastName;
                //Populate the Observable list of products
               AbsenceObservableList.add(new Attendance(studentName, queryDate , queryAbs, queryJust));

            }

            // Correspending each Column in interface with column in database

            SNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"+"LastName"));
            AbsentColl.setCellValueFactory(new PropertyValueFactory<>("Absent"));
            JustifCol.setCellValueFactory(new PropertyValueFactory<>("Justification"));
            DateofA.setCellValueFactory(new PropertyValueFactory<>("DateofA"));




            // insert Values oF StudentObservableList in the StudentTableView
            AbsenceTableView.setItems(AbsenceObservableList);

            //initial filtered list
            FilteredList<Attendance> filteredData = new FilteredList<>(AbsenceObservableList, b -> true);

            SearchField.textProperty().addListener((observable ,oldValue, newValue)-> {
                filteredData.setPredicate(student -> {

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (attendance.getStudentName().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (attendance.getAbsent().toString().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (attendance.getJustificated().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (attendance.getDateofAbsence().toString().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else {
                        return false;
                    }
                });
            });

            SortedList<Attendance> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(AbsenceTableView.comparatorProperty());

            AbsenceTableView.setItems(sortedData);


        }catch (SQLException e){
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE , null , e);
            e.printStackTrace();
        }

    }


}










