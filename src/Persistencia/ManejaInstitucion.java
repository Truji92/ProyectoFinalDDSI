/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Datos.Institucion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author caenrique93
 */
public class ManejaInstitucion extends ManejaTabla {

    public ManejaInstitucion(ConexionOracle conn) {
        super(conn);
    }

    public void mostrarInstituciones() {
        try (Statement stmt = conn.createStatement()) {
            String statement = "select * from INSTITUCION";
            ResultSet rs = stmt.executeQuery(statement);
            List<Institucion> instituciones = new LinkedList<>();
            while (rs.next()) {
                instituciones.add(new Institucion(rs.getString("cif"),
                        rs.getString("nombre"),
                        rs.getString("razon_social"),
                        rs.getString("telefono"),
                        rs.getInt("idVoluntario")));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la tabla INSTITUCION");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public void eliminaInstitucion(String cif) {
        try (Statement stmt = conn.createStatement()) {
            String statement = "delete from INSTITUCION where CIF="
                    + "'" + cif + "'";
            stmt.executeUpdate(statement);
            conn.commit();
        } catch (SQLException e) {
            conn.rollBack();
            System.out.println("Error al eliminar de la tabla INSTITUCION");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
        int idVoluntario = -1;
        try (Statement stmt = conn.createStatement()) {
            String statement = "select idVoluntario from INSTITUCION where CIF="
                    + "'" + cif + "'";
            ResultSet rs = stmt.executeQuery(statement);
            rs.next();
            idVoluntario = rs.getInt("idVoluntario");
        } catch (SQLException e) {
            System.out.println("Error al consultar la tabla INSTITUCION");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }

        ManejaVoluntario mVol = new ManejaVoluntario(conn);
        mVol.eliminaVoluntario(idVoluntario);
    }

    public Institucion getVoluntario(int idVoluntario) {
        Institucion instit = null;
        try (Statement stmt = conn.createStatement()) {
            String statement = "select * from INSTITUCION "
                    + "where idVoluntario='" + idVoluntario + "'";
            ResultSet rs = stmt.executeQuery(statement);
            rs.next();
            instit = new Institucion(rs.getString("cif"),
                    rs.getString("nombre"),
                    rs.getString("razon_social"),
                    rs.getString("telefono"),
                    idVoluntario);
        } catch (SQLException ex) {
            System.out.println("Error al consultar de "
                    + "la tabla INSTITUCION");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return instit;
    }

    public void cambiaCIF(String cif_actual, String cif_nuevo) {
        try (Statement stmt = conn.createStatement()) {
            String statement = "update INSTITUCION set CIF='"
                    + cif_nuevo + "' where CIF='" + cif_actual + "'";
            stmt.executeUpdate(statement);
            conn.commit();
        } catch (SQLException e) {
            conn.rollBack();
            System.out.println("Error al eliminar de la tabla INSTITUCION");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public int generarClave() {
        String statement = "SELECT MAX(id) FROM INSTITUCION";
        int maximaClave = -1;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            maximaClave = rs.getInt(1);
            maximaClave++;
        } catch (SQLException ex) {
            System.out.println("Error al consultar clave de institucion");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return maximaClave;
    }
}
