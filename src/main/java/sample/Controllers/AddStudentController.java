package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.DataBase.DataBaseConnection;
import sample.Models.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import static sample.Controllers.BasicController.*;

public class AddStudentController {

    @FXML
    private TextField EmailField;

    @FXML
    private TextField FirstNameField;


    @FXML
    private Label AjouMessage;

    @FXML
    private Button GoStudent;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField MatriculeField;

    @FXML
    private Button ValidAddB;

    @FXML
    void GoStudent(ActionEvent event) throws IOException {
        checkStudent();

    }
    ObservableList<Student> StudentObservableList = FXCollections.observableArrayList();
    @FXML
    void ValidAdd(ActionEvent event) {
        DataBaseConnection connectnow = new DataBaseConnection();
        Connection connectDB = connectnow.getConnection();

        String FirstName = FirstNameField.getText();
        String LastName = LastNameField.getText();
        String Email = EmailField.getText();
        String Matricule = MatriculeField.getText();

        StudentObservableList.add(new Student(FirstName,LastName,Email,Matricule));

        String insertFields = "INSERT INTO `Managenie_db`.`students` (`first_name`, `last_name`, `email`, `matricule`) VALUES ('";
        String insertValues = FirstName +"','"+ LastName +"','"+ Email +"','"+ Matricule +"')";
        String insertIntoRegister = insertFields + insertValues;

        try {

            if (FirstNameField.getText().isBlank() == false || LastNameField.getText().isBlank() == false || EmailField.getText().isBlank() == false || MatriculeField.getText().isBlank() == false  ) {

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertIntoRegister);

//                StudentTableView.refresh();
//                Parent root = FXMLLoader.load(getClass().getResource("CaisGestProduits.fxml"));
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene =  new Scene(root);
//                stage.setScene(scene);
//                stage.show();

                AjouMessage.setText("Produit Ajouté Avec Succes !");
                AjouMessage.setTextFill(Color.GREEN);

            }else {
                AjouMessage.setText("Veuillez Remplir Tous Les Cases");
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
