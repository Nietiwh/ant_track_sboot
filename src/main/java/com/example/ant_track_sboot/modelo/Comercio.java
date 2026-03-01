package com.example.ant_track_sboot.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotaciones para indicar que esta clase es una entidad y se mapea a una tabla en la base de datos
@Entity
@Table(name = "comercio")

public class Comercio {

/*Colocar Datos para tabla */    

@Id //anotacion id  para indicar que es la clave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY) // anotacion para indicar que el valor se genera automaticamente por la base de datos

private Integer id;

@Column(nullable = false, length = 30)
private String nit;

@Column(nullable = false, length = 100)
private String nombreComercio;

@Column(nullable = false, length = 100)
private String actividad;

@Column(nullable = false, length = 20)
private String contacto;

@Column(nullable = false, length = 150)
private String direccion;

@Column(nullable = false, length = 100)
private String barrio;

@Column(nullable = false, length = 100)
private String ciudad;

@Column(nullable = false)
private LocalDate fechaCreacion;

@Column(nullable = false, length = 100)
private String horarioAtencion;


/*Creacion de get and set de cada dato */

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNit() {
    return nit;
}

public void setNit(String nit) {
    this.nit = nit;
}

public String getNombreComercio() {
    return nombreComercio;
}

public void setNombreComercio(String nombreComercio) {
    this.nombreComercio = nombreComercio;
}

public String getActividad() {
    return actividad;
}

public void setActividad(String actividad) {
    this.actividad = actividad;
}

public String getContacto() {
    return contacto;
}

public void setContacto(String contacto) {
    this.contacto = contacto;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getBarrio() {
    return barrio;
}

public void setBarrio(String barrio) {
    this.barrio = barrio;
}

public String getCiudad() {
    return ciudad;
}

public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
}

public LocalDate getFechaCreacion() {
    return fechaCreacion;
}

public void setFechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
}

public String getHorarioAtencion() {
    return horarioAtencion;
}

public void setHorarioAtencion(String horarioAtencion) {
    this.horarioAtencion = horarioAtencion;
}


}
