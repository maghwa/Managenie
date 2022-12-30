package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.stage.*;
import javafx.event.*;

import java.io.IOException;
public class SignUp {
    public SignUp() {
    }
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmationpassword;

    @FXML
    private Button button2;
    @FXML
    private Label wrongSignup;
    public void Register(ActionEvent event) throws IOException {
        checkRegister();

    }
    private void checkRegister() throws IOException {
        Main m2 = new Main();
        if (username.getText().toString().equals("maghwa") && password.getText().toString().equals("2022") && firstname.getText().toString().equals("marwa")&& lastname.getText().toString().equals("elkamil")&& confirmationpassword.getText().toString().equals("2022")) {
            wrongSignup.setText("Sucess!!");
            m2.changeScene("Home.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongSignup.setText("Please enter your data");
        } else {
            wrongSignup.setText("Wrong data!");
        }
    }

}