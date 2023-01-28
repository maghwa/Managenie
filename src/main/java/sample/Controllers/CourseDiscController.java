package sample.Controllers;


import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.DataBase.DataBaseConnection;
import sample.Models.Course;
import sample.Models.Document;
import sample.Models.Student;

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

public class CourseDiscController implements Initializable
{
    ObservableList<Document> DocObservableList = FXCollections.observableArrayList();
    ObservableList<Course> CourseObservableList = FXCollections.observableArrayList();

    Course course= new Course();
    int i=0;
    @FXML
    private TableView<Document> DocTableView;
    @FXML
    private Button Absence;

    @FXML
    private ImageView AbsenceIcon;

    @FXML
    private Label Birthday;

    @FXML
    private Button Calender;

    @FXML
    private ImageView CalenderIcon;

    @FXML
    private TableColumn<?, ?> ClassColumn;

    @FXML
    private TableColumn<?, ?> CourseColumn;

    @FXML
    private ImageView CourseIcon;

    @FXML
    private Button Courses;

    @FXML
    private Button Edit;

    @FXML
    private ImageView EditIcon;

    @FXML
    private Label Email;

    @FXML
    private Label FirstName;

    @FXML
    private Label FirstName1;

    @FXML
    private Button Grades;

    @FXML
    private ImageView GradesIcon;

    @FXML
    private Button Help;

    @FXML
    private ImageView HelpIcon;

    @FXML
    private Button Home;

    @FXML
    private ImageView HomeIcon;

    @FXML
    private Label LastName;

    @FXML
    private Button Logout;

    @FXML
    private Button Logout1;

    @FXML
    private ImageView LogoutIcon;

    @FXML
    private Label Matricule;

    @FXML
    private Button MenuBOpen;

    @FXML
    private ImageView MenuIconOpen;

    @FXML
    private Pane MenuSlider;

    @FXML
    private Label Phone;

    @FXML
    private Button Profile;

    @FXML
    private ImageView ProfileIcon;

    @FXML
    private Label CourseName;

    @FXML
    private Label D;
    @FXML
    private Label TS;

    @FXML
    private Label Desc;

    @FXML
    private Label NS;

    @FXML
    private Label NStu;

    @FXML
    private Label Nc;

    @FXML
    private Button Upload;

    @FXML
    private TableColumn<?, ?> StartDayColumn;

    @FXML
    private Button Todolist;

    @FXML
    private ImageView TodolistIcon;

    @FXML
    private Button profile;

    @FXML
    private ImageView studentIcon;

    @FXML
    private Button Upload_btn;

    @FXML
    void GoAbsence(ActionEvent event) throws IOException {
        checkAbsence();
    }

    @FXML
    void GoCourse(ActionEvent event) throws IOException {
         checkCourse();
    }

    @FXML
    void GoGrades(ActionEvent event) throws IOException {
          checkGrades();
    }

    @FXML
    void GoHelp(ActionEvent event) throws IOException {
         checkHelp();
    }

    @FXML
    void GoHome(ActionEvent event) throws IOException {
        checkHome();

    }

    @FXML
    void GoProfile(ActionEvent event) throws IOException {
        checkProfile();

    }

    @FXML
    void GoSchedule(ActionEvent event) throws IOException {
        checkSchedule();

    }

    @FXML
    void GoStudent(ActionEvent event) throws IOException {
         checkStudent();
    }

    @FXML
    void GoTodoList(ActionEvent event) throws IOException {
        checkTodoList();

    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        checkLogout();

    }

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
    void Upload(ActionEvent event) throws IOException {

        checkUploadFile();
        //System.out.println(getClass().getResource("/upload.fxml"));
        //Main.popup();
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/upload.fxml"));
            loader.setController(new UploadController());
            Scene uploadScene = new Scene(loader.load());
            Stage popupStage = new Stage();
            popupStage.setScene(uploadScene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try {
            Parent parent;
            parent = FXMLLoader.load(getClass().getClassLoader().getResource("View/mamak.fxml"));


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

       /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Upload.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
            }
*/


    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String StudentViewQuery = "SELECT Course_name ,nofSession ,Time_session, Duration, Description FROM course;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(StudentViewQuery);

            while (queryOutput.next()){


                String queryCourseName = queryOutput.getString("Course_name");
                String queryNs = queryOutput.getString("nofSession");
                String queryTs = queryOutput.getString("Time_session");
                String queryD = queryOutput.getString("Duration");
                String queryDesc = queryOutput.getString("description ");

                //Populate the Observable list of products
                course=new Course(queryCourseName,queryTs,queryD,queryNs,queryDesc);
                CourseObservableList.add(course);

            }

            // Correspending each Column in interface with column in database


            CourseName.setText("course.getName()");
            D.setText("course.getDuration()");
            TS.setText("course.getTime_Session");
            NStu.setText("course.getNofStudent");
            NS.setText("course.getNofSession");


            // insert Values oF StudentObservableList in the StudentTableView

            DocTableView.setItems(DocObservableList);

//            //initial filtered list
//            FilteredList<Student> filteredData = new FilteredList<>(CourseObservableList, b -> true);
//
//            SearchField.textProperty().addListener((observable ,oldValue, newValue)-> {
//                filteredData.setPredicate(student -> {
//
//                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
//                        return true;
//                    }
//
//                    String searchKeyword = newValue.toLowerCase();
//
//                    if (student.getFirstName().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true;
//                    } else if (student.getLastName().toLowerCase().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else if (student.getEmail().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true;
//                    } else if (student.getMatricule().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true;
//                    }else {
//                        return false;
//                    }
//                });
//            });
//
//            SortedList<Student> sortedData = new SortedList<>(filteredData);
//
//            sortedData.comparatorProperty().bind(CourseTableView.comparatorProperty());
//
//            CourseTableView.setItems(sortedData);
//
//
        }catch (SQLException e){
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE , null , e);
            e.printStackTrace();
        }

    }

}

