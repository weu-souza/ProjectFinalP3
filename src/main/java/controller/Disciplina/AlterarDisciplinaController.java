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

public class AlterarDisciplinaController {

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
}
