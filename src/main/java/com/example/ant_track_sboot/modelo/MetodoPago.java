
package com.example.ant_track_sboot.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Esta clase la trabaja Mafe H
//Datos: id, formaPago(efectivo, tarjeta), franquicia(bancolombia), estado(activo/inactivo),descripcion

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 50)
    private Long id;

    @Column(name = "forma_pago", nullable = false, length = 50)
    private String formaPago;

    @Column(name = "franquicia", nullable = false, length = 50)
    private String franquicia;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;


    public MetodoPago() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFormaPago() {
        return formaPago;
    }


    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }


    public String getFranquicia() {
        return franquicia;
    }


    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
