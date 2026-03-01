//Le digo a Java dónde vive este archivo dentro del proyecto.
package com.example.ant_track_sboot.modelo;

//trayendo las herramientas que vamos a usar
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;


@Entity //le dice a spring:esta clase es una tabla en la base de datos

@Table(name="categorias")//le dice como se llama la tabla para que no ponga el nombre por defecto

public class Categoria {

   @Id // este campo es la llave primaria, el identificador único de cada fila
   @GeneratedValue(strategy = GenerationType.IDENTITY)//el número lo genera automáticamente la base de datos
   private Long id;

   @Column(nullable = false, length = 100)//configura cómo es esa columna en la BD, el nullable que el campo sea obligatorio
   private String nombre;

   @Column(length = 250)
   private String descripcion;

   @Column(nullable = false)// el usuario define cuanto quiere gastar, en decimal 
   private double presupuestoMaximoMensual;

   @Column(nullable = false)// lo que el usuario vaya gastandp . lo comenzamos con 0.0 y el sistema lo actualiza
   private double gastoMensual;

   @Column(nullable = false)// para pregunatr al ususario si la compra es necesaria o no
   private boolean esNecesaria;

   @Column(nullable = false)
   private boolean alertaActiva;// para que seactive en caso de que el gasto este llegqando al presupuesto, el clinete no lo toca

   @Column(nullable = false)//un numero para asignar que tan importante es la categoria, lo asignas el sisitema, comienza en 1
   private int prioridad;

   @Column(nullable = false)//sirve para desactivar una categoria , sin que afecte a la base de datos, es como esconder el registro
   private boolean activa;

   @Column(nullable = false)//gaurada fecha y hora de cuando se crea
   private LocalDateTime fechaCreacion;

    //constructor vacio, jpa lo usa para crear internamente los objetos
   public Categoria(){

   }

   //Este es el constructor que se usa cuando el usuario crea una categoría. Solo recibe los 4 datos que el usuario escribe.
   //  Todo lo demás lo asigna el sistema automáticamente
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

   //creamos los get , la ventana para poder ver el valor del atributo fuera de la clase
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

   //los set, para modificar datos desde afuera, solo tenemos 3 porque son los que cambia el usuario,despues de crear la categoria
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