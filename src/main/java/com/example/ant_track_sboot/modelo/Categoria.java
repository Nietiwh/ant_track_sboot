package com.example.ant_track_sboot.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Entity
@Table(name="categorias")

public class Categoria {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, length = 100)
   private String nombre;

   @Column(length = 250)
   private String descripcion;

   @Column(nullable = false)
   private double presupuestoMaximoMensual;

   @Column(nullable = false)
   private double gastoMensual;

   @Column(nullable = false)
   private boolean esNecesaria;

   @Column(nullable = false)
   private boolean alertaActiva;

   @Column(nullable = false)
   private int prioridad;

   @Column(nullable = false)
   private boolean activa;

   @Column(nullable = false)
   private LocalDateTime fechaCreacion;


   public Categoria(){

   }


   public Categoria(String nombre, String descripcion, double presupuestoMaximoMensual, boolean esNecesaria, Integer prioridad) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.presupuestoMaximoMensual = presupuestoMaximoMensual;
    this.esNecesaria = esNecesaria;
    this.prioridad = 1;
    this.gastoMensual = 0;
    this.alertaActiva = false;
    this.activa = true;
    this.fechaCreacion = LocalDateTime.now();
   }


   public Long getId() {
    return id;
   }


   public String getNombre() {
    return nombre;
   }


   public String getDescripcion() {
    return descripcion;
   }


   public double getPresupuestoMaximoMensual() {
    return presupuestoMaximoMensual;
   }


   public double getGastoMensual() {
    return gastoMensual;
   }


   public boolean isEsNecesaria() {
    return esNecesaria;
   }


   public boolean isAlertaActiva() {
    return alertaActiva;
   }


   public Integer getPrioridad() {
    return prioridad;
   }


   public boolean isActiva() {
    return activa;
   }


   public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
   }


   public void setNombre(String nombre) {
    this.nombre = nombre;
   }


   public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
   }


   public void setPresupuestoMaximoMensual(double presupuestoMaximoMensual) {
    this.presupuestoMaximoMensual = presupuestoMaximoMensual;
   }

   
   
   








}