/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


public class Recoge {

    private int voluntario;
    private int establecimiento;
    private int alimento;
    private String fechaRecogida;
    private String fechaSalida;
    private boolean entregado;

    public Recoge() {
    }

    public Recoge(int voluntario, int establecimiento, int alimento, String fechaRecogida, String fechaSalida, boolean entregado) {
        this.voluntario = voluntario;
        this.establecimiento = establecimiento;
        this.alimento = alimento;
        this.fechaRecogida = fechaRecogida;
        this.fechaSalida = fechaSalida;
        this.entregado = entregado;
    }

    public int getVoluntario() {
        return voluntario;
    }

    public int getEstablecimiento() {
        return establecimiento;
    }

    public int getAlimento() {
        return alimento;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public boolean isEntregado() {
        return entregado;
    }


    public void setVoluntario(int voluntario) {
        this.voluntario = voluntario;
    }

    public void setEstablecimiento(int establecimiento) {
        this.establecimiento = establecimiento;
    }

    public void setAlimento(int alimento) {
        this.alimento = alimento;
    }

    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

}
