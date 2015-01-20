package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Alimento {
    private int id;
    private String descripcion;
    private String fechaCad;

    public Alimento() {
    }

    public Alimento(int id, String descripcion, String fechaCad) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCad = fechaCad;
    }

    public int getId() { return id; }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaCaducidad() {
        return fechaCad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    public void setFechaCad(String fechaCad) {
        this.fechaCad = fechaCad;
    }

    public String toString() {
        return "" + id + ", " + descripcion + ", " + fechaCad;
    }
}
