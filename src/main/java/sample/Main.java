package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //we need this variable to change the scenes
    private static Stage stg;

    @Override
    public void start(Stage PrimaryStage) throws IOException {
        stg = PrimaryStage;
        PrimaryStage.setResizable(false);
        Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        //Scene scene = new Scene(fxmlLoader.load());
        PrimaryStage.setScene(new Scene(root));
        PrimaryStage.setTitle("ManaGenie!!");
        PrimaryStage.show();
    }
    public void changeScene(String fxml) throws IOException{
       Parent pane= FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}