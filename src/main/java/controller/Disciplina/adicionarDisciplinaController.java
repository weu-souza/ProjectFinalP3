package controller.Disciplina;

import DAO.DisciplinaDAO;
import DAO.ProfessorDAO;
import DTO.DisciplinaDTO;
import DTO.ProfessorDTO;
import Util.Alerts;
import com.example.p3project.App;
import Util.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class adicionarDisciplinaController {
    @FXML
    TextField addDisciplina;
    @FXML TextField addCodProfessor;
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
        App.changeScreen(Telas.ADDDISCIPLINA);
    }

    @FXML
    public void AlterarButton(){
        App.changeScreen(Telas.ALTDISCIPLINA);
    }

public void EnviarDisciplinaButton(){
        String disciplinaNome = addDisciplina.getText();
        int disciplinaCodProfessor =  Integer.parseInt(addCodProfessor.getText());
    DisciplinaDTO d = new DisciplinaDTO(disciplinaNome,disciplinaCodProfessor);
    DisciplinaDAO objDao = new DisciplinaDAO();
    objDao.adicionarDisciplina(d);
    Alerts.showAlert("","","Enviado, atualize", Alert.AlertType.CONFIRMATION);
}
}
