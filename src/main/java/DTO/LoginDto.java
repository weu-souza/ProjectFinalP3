package DTO;

public class LoginDto {
    private int id_usuario;
    private String nomeusuario,senhaUsuario;

    public LoginDto(String nomeusuario, String senhaUsuario) {
        setNomeusuario(nomeusuario);
        setSenhaUsuario(senhaUsuario);
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
