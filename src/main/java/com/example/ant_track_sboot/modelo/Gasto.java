package com.example.ant_track_sboot.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gasto {

    @Id  // por primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable
    private Long id;

    @Column(name = "descripcion", length = 200) //Columna
    private String descripcion;

    @Column(name = "valor", nullable = false) //Columna obligatoria
    private double valor;
    
    @Column(name = "fecha_gasto", nullable = false ) //Columna obligatoria
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING) //viene de un ENUM datos fijos donde puede elegir, pero julian ya hizo la clase
    private CategoriaEnum categoria;  // falta relacionarla

    @Enumerated(EnumType.STRING) //viene de un ENUM datos fijos donde puede elegir, se deria de relacionar con Metodo de pago
    private MedioPago medioPago;

    @Column(name = "usuario", nullable = false) // se debe relacionar con la Clase Usuario.
    private Usuario usuario;

  
    //Constructor vacio
    public Gasto() {
    }

    //Constructor full
    public Gasto(Long id, String descripcion, Double valor, LocalDateTime fecha, CategoriaEnum categoria,
            MedioPago medioPago, String observaciones, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
        this.categoria = categoria;
        this.medioPago = medioPago;
        this.usuario = usuario;
    }


    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

 


    //GETTERS

    
    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    

  
       
}
