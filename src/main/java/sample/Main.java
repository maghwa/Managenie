package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    //we need this variable to change the scenes
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
      /*  stg = primaryStage;
        primaryStage.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        AnchorPane root = fxmlLoader.load();

        //for the menu

        primaryStage.setScene(new Scene(root));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //for adding the logo
        Image image = new Image(getClass().getResource("Icons/Logo.png").openStream());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("ManaGenie!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
        stg=primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        fxmlLoader.setRoot(new AnchorPane());
        AnchorPane root = fxmlLoader.load();
        /*AnchorPane child=Scenethingy("view/StudentInterface.fxml");
        root.getChildren().add(child);*/
        Image image = new Image(Objects.requireNonNull(getClass().getResource("Icons/Logo.png")).openStream());
        primaryStage.getIcons().add(image);
        primaryStage.setScene(new Scene(root));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("ManaGenie!");
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane= FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane));
        AnchorPane child = Scenethingy("view/SlideBar.fxml");
        ((Pane)stg.getScene().getRoot()).getChildren().setAll(child);

    }
    public AnchorPane Scenethingy(String childinterface ) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource(childinterface));
        AnchorPane child = fxmlLoader1.load();
        child.setTranslateX(0);
        return child;

    }
    public static void main(String[] args) {
        launch(args);
    }
}
