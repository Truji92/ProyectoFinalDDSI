/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Datos.Institucion;
import java.util.LinkedList;


public class TestManejaInstitucion {
    public static void main(String[] args) {
        ConexionOracle conn = new ConexionOracle();
        ManejaInstitucion mInst = new ManejaInstitucion(conn);
        conn.Conexion();
        
        
        // probar cambiaCIF()
        mInst.cambiaCIF("B12345678", "A11111113");
        
        // probar getVoluntario()
        System.out.println(mInst.getVoluntario(1));
        
        
        // probar getInstituciones()
        LinkedList<Institucion> instituciones = (LinkedList<Institucion>)
                 mInst.getInstituciones();
        for(Institucion inst : instituciones) 
            System.out.println(inst);
        
        // probar eliminaIstitucion
        mInst.eliminaInstitucion("A11111113");
        
        // probar getInstituciones()
        instituciones = (LinkedList<Institucion>)
                 mInst.getInstituciones();
        for(Institucion inst : instituciones) 
            System.out.println(inst);
        
        conn.Desconexion();
    }
}
