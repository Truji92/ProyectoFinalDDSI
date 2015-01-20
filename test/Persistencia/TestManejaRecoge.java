package Persistencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Aplicacion.ConexionOracle;
import Datos.Alimento;
import Datos.Establecimiento;
import Datos.Institucion;
import Datos.Persona;
import java.util.Date;
import java.util.LinkedList;


public class TestManejaRecoge {
    public static void main(String args[]) {
        ConexionOracle conn = new ConexionOracle();
        conn.Conexion();
        ManejaRecoge mr = new ManejaRecoge(conn);
        Alimento a = new Alimento(10, "papa cocia", new Date(2015, 4, 1));
        
        mr.registraRecogida(3, 1, a);
        
        Persona p = new Persona();
        Institucion i = new Institucion();
        LinkedList<Alimento> alimentos = new LinkedList<>();
        LinkedList<Establecimiento> establs = new LinkedList<>();
        boolean resultado;
        mr.productosRecogidos(3, alimentos, establs);
        for(int index=0;index<alimentos.size();index++) {
            System.out.println(alimentos.get(index).toString() +" " +  establs.get(index).toString());
        }
        a = new Alimento(11, "papa cocia", new Date(2015, 4, 1));
        mr.registraRecogida(3, 1, a);
        a = new Alimento(12, "papa cocia", new Date(2015, 4, 1));
        mr.registraRecogida(3, 1, a);
        a = new Alimento(13, "papa cocia", new Date(2015, 4, 1));
        mr.registraRecogida(3, 1, a);
        a = new Alimento(14, "papa cocia", new Date(2015, 4, 1));
        mr.registraRecogida(3, 1, a);
        a = new Alimento(15, "papa cocia", new Date(2015, 4, 1));
        mr.registraRecogida(3, 1, a);
        

        mr.productosRecogidos(3, alimentos, establs);
        for(int index=0;index<alimentos.size();index++) {
            System.out.println(alimentos.get(index).toString() +" " +  establs.get(index).toString());
        }

        conn.Desconexion();
    }
}
