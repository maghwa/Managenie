module com.example.project1 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;


    opens sample to javafx.fxml;
    exports sample;
    exports sample.Controllers;
    opens sample.Controllers to javafx.fxml;
    exports sample.DataBase;
    opens sample.DataBase to javafx.fxml;
}