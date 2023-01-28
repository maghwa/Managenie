package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sample.DataBase.DataBaseConnection;
import sample.Models.Course;
import sample.Models.Student;

import java.sql.Connection;
import java.sql.Statement;

public class AddCourController {
    ObservableList<Course> CourseObservableList = FXCollections.observableArrayList();
    @FXML
    private TextField CourseName;

    @FXML
    private TextField D;

    @FXML
    private TextArea Desc;

    @FXML
    private Button GoStudent;

    @FXML
    private TextField Nc;

    @FXML
    private TextField Ns;
    @FXML
    private Label AjouMessage;

    @FXML
    private TextField TS;

    @FXML
    private Button ValidAddB;

    @FXML
    void GoStudent(ActionEvent event) {

    }

    @FXML
    void ValidAdd(ActionEvent event) {
        DataBaseConnection connectnow = new DataBaseConnection();
        Connection connectDB = connectnow.getConnection();

        String Name = CourseName.getText();
        String TimeSession = TS.getText();
        String Duration = D.getText();
        String NSession = Ns.getText();
        String NClasse = Nc.getText();
        String Description = Desc.getText();

        CourseObservableList.add(new Course(Name,TimeSession,Duration,NSession,Description));

        String insertFields = "INSERT INTO `Managenie_db`.`Course` (`Course_name`, `nofSession`, `DTime_session`, `Duration`, `description`) VALUES ('";
        String insertValues =  Name+"','"+ NSession +"','"+ Duration+"',,'"+ NClasse+"','"+  TimeSession +"','"+  Description +"')";
        String insertIntoRegister = insertFields + insertValues;

        try {

            if (CourseName.getText().isBlank() == false || Ns.getText().isBlank() == false || Nc.getText().isBlank() == false || D.getText().isBlank() == false|| Desc.getText().isBlank() == false || TS.getText().isBlank() == false  ) {

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertIntoRegister);


                AjouMessage.setText("Cours Ajouté Avec Succes !");
                AjouMessage.setTextFill(Color.GREEN);

            }else {
                AjouMessage.setText("Veuillez Remplir Toute Les Cases");
                AjouMessage.setTextFill(Color.RED);
            }

        }catch (Exception e){

            AjouMessage.setText("Erreur");
            AjouMessage.setTextFill(Color.RED);
            e.printStackTrace();
            e.getCause();

        }


    }


}


