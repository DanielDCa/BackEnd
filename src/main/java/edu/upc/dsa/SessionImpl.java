package edu.upc.dsa;



import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    //Le pasas un objeto cualquiera(Employe, Department), y te lo guarda en la base de datos (Registro)
    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);
        System.out.println(insertQuery);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            //pstm.setObject(1, 0);
            int i = 1;

            for (String field: ObjectHelper.getFields(entity)) {
                System.out.println(i + ": " + ObjectHelper.getter(entity, field) );
                pstm.setObject(i++,ObjectHelper.getter(entity, field) );//ObjectHelper ... como utilizar el getter?
            }

            //ExecuteQuery()
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {

    }
    //Obtener un usuario (Ejemplo: usuario logeado)
    public Object get(Class theClass, String pk, String value) {

        String selectQuery = QueryHelper.createQuerySELECT(theClass, pk);//createQuery... recibe un object
        //System.out.println();
        System.out.println(selectQuery);

        PreparedStatement pstm = null;
        Object obj = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            //pstm.setObject(1, 0)
            pstm.setObject(1, value);//ObjectHelper ... como utilizar el getter?

            try {
                 obj = theClass.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //rsmd.getColumnName(1);
            String nombre;

            if(rs.next()){
                System.out.println("Numero columnas: " + rsmd.getColumnCount());
                for (int j = 1; j <= rsmd.getColumnCount(); j++) {

                    nombre = rsmd.getColumnName(j);
                    //System.out.println(rs.getString(j));
                    System.out.println(nombre + ": " + rs.getObject(nombre));

                    //Con ayuda ed ObjectHelper añadimos cada atributo
                    ObjectHelper.setter(obj,nombre,rs.getObject(nombre));

                }
            }


           /* while (rs.next())
            {
                System.out.println("nombre="+rs.getObject("nombre")+
                        ", apellidos="+rs.getObject("apellidos")+
                        ", telefono="+rs.getObject("telefono"));
            }*/
            //ExecuteQuery()
            //pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public void update(Object object,String pk, String value) {

        String selectQuery = QueryHelper.createQueryUPDATE(object,pk);
        //System.out.println();
        System.out.println(selectQuery);

        PreparedStatement pstm = null;
        Object obj = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            //pstm.setObject(1, 0)
            //pstm.setObject(1, value);//ObjectHelper ... como utilizar el getter?

            int i = 1;

            for (String field: ObjectHelper.getFields(object)) {
                if(pk != field){
                    System.out.println(i + ": " + ObjectHelper.getter(object, field) );
                    pstm.setObject(i++,ObjectHelper.getter(object, field) );
                }
            }
            pstm.setObject(i++,value);

            //ExecuteQuery()
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Object object, String pk, String value) {

        String selectQuery = QueryHelper.createQueryDELETE(object,pk);
        //System.out.println();
        System.out.println(selectQuery);

        PreparedStatement pstm = null;
        Object obj = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            //pstm.setObject(1, 0)
            //pstm.setObject(1, value);//ObjectHelper ... como utilizar el getter?

           /* int i = 1;

            for (String field: ObjectHelper.getFields(object)) {
                if(pk != field){
                    System.out.println(i + ": " + ObjectHelper.getter(object, field) );
                    pstm.setObject(i++,ObjectHelper.getter(object, field) );
                }
            }
            pstm.setObject(i++,value);*/

            pstm.setObject(1,value);


            //ExecuteQuery()
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> findAll(Class theClass) {

        String selectQuery = QueryHelper.createQuerySELECT2(theClass);//createQuery... recibe un object
        //System.out.println();
        System.out.println(selectQuery);

        PreparedStatement pstm = null;
        List<Object> objetos;
        objetos = new LinkedList<>();

        try {
            pstm = conn.prepareStatement(selectQuery);
            //pstm.setObject(1, 0)

            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //rsmd.getColumnName(1);
            String nombre;


            int i =0;
            while(rs.next()){
                System.out.println("Numero columnas: " + rsmd.getColumnCount());

                try {
                    objetos.add( theClass.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                for (int j = 1; j <= rsmd.getColumnCount(); j++) {

                    nombre = rsmd.getColumnName(j);

                    //Mostramos el objeto
                    System.out.println(nombre + ": " + rs.getObject(nombre));

                    //Con ayuda de ObjectHelper añadimos cada atributo
                    ObjectHelper.setter(objetos.get(i),nombre,rs.getObject(nombre));

                }
                System.out.println(i);
                //Indice que nos permite recorrer el linkedlist
                i++;

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objetos;
    }
    public List<Object> findAllByParamenter(Class theClass,String pk, String value) {

        String selectQuery = QueryHelper.createQuerySELECT(theClass,pk);//createQuery... recibe un object
        //System.out.println();
        System.out.println(selectQuery);

        PreparedStatement pstm = null;
        List<Object> objetos;
        objetos = new LinkedList<>();

        try {
            pstm = conn.prepareStatement(selectQuery);
            //pstm.setObject(1, 0)
            pstm.setObject(1, value);

            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //rsmd.getColumnName(1);
            String nombre;


            int i =0;
            while(rs.next()){
                System.out.println("Numero columnas: " + rsmd.getColumnCount());

                try {
                    objetos.add( theClass.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                for (int j = 1; j <= rsmd.getColumnCount(); j++) {

                    nombre = rsmd.getColumnName(j);

                    //Mostramos el objeto
                    System.out.println(nombre + ": " + rs.getObject(nombre));

                    //Con ayuda de ObjectHelper añadimos cada atributo
                    ObjectHelper.setter(objetos.get(i),nombre,rs.getObject(nombre));

                }
                System.out.println(i);
                //Indice que nos permite recorrer el linkedlist
                i++;

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objetos;
    }


    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}
