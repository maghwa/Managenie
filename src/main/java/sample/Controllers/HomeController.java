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




    //the methods that each button of the  Menubar uses
    public void absence(ActionEvent event) throws IOException {
        BasicController.checkAbsence();
    }



    public void grades(ActionEvent event) throws IOException {
        BasicController.checkGrades();
    }



    public void todoList(ActionEvent event) throws IOException {
        BasicController.checkTodoList();
    }



    public void student(ActionEvent event) throws IOException {
        BasicController.checkStudent();
    }
    public void course(ActionEvent event) throws IOException{
        BasicController.checkCourse();
    }


    public HomeController() {

    }


}