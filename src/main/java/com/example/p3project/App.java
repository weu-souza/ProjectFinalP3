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

    private static Scene adicionarScene;
    private static Scene alterarScene;

    private static Scene adicionarDScene;

    private static Scene alterarDScene;



//}
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

//       caminho das telas {
        FXMLLoader fxmlLogin = new FXMLLoader(App.class.getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin.load());

        FXMLLoader fxmlMainView = new FXMLLoader(App.class.getResource("MainView.fxml"));
        mainViewScene = new Scene(fxmlMainView.load());

        FXMLLoader fxmlProfessor = new FXMLLoader(App.class.getResource("Professor/Professor.fxml"));
        professorScene = new Scene(fxmlProfessor.load());

        FXMLLoader fxmlDisciplina = new FXMLLoader(App.class.getResource("Disciplina/Disciplina.fxml"));
        disciplinaScene = new Scene(fxmlDisciplina.load());

        FXMLLoader fxmlAddP = new FXMLLoader(App.class.getResource("Professor/adicionarProfessor.fxml"));
        adicionarScene = new Scene(fxmlAddP.load());

        FXMLLoader fxmlAlterarP = new FXMLLoader(App.class.getResource("Professor/alterarProfessor.fxml"));
        alterarScene = new Scene(fxmlAlterarP.load());

        FXMLLoader fxmlAlterarD = new FXMLLoader(App.class.getResource("Disciplina/alterarDisciplina.fxml"));
        alterarDScene = new Scene(fxmlAlterarD.load());

        FXMLLoader fxmlAdicionarD = new FXMLLoader(App.class.getResource("Disciplina/adicionarDisciplina.fxml"));
        adicionarDScene  = new Scene(fxmlAdicionarD.load());



//    }

        stage.setScene(loginScene);
        stage.centerOnScreen();
//        stage.resizableProperty().setValue(false);


        stage.show();
    }

    public static void changeScreen(Telas Screen) {
        switch (Screen) {
            case LOGIN -> {
                stage.setScene(loginScene);
                stage.centerOnScreen();
            }
            case MAIN -> {
                stage.setScene(mainViewScene);
                stage.centerOnScreen();
            }
            case PROFESSOR -> {
                stage.setScene(professorScene);
                stage.centerOnScreen();
            }
            case DISCIPLINA -> {
                stage.setScene(disciplinaScene);
                stage.centerOnScreen();
            }
            case ADICIONAR -> {
                stage.setScene(adicionarScene);
                stage.centerOnScreen();
            }
            case ALTERAR -> {
                stage.setScene(alterarScene);
                stage.centerOnScreen();
            }
            case ADDDISCIPLINA -> {
                stage.setScene(adicionarDScene);
                stage.centerOnScreen();
            }
            case ALTDISCIPLINA -> {
                stage.setScene(alterarDScene);
                stage.centerOnScreen();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}