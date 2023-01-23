package sample.Controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

import static sample.Controllers.BasicController.*;
import static sample.Controllers.BasicController.checkAbsence;

public class TodoListController {
    int i = 0;

    @FXML
    private Button Absence;

    @FXML
    private ImageView AbsenceIcon;

    @FXML
    private Button Calender;

    @FXML
    private ImageView CalenderIcon;

    @FXML
    private ImageView CourseIcon;

    @FXML
    private Button Courses;

    @FXML
    private Button Edit;

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
    private ImageView LogoutIcon;
    @FXML
    private Pane MenuSlider;

    @FXML
    private Button MenuBOpen;

    @FXML
    private ImageView MenuIcon;

    @FXML
    private Button Profile;

    @FXML
    private ImageView ProfileIcon;

    @FXML
    private Button Todolist;

    @FXML
    private ImageView TodolistIcon;

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
        checkAbsence();

    }
}