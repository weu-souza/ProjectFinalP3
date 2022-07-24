package controller;


import DAO.MainViewDAO;
import DTO.ProfessorDisciplinaDTO;
import Util.Telas;
import com.example.p3project.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    TableView<ProfessorDisciplinaDTO> TableViewMain;
    @FXML private TableColumn<ProfessorDisciplinaDTO,Integer> tabelaIDPrf;

    @FXML private TableColumn<ProfessorDisciplinaDTO,String> tableNamePrf;
    @FXML private TableColumn<ProfessorDisciplinaDTO,String> tableNameDsc;
    @FXML private TextField pesquisarProfessorDisciplina;
    @FXML ObservableList<ProfessorDisciplinaDTO> MainViewObs = FXCollections.observableArrayList();

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
    public void btAttMain(){
        TableViewMain.setItems(atualizarTabela());
    }
    public void btnPesquisarPrfDsc(){
        TableViewMain.setItems(pesquisaPrfD());
    }

    public void initTable(){
        tabelaIDPrf.setCellValueFactory(new PropertyValueFactory<>("idP"));
        tableNamePrf.setCellValueFactory(new PropertyValueFactory<>("nomeP"));
        tableNameDsc.setCellValueFactory(new PropertyValueFactory<>("nomeD"));
        TableViewMain.setItems(atualizarTabela());
    }

    public ObservableList<ProfessorDisciplinaDTO> atualizarTabela(){
        MainViewDAO dao = new MainViewDAO();
        MainViewObs = FXCollections.observableArrayList(dao.professorDisciplina());
        return MainViewObs;
    }
    private ObservableList<ProfessorDisciplinaDTO> pesquisaPrfD(){
        ObservableList<ProfessorDisciplinaDTO> pesquisarDisciplinaObs = FXCollections.observableArrayList();
        for (ProfessorDisciplinaDTO mainViewOb : MainViewObs) {
            if (mainViewOb.getNomeD().contains(pesquisarProfessorDisciplina.getText())) {
                pesquisarDisciplinaObs.add(mainViewOb);
            }
        }
        return pesquisarDisciplinaObs;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }

}
