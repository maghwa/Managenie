package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import sample.DataBase.DataBaseConnection;
import sample.Models.Document;
import sample.Models.Student;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UploadController implements Initializable {

    ObservableList<Document> DocumentObservableList = FXCollections.observableArrayList();




//    @FXML
//    private ChoiceBox<String> type;
//    private String[] types = {"tttt","rrrrrrrr"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        type.getItems().addAll(types);
    }
    @FXML
    private Button upload_btn;
    @FXML
    private Button back_btn;
    @FXML
    private TextField DocDescField;

    @FXML
    private TextField DocNameField;
    @FXML
    private Label AjouMessage;


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
            //Add to data base
            DataBaseConnection connectnow = new DataBaseConnection();
            Connection connectDB = connectnow.getConnection();

            String docName = DocNameField.getText();
            String docDesc = DocDescField.getText();


            DocumentObservableList.add(new Document(docName,filePath,docDesc));

            String insertFields = "INSERT INTO `Managenie_db`.`document (`DocName`, `DocPath`, `Description`) VALUES ('";
            String insertValues = docName +"','"+ filePath +"','"+ docDesc +"')";
            String insertIntoRegister = insertFields + insertValues;

            try {

                if (DocNameField.getText().isBlank() == false || filePath.isBlank() == false || DocDescField.getText().isBlank() == false  ) {

                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertIntoRegister);

                    AjouMessage.setText("Document Ajouté Avec Succes !");
                    AjouMessage.setTextFill(Color.GREEN);

                }else {
                    AjouMessage.setText("Veuillez Remplir Tous Les Cases");
                    AjouMessage.setTextFill(Color.RED);
                }

            }catch (Exception e){

                AjouMessage.setText("Erreur");
                AjouMessage.setTextFill(Color.RED);
                e.printStackTrace();
                e.getCause();

            }

            System.out.println("Selected file path: " + filePath);
        }

    }



}
