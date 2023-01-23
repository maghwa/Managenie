package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

import java.io.IOException;

import static sample.Controllers.BasicController.*;

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
        checkAbsence();
    }
    public void Logout(ActionEvent event) throws IOException {
        checkLogout();
    }
    public void schedule(ActionEvent event) throws IOException {
        checkSchedule();
    }



    public void grades(ActionEvent event) throws IOException {
       checkGrades();
    }



    public void todoList(ActionEvent event) throws IOException {
        checkTodoList();
    }



    public void student(ActionEvent event) throws IOException {
        checkStudent();
    }
    public void course(ActionEvent event) throws IOException{
        checkCourse();
    }
    public void GoHelp(ActionEvent event) throws IOException{
        checkHelp();
    }
    public void GoProfile(ActionEvent event) throws IOException{
        checkProfile();
    }



    public HomeController() {

    }


}