package com.example.p3project.controller;


import Dao.DB;
import Util.Alerts;
import Util.Telas;
import com.example.p3project.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



import java.sql.*;
//    controller da tela de login
public class loginController {

// texto aonde e inserido o usuario
@FXML
private TextField User;

//texto onde e inserido a senha
@FXML
private PasswordField password;
//atributo para guardar o que o usuario escreve no usuario
String usuario;
//atributo para guardar o que o usuario escreve na senha
String senha;
//metodo para ação de  click do botão de login
    @FXML
    public void onBtLoginAction(){
        usuario = User.getText();
       senha = password.getText();

        Connection coon;
        Statement st = null;
        ResultSet rs = null;
        boolean dbUser;
        boolean dbPass ;
//aqui abro a conexão com o banco, procuro o nome e a senha na tabela login e comparo se e igual ao que o usuario escreve na tela de login e senha e fecho no final.
        try {
            coon = DB.getConnection();
            st = coon.createStatement();
            rs = st.executeQuery("select * from login");

            while (rs.next()){
                dbUser= rs.getString("nome").equals(usuario);
                dbPass = rs.getString("senha").equals(senha);
                if (dbUser && dbPass){
                    App.changeScreen(Telas.MAIN);



                }
                else {
                    Alerts.showAlert("Error login","","usuario ou senha invalidos", Alert.AlertType.ERROR);
                }

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {

            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.CloseConnection();
        }

    }


}

