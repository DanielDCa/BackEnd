package edu.upc.dsa;

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
        Object obj = userDao.getUsuario("carlitos_98");
        System.out.println(obj.toString());

        //Probando el UPDATE  (Verificación siempre con correo)
        //userDao.updateUsuario("pepe@upc.edu","pepito_02","Pepe Maria","Garcia buhbuh","1234");

        //Probando el DELETE
        //userDao.deleteUsuario("pepe@upc.edu");



    }

}
