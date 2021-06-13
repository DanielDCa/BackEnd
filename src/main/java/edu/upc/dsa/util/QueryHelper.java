package edu.upc.dsa.util;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);
        int i = 0;
        //sb.append("ID");
        for (String field: fields) {

            if(i == 0){
                sb.append(field);
                i++;
            }
            else{
                sb.append(", ").append(field);
            }
        }

        sb.append(") VALUES (");
        i = 0;
        for (String field: fields) {
            if(i == 0) {
                sb.append("?");
                i++;
            }
            else{
                sb.append(", ?");
            }

        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Class theClasss, String pk) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClasss.getSimpleName());
        sb.append(" WHERE ").append(pk).append(" = ?");

        return sb.toString();
    }
    public static String createQueryUPDATE(Object entity,String pk){

        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(entity.getClass().getSimpleName()).append(" SET ");
        String [] fields = ObjectHelper.getFields(entity);

        int i = 0;
        //sb.append("ID");
        for (String field: fields) {

            if(pk == field){//No añadimos el correo(No se modifica)
                i++;
            }
            else{
                sb.append(field+" = ? ");
                i++;
                if(i < fields.length){
                    sb.append(", ");
                }

            }
        }
        sb.append("WHERE ").append(pk).append(" = ?");

        return  sb.toString();
    }
    public static String createQueryDELETE(Object entity,String pk){

        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM ").append(entity.getClass().getSimpleName()).append(" WHERE ").append(pk).append(" = ?");


        return sb.toString();

    }

}
