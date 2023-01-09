package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.event.*;

import java.io.IOException;
public class Login {
    public Login() {
    }

    @FXML
    private Hyperlink ForgotPwd;

    @FXML
    private ImageView warning;

    @FXML
    private Button Login;

    @FXML
    private Hyperlink Signup;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label wrongLogin;


    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    public void SignUp(ActionEvent event) throws IOException {
        checkSignUp();

    }

    private void checkSignUp() throws IOException {
        Main m1 = new Main();
        m1.changeScene("SignUp.fxml");
    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if (username.getText().toString().equals("marwa") && password.getText().toString().equals("2022")) {
            wrongLogin.setText("Sucess!!");
            m.changeScene("view/Home.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data");
            warning.setVisible(true);
        } else {
            wrongLogin.setText("Wrong username or password!");
        }
    }
}