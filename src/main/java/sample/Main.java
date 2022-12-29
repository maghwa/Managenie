package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //we need this variable to change the scenes
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        fxmlLoader.setRoot(new AnchorPane());
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("ManaGenie!!");
        primaryStage.show();
    }
       public void changeScene(String fxml) throws IOException {
       Parent pane= FXMLLoader.load(getClass().getResource(fxml));
       stg.getScene().setRoot(pane);
   }
    public static void main(String[] args) {
        launch(args);
    }
}
