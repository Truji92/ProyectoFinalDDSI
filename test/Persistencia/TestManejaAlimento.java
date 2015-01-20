/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacion.ConexionOracle;
import Datos.Alimento;

import java.util.LinkedList;


public class TestManejaAlimento {
    public static void main(String[] args) {
        ConexionOracle conn = new ConexionOracle();
        conn.Conexion();
        
        ManejaAlimento mAlim = new ManejaAlimento(conn);
        
        // probar alimentosCaducados()
        LinkedList<Alimento> caducados = 
                (LinkedList<Alimento>) mAlim.alimentosCaducados();
        
        for(Alimento a : caducados) {
            System.out.println(a.toString());
        }
        
        // probar insertarAlimento
        mAlim.insertarAlimento(new Alimento(mAlim.generarClave(), 
                "grillo frito", 
                "06/10/2015"));
        
        conn.Desconexion();
    }
}
