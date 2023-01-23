package sample.Controllers;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Models.Student;
import sample.Models.StudentModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Controllers.BasicController.*;

public class StudentsController implements Initializable {
    int i=0;
    @FXML
    private Button Absence;

    @FXML
    private ImageView AbsenceIcon;

    @FXML
    private Button Calender;

    @FXML
    private ImageView CalenderIcon;

    @FXML
    private TableColumn<?, ?> firstnameColumn;

    @FXML
    private TableColumn<?, ?> lastnameColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> matriculeColumn;

    @FXML
    private ImageView CourseIcon;

    @FXML
    private Button Courses;

    @FXML
    private Button Edit;

    @FXML
    private Button Edit1;

    @FXML
    private ImageView EditIcon;

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
    private Button Logout;

    @FXML
    private Button Logout1;

    @FXML
    private ImageView LogoutIcon;


    @FXML
    private Button MenuBOpen;

    @FXML
    private ImageView MenuIconOpen;

    @FXML
    private Pane MenuSlider;

    @FXML
    private Button Profile;

    @FXML
    private ImageView ProfileIcon;

    @FXML
    private Button Todolist;

    @FXML
    private ImageView TodolistIcon;

    @FXML
    private Button profile;

    @FXML
    private ImageView studentIcon;
    @FXML
    private TableView<Student> tableView;
    private StudentModel model = new StudentModel();


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
        checkAbsence();

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
//            tableView.setItems(model.getStudentList());
//            firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("First Name"));
//            lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("Last Name"));
//            emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
//            matriculeColumn.setCellValueFactory(new PropertyValueFactory<>("Matricule"));


        // You can write it this way too =>
        // nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

    }
//    @FXML
//    void loadDataButton(ActionEvent event) {
//        tableView.setItems(model.getStudentList());
//    }
//
//    @FXML
//    void addButton(ActionEvent event) {
//        Student newS = new Student(nameTextField.getText());
//        model.addStudent(newS);
//    }
//
//    @FXML
//    void deleteButton(ActionEvent event) {
//        Student selected = tableView.getSelectionModel().getSelectedItem();
//        model.deleteStudent(selected);
//    }
//
//    @FXML
//    void updateButton(ActionEvent event) {
//        Student selected = tableView.getSelectionModel().getSelectedItem();
//        model.updateStudent(selected, nameTextField.getText());
//    }
}



