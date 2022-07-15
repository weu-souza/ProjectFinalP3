module com.example.p3project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.p3project to javafx.fxml;
    exports com.example.p3project;
}