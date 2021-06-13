package edu.upc.dsa;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class    FactorySession {
    public static Session openSession() {
        Connection conn = getConnection();
        Session session = new SessionImpl(conn);

        return session;
    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/juego?" +
            "user=root&password=Daniel_18");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego","root","Daniel_18");
            System.out.println("Conexion establecida con la base de datos");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
