package com.example.p3project;

import Util.Telas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;

    private static Scene loginScene;

    private static Scene mainView;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLogin = new FXMLLoader(App.class.getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin.load());
        FXMLLoader fxmlMainView = new FXMLLoader(App.class.getResource("MainView.fxml"));
        mainView = new Scene(fxmlMainView.load());

        stage.setScene(loginScene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void changeScreen(Telas Screen) {
        switch (Screen) {
            case LOGIN -> stage.setScene(loginScene);
            case MAIN -> {
                stage.setScene(mainView);
                stage.setAlwaysOnTop(false);
                stage.setMaxHeight(1200);
                stage.setMaxWidth(1200);

            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}