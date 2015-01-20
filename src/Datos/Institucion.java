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
    private String razonSocial;
    private String telefono;

    public Institucion() {
    }

    public Institucion(String CIF, String nombre, String rSocial, String tlf, int idVoluntario) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.razonSocial = rSocial;
        this.telefono = tlf;
        this.idVoluntario = idVoluntario;
    }

    public void setInstitucion(String CIF, String nombre, String rSocial, String tlf, int idVoluntario) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.razonSocial = rSocial;
        this.telefono = tlf;
        this.idVoluntario = idVoluntario;
    }

    public String getCIF() {
        return CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTelefono() {
        return telefono;
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

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return CIF + ", " + nombre + ", " + razonSocial + ", " + telefono;
    }


}
