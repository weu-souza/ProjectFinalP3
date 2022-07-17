package DAO;

import DTO.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection conn;

    public ResultSet autenticacaoUsuario(LoginDto usuarioDto) {
        conn = DB.getConnection();
        try {
            String sql = "select * from login where nome= ? and senha= ?";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1,usuarioDto.getNomeusuario());
            pstm.setString(2,usuarioDto.getSenhaUsuario());

            return pstm.executeQuery();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }


    }
}
