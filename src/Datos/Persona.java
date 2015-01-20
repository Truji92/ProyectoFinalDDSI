package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Persona {
    private int idVoluntario;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tlf;
    private String email;
    private int edad;
    private String localidad;

    public Persona() {

    }

    public Persona(String dni, String nombre, String apellido1, 
            String apellido2, String tlf, String email, int edad,
            String localidad, int idVoluntario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tlf = tlf;
        this.email = email;
        this.edad = edad;
        this.localidad = localidad;
        this.idVoluntario = idVoluntario;
    }
    
    public void setPersona(String dni, String nombre, String apellido1, 
            String apellido2, String tlf, String email, int edad,
            String localidad, int idVoluntario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tlf = tlf;
        this.email = email;
        this.edad = edad;
        this.localidad = localidad;
        this.idVoluntario = idVoluntario;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido1() { return apellido1; }
    public String getApellido2() { return apellido2; }
    public String getTlf() { return tlf; }
    public String getEmail() { return email; }
    public int getEdad() { return edad; }
    public String getLocalidad() { return localidad; }
    public int getIdVoluntario() { return idVoluntario; }
    
    public void setDni(String dni) { this.dni = dni; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }
    public void setTlf(String tlf) { this.tlf = tlf; }
    public void setEmail(String email) { this.email = email; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public void setIdVoluntario(int idVoluntario) { this.idVoluntario = idVoluntario; }


    @Override
    public String toString() {
        return dni + ", " + nombre + ", " + apellido1 + ", " + apellido2 + ", " + tlf + ", " + email + ", " + edad + ", " + localidad;
    }
    
    

}
