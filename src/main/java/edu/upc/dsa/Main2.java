package edu.upc.dsa;

import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Compra_arma;

import java.util.LinkedList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

       // FactorySession.openSession();

        int i =0;
        /*System.out.println("Valor: " + i++);
        System.out.println("Siguiente valor: " + i++);*/


        //Empezamos la prueba de almacenar algún usuario
        IUsuarioDAO userDao = new UsuarioDAOImpl();
        //String adas = userDao.addUsuario("pepe@upc.edu","pepito_02","Pepe Maria","Garcia","1234");

        //Probando el SELECT
        //Object obj = userDao.getUsuario("carlitos_98");
        //System.out.println(obj.toString());

        //Probando el UPDATE  (Verificación siempre con correo)
        //userDao.updateUsuario("pepe@upc.edu","pepito_02","Pepe Maria","Garcia buhbuh","1234");

        //Probando el DELETE
        //userDao.deleteUsuario("pepe@upc.edu");


        //Probando Armas
        List<Arma> armas = new LinkedList<>();
        IArmaDAO armaDAO = new ArmaDAOImpl();
        /*armas = armaDAO.getAllArmas();
        System.out.println(armas.toString());
        System.out.println(armas.size() + "");*/
        //System.out.println(armas.get(1).toString());

        //Probando armas Compradas
        /*List<Compra_arma> carmas = new LinkedList<>();
        carmas = armaDAO.getArmasCompradas("Carlo@upc.edu");
        System.out.println(carmas);*/

      //  armaDAO.comprarArma("lanzabombas","Carlo@upc.edu","Cualquiera");

        System.out.println(Encryption.enCode("Hola"));



        /*Probando casillas de mapa*/
        ICasillasDAO casillaDAO = CasillasDAOImpl.getInstance();
        System.out.println(casillaDAO.getCasillasLevel(1));

    }

}
