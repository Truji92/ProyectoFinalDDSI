/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Date;



public class Recoge {
    
    private int voluntario;
    private int establecimiento;
    private int alimento;
    private Date fechaRecogida;
    private Date fechaSalida;
    private boolean entregado;

    public Recoge() {
    }

    public Recoge(int voluntario, int establecimiento, int alimento, Date fechaRecogida, Date fechaSalida, boolean entregado) {
        this.voluntario = voluntario;
        this.establecimiento = establecimiento;
        this.alimento = alimento;
        this.fechaRecogida = fechaRecogida;
        this.fechaSalida = fechaSalida;
        this.entregado = entregado;
    }

    public int getVoluntario() { return voluntario; }
    public int getEstablecimiento() { return establecimiento; }
    public int getAlimento() { return alimento; }
    public Date getFechaRecogida() { return fechaRecogida; }
    public Date getFechaSalida() { return fechaSalida; }
    public boolean isEntregado() { return entregado; }
    
    
    public void setVoluntario(int voluntario) { this.voluntario = voluntario; }
    public void setEstablecimiento(int establecimiento) { this.establecimiento = establecimiento; }
    public void setAlimento(int alimento) { this.alimento = alimento; }
    public void setFechaRecogida(Date fechaRecogida) { this.fechaRecogida = fechaRecogida; }
    public void setFechaSalida(Date fechaSalida) { this.fechaSalida = fechaSalida; }
    public void setEntregado(boolean entregado) { this.entregado = entregado; }

}
