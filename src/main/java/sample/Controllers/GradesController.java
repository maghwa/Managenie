package sample.Controllers;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class GradesController {
        int i=0;
        @FXML
        private Button MenuB;

        @FXML
        private ImageView MenuIcon;

        @FXML
        private Pane MenuSlider;

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
        void Menu(ActionEvent event) {

                i++;

                TranslateTransition slide = new TranslateTransition();
                if (i % 2 != 0) {
                        MenuSlider.setTranslateX(-60);
                        slide.setDuration(Duration.seconds(0.4));
                        slide.setNode(MenuSlider);

                        slide.play();


                }
                else if (i % 2 == 0) {
                        slide.setDuration(Duration.seconds(0.4));
                        slide.setNode(MenuSlider);

                        slide.setToX(0);
                        slide.play();
                        MenuSlider.setTranslateX(60);


                }
        }


        /*@FXML
        void GoHelp(ActionEvent event) throws IOException {
                HomeController.checkHelp();

        }

        @FXML
        void GoProfile(ActionEvent event) throws IOException {
                HomeController.checkProfile();

        }*/




   /*     @FXML
        void goHome(ActionEvent event) throws IOException {
                HomeController.checkHome();

        }

        @FXML
        void goSchedule(ActionEvent event) throws IOException {
                HomeController.checkSchedule();
        }*/

}




