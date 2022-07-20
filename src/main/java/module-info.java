module com.example.p3project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.example.p3project to javafx.fxml;
    exports com.example.p3project;
    exports controller;
    opens controller to javafx.fxml;
    exports DTO;
    opens DTO to javafx.fxml;
    exports Util;
    opens Util to javafx.fxml;
    exports DAO;
    opens DAO to javafx.fxml;

}