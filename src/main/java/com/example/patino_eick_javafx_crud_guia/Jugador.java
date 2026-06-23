package com.example.patino_eick_javafx_crud_guia;

public class Jugador {

    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String posicion;
    private String piernaHabil;
    private String equipo;
    private String observaciones;

    public Jugador(int id, String cedula, String nombre, String apellido,
                   int edad, String correo, String posicion,
                   String piernaHabil, String equipo, String observaciones) {

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.posicion = posicion;
        this.piernaHabil = piernaHabil;
        this.equipo = equipo;
        this.observaciones = observaciones;
    }

    public Jugador() {
    }

    public int getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getPiernaHabil() {
        return piernaHabil;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setPiernaHabil(String piernaHabil) {
        this.piernaHabil = piernaHabil;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}