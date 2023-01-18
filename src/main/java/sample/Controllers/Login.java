package sample.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.event.*;
import sample.Main;

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
    private Label loginMessageLabel;


    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    public void SignUp(ActionEvent event) throws IOException {
        checkSignUp();

    }

    private void checkSignUp() throws IOException {
        Main m1 = new Main();
        m1.changeScene("view/SignUp.fxml");
    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        m.changeScene("view/Home.fxml");
        /*if (username.getText().toString().equals("marwa") && password.getText().toString().equals("2022")) {
            loginMessageLabel.setText("Sucess!!");
            m.changeScene("view/Home.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            loginMessageLabel.setText("Please enter your data");
        } else {
            loginMessageLabel.setText("Wrong username or password!");
        }*/
    }
}