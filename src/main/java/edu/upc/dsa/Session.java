package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close();
    Object get(Class theClass, String pk, String value);
    void update(Object object, String pk, String value);
    void delete(Object object, String pk, String value);
    List<Object> findAll(Class theClass);
    List<Object> findAllByParamenter(Class theClass,String pk, String value);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
}
