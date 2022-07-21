package DTO;

public class DisciplinaDTO {
    private String nomeDisciplina;
    private int ID, codProfessor;

    public DisciplinaDTO(String nomeDisciplina, int ID,int codProfessor) {
        setNomeDisciplina(nomeDisciplina);
        setID(ID);
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }
}
