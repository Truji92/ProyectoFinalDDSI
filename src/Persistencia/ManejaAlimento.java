/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Datos.Alimento;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author caenrique93
 */
public class ManejaAlimento extends ManejaTabla {

    public ManejaAlimento(ConexionOracle conn) {
        super(conn);
    }
    public List<Alimento> alimentosCaducados() {
        String statement = "{ call alimentosCaducados(?) }";
        Alimento alimento;
        LinkedList<Alimento> resultado = new LinkedList<>();
        try {
            CallableStatement call = conn.prepareCall(statement);
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.registerOutParameter(2, Types.VARCHAR);
            call.executeUpdate();
            
            if(call.getString(2) == null) {
                ResultSet rs = (ResultSet) call.getObject(1);
                while(rs.next()) {
                    alimento = new Alimento(rs.getInt(1), 
                                            rs.getString(2),
                                            rs.getDate(3));
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
}
