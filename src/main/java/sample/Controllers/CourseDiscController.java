package sample.Controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

import static sample.Controllers.BasicController.*;

public class CourseDiscController {

    int i=0;
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
        //System.out.println(getClass().getResource("/upload.fxml"));
        BasicController.checkUploadFile();
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

}

