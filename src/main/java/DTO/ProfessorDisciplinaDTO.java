package DTO;

public class ProfessorDisciplinaDTO{

    private String nomeP,nomeD;
    private int idP;

    public ProfessorDisciplinaDTO(String nomeProfessor, String nomeDisciplina, int idProfessor) {
        setNomeD(nomeDisciplina);
       setNomeP(nomeProfessor);
        setIdP(idProfessor);
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeProfessor) {
        this.nomeP = nomeProfessor;
    }

    public String getNomeD() {
        return nomeD;
    }

    public void setNomeD(String nomeDisciplina) {
        this.nomeD = nomeDisciplina;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idProfessor) {
        this.idP = idProfessor;
    }
}
