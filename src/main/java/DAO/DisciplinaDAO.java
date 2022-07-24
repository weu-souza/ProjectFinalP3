package DAO;

import DTO.DisciplinaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisciplinaDAO {

    Connection conn ;
    PreparedStatement pstm;
    ResultSet rs = null;
    ArrayList<DisciplinaDTO> lista = new ArrayList<>();
    public void adicionarDisciplina(DisciplinaDTO ObjDisciplina){
        String sql = "insert into disciplina (nomeDisciplina,cod_professor) values (?,?)";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, ObjDisciplina.getNomeDisciplina());
            pstm.setInt(2,ObjDisciplina.getCodProfessor());
            pstm.execute();
            DB.closeStatement(pstm);
        }
        catch (SQLException e)
        {
            throw new DbException(e.getMessage());
        }
    }

    public ArrayList<DisciplinaDTO> pesquisarDisciplina(){

        String sql = "select * from disciplina";
        conn = DB.getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                DisciplinaDTO objD = new DisciplinaDTO(rs.getString("nomeDisciplina"),rs.getInt("idDisciplina"),rs.getInt("cod_professor"));
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

    public void atualizarDisciplina(DisciplinaDTO disciplinaDTO){
        String sql = "update disciplina set nomeDisciplina = ?, cod_professor = ? where idDisciplina = ?";
        conn = DB.getConnection();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(3,disciplinaDTO.getIDDisciplina());
            pstm.setString(1,disciplinaDTO.getNomeDisciplina());
            pstm.setInt(2,disciplinaDTO.getCodProfessor());
            pstm.execute();
            DB.closeStatement(pstm);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }
    }

    public void deletarDisciplina(DisciplinaDTO disciplinaDTO){
        String sql = "delete  from disciplina where idDisciplina=?";
        conn = DB.getConnection();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,disciplinaDTO.getIDDisciplina());
            pstm.execute();

            DB.closeStatement(pstm);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }
    }
}
