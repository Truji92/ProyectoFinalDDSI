package Aplicacion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionOracle {

    private Connection conn;

    public void Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro la Clase");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.21.247:1521:pandora",
                    "DDSI_004", "DDSI_004pass");
        } catch (SQLException e) {
            System.out.println("Fallo en la conexion");
            e.printStackTrace();
        }
    }

    public void Desconexion() {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Statement createStatement() {
        Statement s = null;
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public CallableStatement prepareCall(String stmt) {
        CallableStatement call = null;
        try {
            call = conn.prepareCall(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return call;

    }

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void rollBack() {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void iniciarTransaccion() {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void terminarTransaccion() {
        try {
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
