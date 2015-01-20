/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;


public class TestManejaVoluntario {
    public static void main(String[] args) {
        ConexionOracle conn = new ConexionOracle();
        conn.Conexion();
        
        ManejaVoluntario mVol = new ManejaVoluntario(conn);
        mVol.eliminaVoluntario(-1);
        int id = mVol.generarClave();
        
    }
}
