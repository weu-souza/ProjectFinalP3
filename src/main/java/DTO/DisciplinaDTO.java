package DTO;

public class DisciplinaDTO {
    private String nomeDisciplina;
    private int ID;

    public DisciplinaDTO(String nomeDisciplina) {
        setNomeDisciplina(nomeDisciplina);
    }

    public DisciplinaDTO(int ID) {
        setID(ID);
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
}
