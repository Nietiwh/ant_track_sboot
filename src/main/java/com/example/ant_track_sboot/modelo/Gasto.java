package com.example.ant_track_sboot.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;



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

    /* 
    @Enumerated(EnumType.STRING) //viene de un ENUM datos fijos donde puede elegir, pero julian ya hizo la clase
    private CategoriaEnum categoria;  // falta relacionarla
*/


    @ManyToOne  //un usuario tiene muchos gastos
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @ManyToOne // gastos tiene una forma de pago(aunque se prodia decir que es many to many) 
    @JoinColumn(name = "fk_metodoPago", referencedColumnName = "id")
    private MetodoPago metodoPago; // se debe relacionar con la Clase MetodoPago.

    @ManyToOne //a una categoria pertnecen muchos gastos
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @ManyToOne // a un comercio pertenece mucgos gastos (aunque puede pagar en varios comercios)
    @JoinColumn(name = "fk_comercio")
    private Comercio comercio;

    
    //Constructor vacio
    public Gasto() {
    }

    //Constructor full
    public Gasto(Long id, String descripcion, Double valor, LocalDateTime fecha, Categoria categoria,
            MetodoPago metodoPago, String observaciones, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
        this.categoria = categoria;
        this.metodoPago = metodoPago;
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

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;  
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

   public MetodoPago getMetodoPago() {
    return metodoPago;
   }
       
}
