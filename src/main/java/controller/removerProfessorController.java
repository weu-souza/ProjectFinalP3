package controller;

import com.example.p3project.App;
import Util.Telas;
import javafx.fxml.FXML;

public class removerProfessorController {
    @FXML
    public void MenuItemProfessor() {
        App.changeScreen(Telas.PROFESSOR);
    }

    @FXML
    public void MenuItemDisciplina() {
        App.changeScreen(Telas.DISCIPLINA);

    }
    @FXML
    public void SairButton(){
        App.changeScreen(Telas.LOGIN);
    }

    @FXML
    public void MenuButton(){
        App.changeScreen(Telas.MAIN);
    }

    @FXML
    public void AdicionarButton(){
        App.changeScreen(Telas.ADICIONAR);
    }

    @FXML
    public void RemoverButton(){
        App.changeScreen(Telas.REMOVER);
    }

    @FXML
    public void AlterarButton(){
        App.changeScreen(Telas.ALTERAR);
    }
}
