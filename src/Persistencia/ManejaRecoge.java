/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Aplicacion.Fecha;
import Datos.Alimento;
import Datos.Establecimiento;
import Datos.Institucion;
import Datos.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author caenrique93
 */
public class ManejaRecoge extends ManejaTabla {

    public ManejaRecoge(ConexionOracle conn) {
        super(conn);
    }
    
    public List<Alimento> listadoAlimentos(int idE, 
                            Date desde, 
                            Date hasta) {
        LinkedList<Alimento> resultado = new LinkedList<>();
        try (Statement stmt = conn.createStatement()) {
            String statement = "select * from ALIMENTO where " +
                    "id=( select alimento from RECOGE where " + 
                    "establecimiento=" + idE + " AND " +
                    "fechaEntrada>" + desde + " AND " +
                    "fechaEntrada<" + hasta + ")";
            ResultSet rs = stmt.executeQuery(statement);
            
            while(rs.next()) {
                int _id = rs.getInt(1);
                String _desc = rs.getString(2);
                Date _fecha = rs.getDate(3);
                resultado.add(new Alimento(_id, _desc, _fecha));
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar de ALIMENTO y RECOGE");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return resultado;
    }
    
    public void registraRecogida(int idV, int idE, Alimento a) {
        try (Statement stmt = conn.createStatement()) {
            String statement = "insert into ALIMENTO values (" +
                    "'" + a.getId() + "'," +
                    "'" + a.getDescripcion()+ "'," +
                    "'" + Fecha.fecha(a.getFechaCaducidad())+ "')";
            ResultSet rs = stmt.executeQuery(statement);
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la tabla ALIMENTO");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        try (Statement stmt = conn.createStatement()) {
            String statement = "insert into RECOGE values (" +
                    "'" + a.getId() + "'," +
                    "'" + idV + "'," +
                    "'" + idE + "'," + 
                    "'" + Fecha.fecha()+ "'," +
                    "Null, 0)";
            System.out.println(statement);
            ResultSet rs = stmt.executeQuery(statement);
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la tabla RECOGE");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        
    }
    
    public boolean productosRecogidos( int idVoluntario,
                                    Persona p,
                                    Institucion i,
                                    List<Alimento> a,
                                    List<Establecimiento> e) {
        boolean soloInfo = false;
        try (Statement stmt = conn.createStatement()) {
            String statement = "select a.id, "
                    + "a.descripcion, "
                    + "a.fecha_Caducidad, "
                    + "e.id, "
                    + "e.nombre, "
                    + "e.direccion, "
                    + "e.localidad "
                    + "from ALIMENTO a inner join("
                    + "RECOGE r inner join ESTABLECIMIENTO e "
                    + "on r.establecimiento=e.id) on a.id=r.alimento "
                    + "where r.voluntario='" + idVoluntario + "'";
            System.out.println(statement);
            ResultSet rs = stmt.executeQuery(statement);
            Alimento alimento;
            Establecimiento estab;
            a.clear();
            e.clear();
            while(rs.next()) {
                alimento = new Alimento(rs.getInt(1), 
                                        rs.getString(2),
                                        rs.getDate(3));
                estab = new Establecimiento(rs.getInt(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7));
                a.add(alimento);
                e.add(estab);
            }
            if(a.size() <= 5) {
                soloInfo = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar");
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        if(soloInfo) {
            try (Statement stmt = conn.createStatement()){
                String statement = "select count(*) "
                        + "from PERSONA "
                        + "where idVoluntario='" + idVoluntario + "'";
                ResultSet rs = stmt.executeQuery(statement);
                rs.next();
                int cuenta = rs.getInt(1);
                if(cuenta == 0) {
                    statement = "select * from INSTITUCION "
                            + "where idVoluntario='" + idVoluntario + "'";
                    rs = stmt.executeQuery(statement);
                    rs.next();
                    i.setInstitucion(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3), 
                                        rs.getString(4),
                                        rs.getInt(5));
                } else {
                    statement = "select * from PERSONA "
                            + "where idVoluntario='" + idVoluntario + "'";
                    System.out.println(statement);
                    rs = stmt.executeQuery(statement);
                    rs.next();
                    p.setPersona(rs.getString("dni"), 
                                    rs.getString("nombre"), 
                                    rs.getString("apellido1"), 
                                    rs.getString("apellido2"), 
                                    rs.getString("telefono"), 
                                    rs.getString("e_mail"), 
                                    rs.getInt("edad"), 
                                    rs.getString("localidad"),
                                    rs.getInt("idVoluntario"));
                    
                }
            } catch (SQLException ex) {
                System.out.println("Error al consultar la tabla PERSONA o INSTITUCION");
                System.out.println(ex.getMessage());
                System.out.println(ex.getSQLState());
                System.out.println(ex.getErrorCode());
            }
        }
        return soloInfo;
    }
}
