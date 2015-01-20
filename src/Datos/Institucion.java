package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Institucion {

    private int idVoluntario;
    private String CIF;
    private String nombre;
    private String rSocial;
    private String tlf;

    public Institucion() {
    }

    public Institucion(String CIF, String nombre, String rSocial, String tlf, int idVoluntario) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.rSocial = rSocial;
        this.tlf = tlf;
        this.idVoluntario = idVoluntario;
    }

    public void setInstitucion(String CIF, String nombre, String rSocial, String tlf, int idVoluntario) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.rSocial = rSocial;
        this.tlf = tlf;
        this.idVoluntario = idVoluntario;
    }

    public String getCIF() {
        return CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public String getrSocial() {
        return rSocial;
    }

    public String getTlf() {
        return tlf;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setrSocial(String rSocial) {
        this.rSocial = rSocial;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return CIF + ", " + nombre + ", " + rSocial + ", " + tlf;
    }


}
