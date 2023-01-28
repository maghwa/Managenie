package sample.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static sample.Controllers.BasicController.*;

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



}