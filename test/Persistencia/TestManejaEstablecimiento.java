/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Datos.Establecimiento;
import java.util.LinkedList;


public class TestManejaEstablecimiento {
    
    public static void main(String[] args) {
        ConexionOracle conn = new ConexionOracle();
        conn.Conexion();
        ManejaEstablecimiento mEst = new ManejaEstablecimiento(conn);
        
        // prueba generarClave()
        int clave = mEst.generarClave();
        Establecimiento establecimiento = new Establecimiento(clave, 
                "pepito inc.", 
                "calle puerto", 
                "archidona");
        
        // prueba insertarEstablecimiento()
        mEst.insertarEstablecimiento(establecimiento);
        System.out.println(establecimiento.toString() + "\n");
        
        // prueba getEstablecimiento()
        Establecimiento est2 = mEst.getEstablecimiento(clave);
        System.out.println(est2.toString() + "\n");
        
        // prueba getEstablecimientos()
        LinkedList<Establecimiento> ests = (LinkedList<Establecimiento>) 
                mEst.getEstablecimientos();
        for(Establecimiento e : ests) {
            System.out.println(e.toString());
        }
    }
}
