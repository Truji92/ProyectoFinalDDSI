/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Aplicacion.Fecha;
import Datos.Alimento;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class ManejaAlimento extends ManejaTabla {

    public ManejaAlimento(ConexionOracle conn) {
        super(conn);

    }

    public List<Alimento> alimentosCaducados() {
        String statement = "{ call alimentosCaducados(?,?,?) }";
        Alimento alimento;
        LinkedList<Alimento> resultado = new LinkedList<>();
        try {
            CallableStatement call = conn.prepareCall(statement);
            call.setString(1,Fecha.fecha());
            call.registerOutParameter(2, OracleTypes.CURSOR);
            call.registerOutParameter(3, Types.VARCHAR);
            call.executeUpdate();

            if (call.getString(2) == null) {
                ResultSet rs = (ResultSet) call.getObject(1);
                while (rs.next()) {
                    alimento = new Alimento(rs.getInt(1),
                            rs.getString(2),
                            Fecha.fecha(rs.getDate(3)));
                    resultado.add(alimento);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar alimentos caducados");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return resultado;
    }

    public void insertarAlimento(Alimento a) {
        try (Statement stmt = conn.createStatement()) {
            String statement = "insert into ALIMENTO values (" +
                    "'" + a.getId() + "'," +
                    "'" + a.getDescripcion() + "'," +
                    "'" + a.getFechaCaducidad() + "')";
            ResultSet rs = stmt.executeQuery(statement);
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la tabla ALIMENTO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
            conn.rollBack();
        }
    }

    public void eliminaAlimento(int id) {

        try (Statement stmt = conn.createStatement()) {
            String statement = "delete from ALIMENTO where id = " + id;
            stmt.executeUpdate(statement);
        } catch (SQLException ex) {
            System.out.println("Error al eliminar en la tabla ALIMENTO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
            conn.rollBack();
        }
    }

    public int generarClave() {
        String statement = "SELECT MAX(id) FROM ALIMENTO";
        int maximaClave = -1;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            maximaClave = rs.getInt(1);
            maximaClave++;
        } catch (SQLException ex) {
            System.out.println("Error al consultar clave de alimentos");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return maximaClave;
    }
}
