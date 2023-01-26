package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UploadController implements Initializable {





    @FXML
    private ChoiceBox<String> type;
    private String[] types = {"tttt","rrrrrrrr"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.getItems().addAll(types);
    }
    @FXML
    private Button upload_btn;
    @FXML
    private Button back_btn;

    @FXML
    void GoBack(ActionEvent event) throws IOException {
        BasicController.checkCourseDisc();
    }

    @FXML
    void browser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("pdf Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            System.out.println("Selected file path: " + filePath);
        }

    }



}
