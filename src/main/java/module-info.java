module com.example.p3project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.p3project to javafx.fxml;
    exports com.example.p3project;
    exports controller;
    opens controller to javafx.fxml;
}