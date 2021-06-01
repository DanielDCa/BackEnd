package edu.upc.dsa;

import edu.upc.dsa.models.Badges;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Min2Impl implements Min2nterfaz {


    private static Min2Impl manager;
    static final Logger logger = Logger.getLogger(Min2Impl.class.getName());


    List<User> users;
    List<Badges> badges;

    private Min2Impl() {
        /* Señalizamos las estructuras de datos */

        //this.jugadores = new HashMap<String, Jugador>();
        this.badges = new LinkedList<Badges>();
        this.users = new LinkedList<User>();

    }
    public static Min2Impl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) manager = new Min2Impl();
        return manager;


    }

    public static void delete() {
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");

    }


    @Override
    public User Registro(String username, String name, String avatar, String surname, List<String> medallas) {
        User usuarioNuevo = new User( username,  name, avatar, surname, medallas);
        this.users.add(usuarioNuevo);

        return usuarioNuevo;
    }
    /*@Override
    public Usuario Login(String apodo, String password) {
        Usuario userEcontrado = new Usuario();
        for (Usuario u : this.usuarios) {

            if (u.getNombre().equals(apodo)) {
                if (u.getPassword().equals(password)) {
                     userEcontrado = u;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return userEcontrado;
    }*/

    /*@Override
    public List<Usuario> getAllUser() {
        return this.usuarios;
    }*/


    /*@Override
    public Usuario getUsuario(String apodo) {
        Usuario usuarioEncontrado = new Usuario();
        for (Usuario u: this.usuarios){
            if (u.getApodo().equals(apodo))
            {
                usuarioEncontrado= u;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        for ( Usuario u: this.usuarios){
            if(u.getApodo().equals(usuario.getApodo()))

            {
                u.setApellido(usuario.getApellido());
                u.setNombre(usuario.getNombre());
                u.setPassword(usuario.getPassword());
                usuarioActualizado = u;
            }
        }
        return usuarioActualizado;
    }*/

    /*@Override
    public void deleteUser(String apodo) {
        for (Usuario u: this.usuarios){
            if (u.getApodo().equals(apodo)){
                this.usuarios.remove(u);
            }
        }
    }

    @Override
    public List<Jugador> muestrasJugadores(String idJugador) {
        for(Jugador j: this.jugones)
        {
            if(j.getId() == idJugador)
            {
                this.jugones.add(j);
            }
        }

        return this.jugones;
    }*/


    @Override
    public int sizeUser() {
        int ret = manager.users.size();
        logger.info("size " + ret);

        return ret;
    }

    @Override
    public List<Badges> getAllBadgets() {

        return badges;
    }

    @Override
    public User get1User(String id) {
        User usuarioEncontrado = new User();
        for (User u: this.users){
            if (u.getUsername().equals(id))
            {
                usuarioEncontrado= u;
            }
        }
        return usuarioEncontrado;

    }
}
