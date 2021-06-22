package edu.upc.dsa.models;

public class Casillas_mapa {

    String nombre;
    int nivel;
    String tipo;
    String imagen;

    public Casillas_mapa() {
    }

    public Casillas_mapa(String nombre, int level, String tipo, String imagen) {
        this.nombre = nombre;
        this.nivel = level;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Casillas_mapa{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", tipo='" + tipo + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
