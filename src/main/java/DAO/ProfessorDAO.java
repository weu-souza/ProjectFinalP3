package DAO;

import DTO.ProfessorDTO;

import java.sql.*;
import java.util.ArrayList;

public class ProfessorDAO {
    Connection conn ;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<ProfessorDTO> lista = new ArrayList<>();
    public void adicionarProfessor(ProfessorDTO objProfessor){
        String sql = "insert into professor (NomeProfessor) values (?)";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProfessor.getNome());
            pstm.execute();
            pstm.close();
        }
        catch (SQLException e)
        {
            throw new DbException(e.getMessage());
        }
    }

    public ArrayList<ProfessorDTO> pesquisarProfessor(){

        String sql = "select * from projetop3.Professor";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                ProfessorDTO objP = new ProfessorDTO(rs.getString("nomeProfessor"),rs.getInt("idProfessor"));
                lista.add(objP);

            }
            DB.closeResultSet(rs);
           DB.closePSTM(pstm);
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        return lista;
    }

}
