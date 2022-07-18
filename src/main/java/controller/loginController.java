package controller;





import DAO.DB;
import DAO.DbException;
import DAO.LoginDAO;
import DTO.LoginDto;
import Util.Alerts;
import com.example.p3project.Telas;
import com.example.p3project.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

//    controller da tela de login
public class loginController {

    // texto aonde e inserido o usuario
    @FXML
    private TextField User;

    //texto onde e inserido a senha
    @FXML
    private PasswordField password;

    //metodo para ação de  click do botão de login
    @FXML
    public void onBtLoginAction() {

    try {
        LoginDto objDto = new LoginDto(User.getText(),password.getText());

        LoginDAO usuarioDao = new LoginDAO();
        ResultSet rsLoginDao = usuarioDao.autenticacaoUsuario(objDto);

        if (rsLoginDao.next()){
            // chamar a tela que MainView
            App.changeScreen(Telas.MAIN);

        }
        else {
        // erro de login
            Alerts.showAlert("Error login","","usuario ou senha invalidos", Alert.AlertType.ERROR);

        }
        DB.closeResultSet(rsLoginDao);

    }
    catch (SQLException e){
        throw new DbException(e.getMessage());
    }
    finally {
        DB.CloseConnection();
    }

    }


}

