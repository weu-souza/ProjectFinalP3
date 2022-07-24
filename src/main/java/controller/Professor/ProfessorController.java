package controller.Professor;


import DAO.ProfessorDAO;
import DTO.ProfessorDTO;
import Util.Alerts;
import Util.Telas;
import com.example.p3project.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

import static Util.Telas.PROFESSOR;


public class ProfessorController implements Initializable {
    @FXML TableView<ProfessorDTO> TableViewProfessor;
    @FXML private TableColumn<ProfessorDTO,Integer> tableColumnid;

    @FXML private TableColumn<ProfessorDTO,String> tableColumnName;
    @FXML private TextField pesquisarProfessor;
    @FXML ObservableList<ProfessorDTO> professorDTOObservableList = FXCollections.observableArrayList();
    private ProfessorDTO selecionada;
    @FXML
    public void MenuItemProfessor() {
        App.changeScreen(PROFESSOR);
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
        deletarPro();
        Alerts.showAlert("","","Deletado, atualize", Alert.AlertType.CONFIRMATION);
    }

    @FXML
    public void AlterarButton(){
        App.changeScreen(Telas.ALTERAR);}
    @FXML
    public void btAtt(){
        TableViewProfessor.setItems(atualizarTabela());
    }


public void initTable(){
    tableColumnid.setCellValueFactory(new PropertyValueFactory<>("ID"));
    tableColumnName.setCellValueFactory(new PropertyValueFactory<>("nome"));
    TableViewProfessor.setItems(atualizarTabela());
    TableViewProfessor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionada = newValue);
}
public ObservableList<ProfessorDTO> atualizarTabela(){
ProfessorDAO dao = new ProfessorDAO();
professorDTOObservableList = FXCollections.observableArrayList(dao.pesquisarProfessor());
return professorDTOObservableList;
}
private ObservableList<ProfessorDTO> pesquisa(){
        ObservableList<ProfessorDTO> pesquisarProfessorObs = FXCollections.observableArrayList();
    for (ProfessorDTO professorDTO : professorDTOObservableList) {
        if (professorDTO.getNome().contains(pesquisarProfessor.getText())) {
            pesquisarProfessorObs.add(professorDTO);
        }
    }
        return pesquisarProfessorObs;
}

    public void btnPesquisar(){
TableViewProfessor.setItems(pesquisa());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }

    public void deletarPro(){
        if (selecionada!=null){
        ProfessorDAO dao = new ProfessorDAO();
        dao.deletarProfessor(selecionada);}
        else {
            Alerts.showAlert("","","selecione um usuario", Alert.AlertType.ERROR);
        }
    }
}
