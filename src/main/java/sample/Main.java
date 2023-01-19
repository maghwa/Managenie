package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //we need this variable to change the scenes
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        primaryStage.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/BasicBackground.fxml"));
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("view/StudentInterface.fxml"));
        //fxmlLoader.setRoot(new AnchorPane());
        AnchorPane root = fxmlLoader.load();
        AnchorPane child = fxmlLoader1.load();
        //for the menu
        child.setTranslateX(156);
        root.getChildren().add(child);



        primaryStage.setScene(new Scene(root));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //for adding the logo
        Image image = new Image(getClass().getResource("Icons/Logo.png").openStream());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("ManaGenie!");
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
