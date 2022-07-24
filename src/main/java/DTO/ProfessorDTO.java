package DTO;

public class ProfessorDTO {
    private String nome;
    private int ID;

    public ProfessorDTO(String nome) {
        setNome(nome);
    }



    public ProfessorDTO(String nome, int ID) {
       setNome(nome);
       setID(ID);
    }

    public ProfessorDTO() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
