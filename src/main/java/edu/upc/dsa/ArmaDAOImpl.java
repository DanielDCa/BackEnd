package edu.upc.dsa;

import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Compra_arma;
import edu.upc.dsa.models.Usuario;

import java.util.LinkedList;
import java.util.List;

public class ArmaDAOImpl implements IArmaDAO{

    private static ArmaDAOImpl manager;

    public static ArmaDAOImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) manager = new ArmaDAOImpl();
        return manager;


    }

    @Override
    public List<Arma> getAllArmas() {
        Session session = null;
        //int employeeID = 0;
        List<Arma> armas = new LinkedList<>();

        try {
            session = FactorySession.openSession();
            armas = (List<Arma>) session.findAll(Arma.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return armas;
    }

    @Override
    public List<Compra_arma> getArmasCompradas(String correo) {

        Session session = null;
        //int employeeID = 0;
        List<Compra_arma> armasCompradas = new LinkedList<>();

        try {
            session = FactorySession.openSession();
            armasCompradas = (List<Compra_arma>) session.findAllByParamenter(Compra_arma.class,"correo_usuario",correo);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return armasCompradas;
    }

    @Override
    public void comprarArma(String nombreArma, String correo, String formaPago) {

        Session session = null;
        //int employeeID = 0;
        try {
            session = FactorySession.openSession();
            Compra_arma comArma = new Compra_arma(correo,nombreArma,formaPago);
            session.save(comArma);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }


    }
}
