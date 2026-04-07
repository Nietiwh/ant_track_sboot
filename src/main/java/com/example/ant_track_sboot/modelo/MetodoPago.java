
package com.example.ant_track_sboot.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.example.ant_track_sboot.modelo.utils.Estados;
import com.example.ant_track_sboot.modelo.utils.Franquicia;
import com.example.ant_track_sboot.modelo.utils.MedioPago;

// Esta clase la trabaja Mafe H
// Datos: id, formaPago (efectivo, tarjeta), franquicia (Bancolombia, Davivienda), estado (activo/inactivo)
// descripcion(se refiere a una breve descripcion del metodo de pago, por ejemplo: 
// "Tarjeta de credito Visa").

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago", nullable = false)
    private MedioPago formaPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "franquicia", nullable = false)
    private Franquicia franquicia;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estados estado;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    // Relación MUCHOS a UNO con Usuario
    // Muchos métodos de pago pueden pertenecer a un solo usuario
    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    // Relación UNO a MUCHOS con Gasto (lado inverso)
    // Un método de pago puede usarse en muchos gastos
    @OneToMany(mappedBy = "metodoPago")
    private List<Gasto> gastos;



    //Constructor vacio
    public MetodoPago() {
    }

    //Constructor lleno 
    public MetodoPago(MedioPago formaPago, Franquicia franquicia,Estados estado, String descripcion, Usuario usuario) {
        this.formaPago = formaPago;
        this.franquicia = franquicia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedioPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(MedioPago formaPago) {
        this.formaPago = formaPago;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

}