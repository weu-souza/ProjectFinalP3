package DAO;



import DTO.ProfessorDisciplinaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MainViewDAO {


    Connection conn ;
    PreparedStatement pstm;
    ResultSet rs = null;

    ArrayList<ProfessorDisciplinaDTO> lista = new ArrayList<>();

    public ArrayList<ProfessorDisciplinaDTO> professorDisciplina(){

        String sql = "select P.idProfessor, P.nomeProfessor,D.nomeDisciplina " +
                "from Professor  P, disciplina D " +
                "where P.idProfessor = D.cod_professor";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){

                ProfessorDisciplinaDTO objD = new ProfessorDisciplinaDTO(rs.getString("P.nomeProfessor"),rs.getString("D.nomeDisciplina"),rs.getInt("P.idProfessor"));
                lista.add(objD);

            }
            DB.closeResultSet(rs);
            DB.closeStatement(pstm);
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        return lista;
    }



}
