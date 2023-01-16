package sample.Controllers;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;



public class SliderController  {
    int i = 0;

    @FXML
    private Pane MenuSlider;

    @FXML
    void Menu(ActionEvent event) {


        i++;

        TranslateTransition slide = new TranslateTransition();
        if (i % 2 != 0) {
            MenuSlider.setTranslateX(-60);
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(MenuSlider);

            slide.play();


        }
        else if (i % 2 == 0) {
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(MenuSlider);

            slide.setToX(0);
            slide.play();
            MenuSlider.setTranslateX(60);


        }

    }
}