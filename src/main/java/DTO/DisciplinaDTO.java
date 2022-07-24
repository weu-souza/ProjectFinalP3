package DTO;

public class DisciplinaDTO  {
    private String nomeDisciplina;
    private int IDDisciplina, codProfessor;

    public DisciplinaDTO(String nomeDisciplina, int IDDisciplina, int codProfessor) {
        setNomeDisciplina(nomeDisciplina);
        setIDDisciplina(IDDisciplina);
        setCodProfessor(codProfessor);
    }


    public DisciplinaDTO(String nomeDisciplina, int codProfessor) {
        setNomeDisciplina(nomeDisciplina);
        setCodProfessor(codProfessor);
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getIDDisciplina() {
        return IDDisciplina;
    }

    public void setIDDisciplina(int ID) {
        this.IDDisciplina = ID;
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }
}
