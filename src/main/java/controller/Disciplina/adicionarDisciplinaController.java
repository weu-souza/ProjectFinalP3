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

public class adicionarDisciplinaController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldInteger(addCodProfessor);
    }
}
