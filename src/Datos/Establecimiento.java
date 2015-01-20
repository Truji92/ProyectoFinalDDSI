package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Establecimiento {
    private int id;
    private String nombre;
    private String direccion;
    private String localidad;

    public Establecimiento() {
    }

    public Establecimiento(int id, String nombre, String direccion, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
    }

    public void setEstablecimiento(int id, String nombre, String direccion, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return id + ", " + nombre + ", " + direccion + ", " + localidad;
    }


}
