package com.example.p3project;

import Util.Telas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
//telas{
    private static Stage stage;

    private static Scene loginScene;

    private static Scene mainViewScene;

    private static Scene professorScene;

    private static Scene disciplinaScene;
//}
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        FXMLLoader fxmlLogin = new FXMLLoader(App.class.getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin.load());

        FXMLLoader fxmlMainView = new FXMLLoader(App.class.getResource("MainView.fxml"));
        mainViewScene = new Scene(fxmlMainView.load());

        FXMLLoader fxmlProfessor = new FXMLLoader(App.class.getResource("Professor.fxml"));
        professorScene = new Scene(fxmlProfessor.load());
        FXMLLoader fxmlDisciplina = new FXMLLoader(App.class.getResource("Disciplina.fxml"));
        disciplinaScene = new Scene(fxmlDisciplina.load());
        stage.setScene(loginScene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void changeScreen(Telas Screen) {
        switch (Screen) {
            case LOGIN -> stage.setScene(loginScene);
            case MAIN -> stage.setScene(mainViewScene);

            case PROFESSOR -> stage.setScene(professorScene);

            case DISCIPLINA -> stage.setScene(disciplinaScene);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}