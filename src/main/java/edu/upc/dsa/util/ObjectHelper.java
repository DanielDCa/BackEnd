package edu.upc.dsa.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }

    public static void setter(Object object, String property, Object value) {
        // Method // invoke
        Class theClass = object.getClass();

        String firstLtr = property.substring(0,1);
        String restLtr = property.substring(1,property.length());
        firstLtr = firstLtr.toUpperCase();
        String pro = firstLtr + restLtr;

        Class[] arg = new Class[1];
        Field fields = null;
        try {
            fields = theClass.getDeclaredField(property);//Retorna el campo del del atributo del Objeto que especificamos en property

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        arg[0] = fields.getType();//Retorna una clase del objeto que identifica el campo


        Method method = null;//Tengo que hacer que la primera sea mayuscula(Property)
        try {
            method = theClass.getDeclaredMethod("set"+pro,arg);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //Object result = null;
        try {
             method.invoke(object, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public static Object getter(Object object, String property)  {
        // Method // invoke
        Class theClass = object.getClass();

        String firstLtr = property.substring(0,1);
        String restLtr = property.substring(1,property.length());
        firstLtr = firstLtr.toUpperCase();
        String pro = firstLtr + restLtr;

        Method method = null;//Tengo que hacer que la primera sea mayuscula(Property)
        try {
            method = theClass.getDeclaredMethod("get" + pro, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Object result = null;
        try {
            result = method.invoke(object, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return result;
    }
}
