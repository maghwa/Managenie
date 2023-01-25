package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.DataBase.DataBaseConnection;
import sample.Models.Course;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import static sample.Controllers.BasicController.*;

public class ModifyStudentController {

    @FXML
    private Label AjouMessage;
    @FXML
    private Label ModifMessage;
    @FXML
    private ChoiceBox<Course> Courses;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField FirstNameField;

    @FXML
    private Button GoStudent;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField MatriculeField;

    @FXML
    private Button ValidModifB;

    @FXML
    void GoStudent(ActionEvent event) throws IOException {
        checkStudent();

    }

    @FXML
    void ValidAdd(ActionEvent event) {

    }

    public void EditS(ActionEvent event){
    DataBaseConnection connectnow = new DataBaseConnection();
    Connection connectDB = connectnow.getConnection();


    String FirstName = FirstNameField.getText();
    String LastName = LastNameField.getText();
    String Email = EmailField.getText();
    String Matricule = MatriculeField.getText();

    String ModifyFields =" UPDATE `Managenie_db`.`student` SET `first_name` = '"+FirstName+"', `last_name` = '"+LastName +"',  `email` = '"+Email+"' WHERE (`matricule` = '"+Matricule+"');";
    String ModifyIntoRegister = ModifyFields ;

    try {
        Statement statement = connectDB.createStatement();
        statement.executeUpdate(ModifyIntoRegister);


        ModifMessage.setText("Produit Modifié Avec Succes !");
        ModifMessage.setTextFill(Color.BLUE);
        //StudentTableView.refresh();


    }catch (Exception e){

        e.printStackTrace();
        e.getCause();

        ModifMessage.setText("Veuillez Remplir Tous Les Cases");
        ModifMessage.setTextFill(Color.YELLOW);

    }


}
}
