package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.stage.*;
import javafx.event.*;

import java.io.IOException;
public class Login {
    public Login() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if (username.getText().toString().equals("marwa") && password.getText().toString().equals("2022")) {
            wrongLogin.setText("Sucess!!");
            //m.changeScene("Home.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data");
        } else {
            wrongLogin.setText("Wrong username or password!");
        }
    }
}