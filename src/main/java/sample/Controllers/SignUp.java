package sample.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.stage.*;
import javafx.event.*;
import sample.Main;

import java.io.IOException;
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
    private void checkRegister() throws IOException {
        Main m2 = new Main();
        if (username.getText().toString().equals("maghwa") && password.getText().toString().equals("2022") && firstName.getText().toString().equals("marwa")&& lastName.getText().toString().equals("elkamil")&& password2.getText().toString().equals("2022")) {
            wrongSignup.setText("Sucess!!");
            m2.changeScene("view/Home.fxml");
      } else if (username.getText().isEmpty() && password.getText().isEmpty() && firstName.getText().isEmpty() && lastName.getText().isEmpty() && password2.getText().isEmpty()) {
            wrongSignup.setText("Please enter your data");
         } else {
            wrongSignup.setText("Wrong data!");
        }
    }

}