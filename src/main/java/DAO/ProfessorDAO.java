package DAO;


import DTO.ProfessorDTO;
import Util.Alerts;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class ProfessorDAO {
    Connection conn ;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<ProfessorDTO> lista = new ArrayList<>();
    public void adicionarProfessor(ProfessorDTO objProfessor){
        String sql = "insert into professor (nomeProfessor) values (?)";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProfessor.getNome());
            pstm.execute();
            DB.closeStatement(pstm);
        }
        catch (SQLException e)
        {
            throw new DbException(e.getMessage());
        }
    }

    public ArrayList<ProfessorDTO> pesquisarProfessor(){

        String sql = "select * from professor";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                ProfessorDTO objp = new ProfessorDTO(rs.getString("nomeProfessor"),rs.getInt("idProfessor"));
                lista.add(objp);

            }
            DB.closeResultSet(rs);
           DB.closeStatement(pstm);
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        return lista;
    }

    public void atualizarProfessor(ProfessorDTO professorDTO){
        String sql = "update professor set  nomeProfessor = ? where idProfessor = ?";
        conn = DB.getConnection();
        try{
           pstm = conn.prepareStatement(sql);
            pstm.setInt(2,professorDTO.getID());
            pstm.setString(1,professorDTO.getNome());
            pstm.execute();
            DB.closeStatement(pstm);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }
    }

    public void deletarProfessor(ProfessorDTO professorDTO){
        String sql = "delete  from professor where idProfessor=?";
        conn = DB.getConnection();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,professorDTO.getID());
            pstm.execute();

            DB.closeStatement(pstm);
        } catch (SQLException e) {
            Alerts.showAlert("","","remova a disciplina a qual o professor esta vinculado", Alert.AlertType.ERROR);
            throw new DbException(e.getMessage());
        }
    }
}
