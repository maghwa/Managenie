package sample.Controllers;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;
import javafx.util.Duration;
import sample.DataBase.DataBaseConnection;
import sample.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static sample.Controllers.BasicController.checkLogin;
import static sample.Controllers.QuotedayController.getRandomStringFromDB;

public class SignUp {
    public SignUp() {
    }
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField password2;

    @FXML
    private Button button2;
    @FXML
    private Label wrongSignup;
    @FXML
    private Hyperlink login;
    public void Register(ActionEvent event) throws IOException {
        checkRegister();

    }
    @FXML
    private Label quote;

    private String message = getRandomStringFromDB();
    private int charIndex = 0;


    private void checkRegister() throws IOException {
        Main m2 = new Main();


        DataBaseConnection connectnow = new DataBaseConnection();
        Connection connectDB = connectnow.getConnection();

        String FirstName = firstName.getText();
        String LastName = lastName.getText();
        String UserName = username.getText();
        String Password = password.getText();
        String Password2 = password2.getText();





        String insertFields = "INSERT INTO `Managenie_db`.`profile` (`T_first_name`, `T_last_name`, `username`, `password`) VALUES ('";
        String insertValues = FirstName +"','"+ LastName +"','"+ UserName +"','"+ Password+"')";
        String insertIntoRegister = insertFields + insertValues;

        try{

            if (firstName.getText().isBlank() == false || lastName.getText().isBlank() == false || username.getText().isBlank() == false || password.getText().isBlank() == false || password2.getText().isBlank() == false ) {
                if(Password.equals(Password2)) {
                    try {
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(insertIntoRegister);

                        wrongSignup.setText("Compte Crée Avec Succes !");
                        wrongSignup.setTextFill(Color.GREEN);
                        m2.changeScene("view/Home.fxml");
                    } catch (SQLException ex) {
                        wrongSignup.setText("Erreur");
                        wrongSignup.setTextFill(Color.RED);

                        throw new RuntimeException(ex);
                    }
                }else{
                    wrongSignup.setText("Verifié la confirmation du mot de passe !");
                    wrongSignup.setTextFill(Color.RED);

                }

            }else {
                wrongSignup.setText("Veuillez Remplir Tous Les Cases");
                wrongSignup.setTextFill(Color.RED);
            }

        }catch (Exception e){

            wrongSignup.setText("Erreur");
            wrongSignup.setTextFill(Color.RED);
            e.printStackTrace();
            e.getCause();

        }




    }

    public void initialize() {
        //quote.setStyle("-fx-effect: dropshadow(gaussian, #f0c4f7, 5, 0.5, 0, 0);");
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                quote.setText(message.substring(0, charIndex++));
                                if (charIndex > message.length()) {
                                    charIndex = 0;
                                }
                            }
                        }));
        timeline.play();


    }

    public void Login(ActionEvent actionEvent) throws IOException {

        checkLogin();
    }


}


