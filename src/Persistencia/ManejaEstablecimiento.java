/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Datos.Establecimiento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class ManejaEstablecimiento extends ManejaTabla {

    public ManejaEstablecimiento(ConexionOracle conn) {
        super(conn);
    }

    public void insertarEstablecimiento(Establecimiento est) {
        try (Statement stmt = conn.createStatement()) {
            String statement = "insert into ESTABLECIMIENTO values ('"
                    + est.getId() + "','"
                    + est.getNombre() + "','"
                    + est.getDireccion() + "','"
                    + est.getLocalidad() + "')";
            stmt.executeUpdate(statement);
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la tabla ESTABLECIMIENTO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
            conn.rollBack();
        }
    }

    public Establecimiento getEstablecimiento(int id) {
        Establecimiento est = null;
        try (Statement stmt = conn.createStatement()) {
            String statement = "select * from ESTABLECIMIENTO "
                    + "where id=" + id;
            ResultSet rs = stmt.executeQuery(statement);
            rs.next();
            est = new Establecimiento(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("localidad"));
        } catch (SQLException ex) {
            System.out.println("Error al consultar la tabla ESTABLECIMIENTO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return est;
    }

    public List<Establecimiento> getEstablecimientos() {
        List<Establecimiento> establecimientos = new LinkedList<>();
        try (Statement stmt = conn.createStatement()) {
            String statement = "select * from ESTABLECIMIENTO";
            ResultSet rs = stmt.executeQuery(statement);
            while (rs.next())
                establecimientos.add(new Establecimiento(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("localidad")));
        } catch (SQLException ex) {
            System.out.println("Error al consultar la tabla ESTABLECIMIENTO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return establecimientos;
    }

    public int generarClave() {
        String statement = "SELECT MAX(id) FROM ESTABLECIMIENTO";
        int maximaClave = -1;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            rs.next();
            maximaClave = rs.getInt(1);
            maximaClave++;
        } catch (SQLException ex) {
            System.out.println("Error al consultar clave de establecimiento");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return maximaClave;
    }
}
