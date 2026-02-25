package com.example.ant_track_sboot.modelo;

import java.time.LocalDate;

import jakarta.annotation.Generated;
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
private String nit;
private String nombre_comercio;
private String actividad;
private String contacto;
private String direccion;
private String barrio;
private String ciudad;
private LocalDate fecha_creacion;
private String horario_atencion;


/*Creacion de get and set de cada dato */
public Comercio() {
}
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
public String getNombre_comercio() {
    return nombre_comercio;
}
public void setNombre_comercio(String nombre_comercio) {
    this.nombre_comercio = nombre_comercio;
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
public LocalDate getFecha_creacion() {
    return fecha_creacion;
}
public void setFecha_creacion(LocalDate fecha_creacion) {
    this.fecha_creacion = fecha_creacion;
}
public String getHorario_atencion() {
    return horario_atencion;
}
public void setHorario_atencion(String horario_atencion) {
    this.horario_atencion = horario_atencion;
}


}
