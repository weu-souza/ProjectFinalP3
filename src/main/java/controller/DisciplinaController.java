package controller;

import Util.Telas;
import com.example.p3project.App;
import javafx.fxml.FXML;

public class DisciplinaController {
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


}
