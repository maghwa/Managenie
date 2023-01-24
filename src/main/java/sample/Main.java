package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    //we need this variable to change the scenes
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        fxmlLoader.setRoot(new AnchorPane());
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        Image image = new Image(Objects.requireNonNull(getClass().getResource("Icons/Logo.png")).openStream());
        primaryStage.getIcons().add(image);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("ManaGenie!!");
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane= FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
