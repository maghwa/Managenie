package sample.Controllers;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Main;

import java.io.IOException;


public class BasicController {
    int i = 0;

    @FXML
    private Pane MenuSlider;

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
    //the methods that switches between interface side bar uses
    static void checkStudent() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/StudentInterface.fxml");
    }
    static void checkProfile() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/Profile.fxml");
    }
    static void checkCourse() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/CourseHome.fxml");
    }
    static void checkTodoList() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/To-Do lists.fxml");
    }
    static void checkGrades() throws IOException {
        Main m2 = new Main();
        m2.changeScene("view/Grades.fxml");
    }
    static void checkAbsence() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/BasicBackground.fxml");
    }
    static void checkSchedule() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/Schedule.fxml");
    }
    static void checkHelp() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/Help.fxml");
    }
    public static void checkHome() throws IOException {
        Main m = new Main();
        m.changeScene("view/Home.fxml");
    }

    public static void checkLogout() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/Logout.fxml");
   }


    //the methods that each button of the  side bar uses
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
    }