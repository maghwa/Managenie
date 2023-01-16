package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button course;
    @FXML
    private Button students;
    @FXML
    private Button todo_list;
    @FXML
    private Button grades;
    @FXML
    private Button absence;
    @FXML
    private Button schedule;
    @FXML
    private Button help;
    @FXML
    private Button profile;

    public static void checkHome() throws IOException {
        Main m = new Main();
        m.changeScene("view/Home.fxml");
    }

//    public static void checkHome() throws IOException {
//        Main m = new Main();
//        m.changeScene("view/Home.fxml");
//    }
//
//    public static void checkLogout() throws IOException {
//        Main m1 = new Main();
//        m1.changeScene("view/Logout.fxml");
//    }


    public void absence(ActionEvent event) throws IOException {
        checkAbsence();
    }

    static void checkAbsence() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/AbsencewithMenu.fxml");
    }

    public void grades(ActionEvent event) throws IOException {
        checkGrades();
    }

    static void checkGrades() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/Grades.fxml");
    }

    public void todoList(ActionEvent event) throws IOException {
        checkTodoList();
    }

    static void checkTodoList() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/To-Do lists.fxml");
    }

    public void student(ActionEvent event) throws IOException {
        checkStudent();
    }

    private void checkStudent() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/StudentInterface.fxml");
    }
    public HomeController() {

    }


}