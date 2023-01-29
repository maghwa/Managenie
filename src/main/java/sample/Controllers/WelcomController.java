package sample.Controllers;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;

import static sample.Controllers.BasicController.*;
import static sample.Controllers.QuotedayController.getRandomStringFromDB;

public class WelcomController {

    @FXML
    private Button LoginB;

    @FXML
    private Button SignupB;

    @FXML
    void GoLogin(ActionEvent event) throws IOException {
        checkLogin();

    }

    @FXML
    void GoSignUp(ActionEvent event) throws IOException {
        checkLogout();

    }
    @FXML
    private Label quote;

    private String message = getRandomStringFromDB();
    private int charIndex = 0;
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