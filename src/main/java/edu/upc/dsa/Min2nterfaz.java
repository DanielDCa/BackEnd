package edu.upc.dsa;

import edu.upc.dsa.models.Badges;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface Min2nterfaz {
    //autenticacion
    /*public Usuario Registro(String correo, String apodo, String nombre, String apellido, String password);
    public Usuario Login(String user, String password);*/

    //servicios  (A implementar lo mas prontro)
    public List<Badges> getAllBadgets();
    public User get1User(String id);
    public int sizeUser();
    public User Registro(String username, String name, String avatar, String surname, List<String> medallas);

    /*public void deleteUser(String id);

    public List<Jugador> muestrasJugadores(String idJugador);
    public int sizeJugadores();
    public int sizeUser();*/



}
