/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Fecha {
    public static String fecha() {
        Date fecha = new Date();
        DateFormat hour = new SimpleDateFormat("dd/MM/yyyy");
        return hour.format(fecha);
    }
    
    public static String fecha(Date date) {
        DateFormat hour = new SimpleDateFormat("dd/MM/yyyy");
        return hour.format(date);
    }
}
