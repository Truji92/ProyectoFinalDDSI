package Persistencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Aplicacion.ConexionOracle;
import Datos.Persona;


public class TestManejaPersona {
    public static void main(String[] args) {
        ConexionOracle conn = new ConexionOracle();
        conn.Conexion();
        
        ManejaPersona manejap = new ManejaPersona(conn);
        int clave = manejap.generarClave();
        Persona p = new Persona("29621482X", "Cesar", "Enrique", "Ramirez", 
                "722461083", "caenrique93@gmail.com", 21, "Huelva", 
                clave);
        
        // probar insertaPersona()
        manejap.insertaPersona(p);
        
        // probar getVoluntario()
        manejap.getVoluntario(clave);
        
        // probar existeVoluntario()
        manejap.existeVoluntario(clave);
        
        conn.Desconexion();
    }
}
