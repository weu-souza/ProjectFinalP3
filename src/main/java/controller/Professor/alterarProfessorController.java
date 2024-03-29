package controller.Professor;

import DAO.ProfessorDAO;
import DTO.ProfessorDTO;
import Util.Alerts;
import Util.Constraints;
import com.example.p3project.App;
import Util.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class alterarProfessorController implements Initializable {
    @FXML private TextField idAlterar, nomeAlterar;

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
    @FXML
    public void btnEnviar(){
Alterar();
    }

    public void Alterar(){
       int id;
       String nome;
       id = Integer.parseInt(idAlterar.getText());
       nome = nomeAlterar.getText();
        ProfessorDTO  professor = new ProfessorDTO(nome,id);
        ProfessorDAO objProfDao = new ProfessorDAO();
        objProfDao.atualizarProfessor(professor);
        Alerts.showAlert("","","Enviado, atualize", Alert.AlertType.CONFIRMATION);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldInteger(idAlterar);
    }
}


