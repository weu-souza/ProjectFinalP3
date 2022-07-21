package controller.Disciplina;

import DAO.DisciplinaDAO;
import DTO.DisciplinaDTO;

import Util.Alerts;
import Util.Telas;
import com.example.p3project.App;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    @FXML private TableColumn<DisciplinaDTO,String> tableCodPrf;
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
        Alerts.showAlert("","","Deletado, atualize", Alert.AlertType.CONFIRMATION);
    }
    @FXML
    public void btAtt(){
        TableViewDisciplina.setItems(atualizarTabela());
    }


    public void initTable(){
        tabelaID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("nomeDisciplina"));
        tableCodPrf.setCellValueFactory(new PropertyValueFactory<>("codProfessor"));
        TableViewDisciplina.setItems(atualizarTabela());
        TableViewDisciplina.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<DisciplinaDTO>() {
            @Override
            public void changed(ObservableValue<? extends DisciplinaDTO> observable, DisciplinaDTO oldValue, DisciplinaDTO newValue) {
                selecionada = newValue;
            }
        });


    }
    public ObservableList<DisciplinaDTO> atualizarTabela(){
        DisciplinaDAO dao = new DisciplinaDAO();
        discipinaDTOObservableList = FXCollections.observableArrayList(dao.pesquisarDisciplina());
        return discipinaDTOObservableList;
    }
    private ObservableList<DisciplinaDTO> pesquisaD(){
        ObservableList<DisciplinaDTO> pesquisarDisciplinaObs = FXCollections.observableArrayList();
        for (int i = 0; i< discipinaDTOObservableList.size(); i++){
            if (discipinaDTOObservableList.get(i).getNomeDisciplina().contains(pesquisarDisciplina.getText())){
                pesquisarDisciplinaObs.add(discipinaDTOObservableList.get(i));
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
            dao.deletarDisciplina(selecionada);}
        else {
            Alerts.showAlert("","","selecione um usuario", Alert.AlertType.ERROR);
        }
    }

}
