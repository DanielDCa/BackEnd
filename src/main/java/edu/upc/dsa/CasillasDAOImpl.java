package edu.upc.dsa;

import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Casillas_mapa;
import edu.upc.dsa.models.Usuario;

import java.util.LinkedList;
import java.util.List;

public class CasillasDAOImpl implements  ICasillasDAO{

    private static CasillasDAOImpl manager;

    public static CasillasDAOImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) manager = new CasillasDAOImpl();
        return manager;


    }

    @Override
    public List<Casillas_mapa> getCasillasLevel(int level) {

        Session session = null;
        //int employeeID = 0;
        List<Casillas_mapa> casillas = new LinkedList<>();

        try {
            session = FactorySession.openSession();
            casillas = (List<Casillas_mapa>) session.findAllByParamenter(Casillas_mapa.class,"nivel",level+"");
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return casillas;
    }

    @Override
    public List<Casillas_mapa> getCasillasLevelType(int level, String tipo) {
        return null;
    }
}
