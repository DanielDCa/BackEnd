package edu.upc.dsa.models;

public class Compra_arma {

    String correo_usuario;
    String nombre_arma;
    String forma_pago;

    public Compra_arma() {
    }

    public Compra_arma(String correo_usuario, String nombre_arma, String forma_pago) {
        this.correo_usuario = correo_usuario;
        this.nombre_arma = nombre_arma;
        this.forma_pago = forma_pago;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getNombre_arma() {
        return nombre_arma;
    }

    public void setNombre_arma(String nombre_arma) {
        this.nombre_arma = nombre_arma;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    @Override
    public String toString() {
        return "Compra_arma{" +
                "correo_usuario='" + correo_usuario + '\'' +
                ", nombre_arma='" + nombre_arma + '\'' +
                ", forma_pago='" + forma_pago + '\'' +
                '}';
    }
}
