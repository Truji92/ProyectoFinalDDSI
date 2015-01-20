/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManejaVoluntario  extends ManejaTabla {

    public ManejaVoluntario(ConexionOracle conn) {
        super(conn);
    }
    
    public void eliminaVoluntario(int idVoluntario) {
        try (Statement stmt = conn.createStatement()) {
            String statement = "delete from VOLUNTARIO where id=" +
                    "'" + idVoluntario + "'";
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            System.out.println("Error al eliminar de la tabla VOLUNTARIO");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            conn.rollBack();
        }
    }
    
    public int insertaVoluntario() {
        int clave = generarClave();
        try (Statement stmt = conn.createStatement()) {
            String statement = 
                    "insert into VOLUNTARIO values ('" + clave + "')";
            stmt.executeQuery(statement);
        } catch (SQLException e) {
            System.out.println("Error al insertar en la tabla VOLUNTARIO");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            conn.rollBack();
        }
        return clave;
    }
    
    public boolean existeVoluntario(int idVoluntario) {
        int cuenta = -1;
        try(Statement stmt = conn.createStatement()) {
            String statement = "select count(*) "
                        + "from VOLUNTARIO "
                        + "where id='" + idVoluntario + "'";
            ResultSet rs = stmt.executeQuery(statement);
            rs.next();
            cuenta = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Error al consultar la tabla VOLUNTARIO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return cuenta==1;
    }
        
    public int generarClave() {
        String statement = "SELECT MAX(id) FROM VOLUNTARIO";
        int maximaClave = -1;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            rs.next();
            maximaClave = rs.getInt(1);
            maximaClave++;
        } catch (SQLException ex){
            System.out.println("Error al consultar clave de Voluntario");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return maximaClave;
    }
}
