package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;

public class UsuarioDAOImpl implements  IUsuarioDAO{

    private static UsuarioDAOImpl manager;

    public static UsuarioDAOImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) manager = new UsuarioDAOImpl();
        return manager;
    }

    @Override
    public String addUsuario(String correo, String apodo, String nombre, String apellido, String password) {

        Session session = null;
        //int employeeID = 0;
        try {
            session = FactorySession.openSession();
            Usuario usuario = new Usuario(correo, apodo, nombre, apellido , password);
            session.save(usuario);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return apodo;
    }

    @Override
    public Usuario getUsuario(String apodo) {

        Session session = null;
        Usuario usuario = null;
        try {
            session = FactorySession.openSession();
            usuario = (Usuario)session.get(Usuario.class, "apodo", apodo);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return usuario;
    }

    @Override
    public void updateUsuario(String correo, String apodo, String name, String apellido, String password) {

        Session session = null;
        Usuario usuario = null;
        try {
            session = FactorySession.openSession();
            usuario = (Usuario)session.get(Usuario.class, "correo", correo);//Tomamos el usuario de la base de datos por medio del correo
            usuario.setApodo(apodo);
            usuario.setNombre(name);
            usuario.setApellido(apellido);
            usuario.setPassword(password);//Buscar otra forma de actualizarlos

            session.update(usuario,"correo" ,correo);//Le envio objeto ya modificado


        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteUsuario(String correo) {
        Session session = null;
        Usuario usuario = null;
        try {
            session = FactorySession.openSession();
            usuario = (Usuario)session.get(Usuario.class, "correo", correo);//Tomamos el usuario de la base de datos por medio del correo

            session.delete(usuario,"correo",correo);
            //session.update(usuario,"correo" ,correo);//Le envio objeto ya modificado


        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }

    @Override
    public Usuario login(String apodo, String password) {

        Session session = null;
        Usuario usuario = null;
        try {
            session = FactorySession.openSession();
            usuario = (Usuario)session.get(Usuario.class, "apodo", apodo);

            if(usuario.getPassword().equals(password)){
                System.out.println("Son iguales");
            }
            else{
                usuario = null;
            }
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return usuario;

    }
}
