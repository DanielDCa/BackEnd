package edu.upc.dsa.models;

public class Usuario {

    String idUser;
    String nombre;
    String apellido;
    String password;

    public Usuario() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(String idUser, String nombre, String apellido, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public Usuario(String id, String nombre, String apellido) {
        this.idUser = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
