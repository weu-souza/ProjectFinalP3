package controller.Disciplina;

import DAO.DisciplinaDAO;
import DTO.DisciplinaDTO;
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

public class AlterarDisciplinaController implements Initializable {

    @FXML private TextField idAlterarD,newNameAlterar,newProfessorAlterar;
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

    @FXML
    public void btnEnviarD(){
        AlterarDisciplina();
    }

    public void AlterarDisciplina(){
        int id,novoProfessor;
        String nome;
        id = Integer.parseInt(idAlterarD.getText());
        nome = newNameAlterar.getText();
        novoProfessor = Integer.parseInt(newProfessorAlterar.getText());
        DisciplinaDTO D = new DisciplinaDTO(nome,id,novoProfessor);
        DisciplinaDAO objDiscDao = new DisciplinaDAO();
       objDiscDao.atualizarDisciplina(D);
        Alerts.showAlert("","","Enviado, atualize", Alert.AlertType.CONFIRMATION);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldInteger(idAlterarD);
        Constraints.setTextFieldInteger(newProfessorAlterar);
    }
}
