package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

import java.io.IOException;

public class HomeController {
    public HomeController(){

    }
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


    public void absence(ActionEvent event) throws IOException {
        checkAbsence();
    }
    private void checkAbsence() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/AbsencewithMenu.fxml");
    }
    public void grades(ActionEvent event) throws IOException {
        checkGrades();
    }
    private void checkGrades() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/Grades.fxml");
    }
    public void todoList(ActionEvent event) throws IOException {
        checkTodoList();
    }
    private void checkTodoList() throws IOException {
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













}
