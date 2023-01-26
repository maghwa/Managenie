package sample.Controllers;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.event.*;
import javafx.util.Duration;
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

    @FXML
    private Label quote;

    private String message = "Set your goals high, and don’t stop till you get there";
    private int charIndex = 0;


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
}
