package com.example.ant_track_sboot.modelo;

import java.time.LocalDate;

public class Usuario {

    private Integer id;
    private String nombres;
    private String tipoDocumente;
    private String documento;
    private Integer edad; 
    private boolean genero;
    private String correo;
    private String contacto;
    private float presupMensual;
    private LocalDate fechaRegistro;

    
    public Usuario() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getTipoDocumente() {
        return tipoDocumente;
    }


    public void setTipoDocumente(String tipoDocumente) {
        this.tipoDocumente = tipoDocumente;
    }


    public String getDocumento() {
        return documento;
    }


    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public Integer getEdad() {
        return edad;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public boolean isGenero() {
        return genero;
    }


    public void setGenero(boolean genero) {
        this.genero = genero;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getContacto() {
        return contacto;
    }


    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    public float getPresupMensual() {
        return presupMensual;
    }


    public void setPresupMensual(float presupMensual) {
        this.presupMensual = presupMensual;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    


}
