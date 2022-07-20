package controller;


import DAO.ProfessorDAO;
import DTO.ProfessorDTO;
import Util.Telas;
import com.example.p3project.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

import static Util.Telas.PROFESSOR;


public class ProfessorController implements Initializable {
    @FXML
    TableView<ProfessorDTO> TableViewProfessor;
    @FXML
    private TableColumn<ProfessorDTO,Integer> tableColumnid;

    @FXML
    private TableColumn<ProfessorDTO,String> tableColumnName;
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
        App.changeScreen(Telas.REMOVER);
    }

    @FXML
    public void AlterarButton(){
        App.changeScreen(Telas.ALTERAR);}


public void initTable(){
    tableColumnid.setCellValueFactory(new PropertyValueFactory<>("ID"));
    tableColumnName.setCellValueFactory(new PropertyValueFactory<>("nome"));
    TableViewProfessor.setItems(atualizarTabela());
}

public ObservableList<ProfessorDTO> atualizarTabela(){
ProfessorDAO dao = new ProfessorDAO();
return FXCollections.observableArrayList(dao.pesquisarProfessor());
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }
}
