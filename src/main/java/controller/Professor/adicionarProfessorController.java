package controller.Professor;

import DAO.ProfessorDAO;
import DTO.ProfessorDTO;
import Util.Alerts;
import com.example.p3project.App;
import Util.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class adicionarProfessorController {
    @FXML
    private TextField addProfessor;

    @FXML
    public void MenuItemProfessor() {
        App.changeScreen(Telas.PROFESSOR);
    }

    @FXML
    public void MenuItemDisciplina() {
        App.changeScreen(Telas.DISCIPLINA);

    }

    @FXML
    public void SairButton() {
        App.changeScreen(Telas.LOGIN);
    }

    @FXML
    public void MenuButton() {
        App.changeScreen(Telas.MAIN);
    }

    @FXML
    public void AdicionarButton() {
        App.changeScreen(Telas.ADICIONAR);
    }

    @FXML
    public void AlterarButton() {
        App.changeScreen(Telas.ALTERAR);
    }

    public void btnEnviarProfessor() {
        ProfessorDTO p = new ProfessorDTO(addProfessor.getText());
        ProfessorDAO objDao = new ProfessorDAO();
        objDao.adicionarProfessor(p);
        Alerts.showAlert("","","Enviado, atualize", Alert.AlertType.CONFIRMATION);

    }
}
