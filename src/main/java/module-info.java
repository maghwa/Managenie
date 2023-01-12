module com.example.project1 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sample to javafx.fxml;
    exports sample;
}