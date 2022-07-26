package controller.Disciplina;

import DAO.DisciplinaDAO;
import DTO.DisciplinaDTO;

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

public class DisciplinaController implements Initializable {

    @FXML TableView<DisciplinaDTO> TableViewDisciplina;
    @FXML private TableColumn<DisciplinaDTO,Integer> tabelaID;

    @FXML private TableColumn<DisciplinaDTO,String> tableName;
    @FXML public TableColumn<DisciplinaDTO,String> tableCodPrf;

    public void setTableCodPrf(TableColumn<DisciplinaDTO, String> tableCodPrf) {
        this.tableCodPrf = tableCodPrf;
    }

    @FXML private TextField pesquisarDisciplina;
    @FXML ObservableList<DisciplinaDTO> discipinaDTOObservableList = FXCollections.observableArrayList();
    private DisciplinaDTO selecionada;


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
    public void RemoverButton(){
        deletarDi();

    }
    @FXML
    public void btAtt(){
        TableViewDisciplina.setItems(atualizarTabela());
    }


    public void initTable(){
        tabelaID.setCellValueFactory(new PropertyValueFactory<>("IDDisciplina"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("nomeDisciplina"));
        tableCodPrf.setCellValueFactory(new PropertyValueFactory<>("codProfessor"));
        TableViewDisciplina.setItems(atualizarTabela());
        TableViewDisciplina.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionada = newValue);
    }
    public ObservableList<DisciplinaDTO> atualizarTabela(){
        DisciplinaDAO dao = new DisciplinaDAO();
        discipinaDTOObservableList = FXCollections.observableArrayList(dao.pesquisarDisciplina());
        return discipinaDTOObservableList;
    }
    private ObservableList<DisciplinaDTO> pesquisaD(){
        ObservableList<DisciplinaDTO> pesquisarDisciplinaObs = FXCollections.observableArrayList();
        for (DisciplinaDTO disciplinaDTO : discipinaDTOObservableList) {
            if (disciplinaDTO.getNomeDisciplina().contains(pesquisarDisciplina.getText())) {
                pesquisarDisciplinaObs.add(disciplinaDTO);
            }
        }
        return pesquisarDisciplinaObs;
    }

    public void btnPesquisarD(){
        TableViewDisciplina.setItems(pesquisaD());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }

    public void deletarDi(){
        if (selecionada!=null){
            DisciplinaDAO dao = new DisciplinaDAO();
            dao.deletarDisciplina(selecionada);
            Alerts.showAlert("","","Deletado, atualize", Alert.AlertType.CONFIRMATION);}
        else {
            Alerts.showAlert("","","selecione um usuario", Alert.AlertType.ERROR);
        }
    }

}
