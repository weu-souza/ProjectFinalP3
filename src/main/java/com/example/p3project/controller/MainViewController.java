package com.example.p3project.controller;


import Util.Telas;
import com.example.p3project.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {
    @FXML
    private Button itemProfessor;
    @FXML
    private Button itemDisciplina;

    @FXML
    public void MenuItemProfessor() {
        System.out.println("Professor");
    }

    @FXML
    public void MenuItemDisciplina() {
        System.out.println("Disciplina");
    }
@FXML
    public void SairButton(){
    App.changeScreen(Telas.LOGIN);
    }


}
