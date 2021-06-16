package edu.upc.dsa;

import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Compra_arma;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface IArmaDAO {

    //public String addUsuario(String correo, String apodo, String nombre, String apellido, String password);
    public List<Arma> getAllArmas();
    public List<Compra_arma> getArmasCompradas(String correo);
    public void comprarArma(String nombreArma, String correo, String formaPago);

    /*public void updateUsuario(String correo, String apodo, String name, String apellido, String password);
    public void deleteUsuario(String correo);
    public Usuario login(String apodo, String password);*/

}
