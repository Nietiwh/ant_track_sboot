package com.example.ant_track_sboot.modelo;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToMany;
import com.example.ant_track_sboot.modelo.utils.TipoDocumento;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "documento", nullable = false, length = 20)
    private String documento;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "genero", length = 20)
    private String genero;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "contacto", length = 20)
    private String contacto;

    @Column(name = "presup_mensual", nullable = false)
    private BigDecimal presupMensual;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    @OneToMany(mappedBy = "usuario")
    private List<MetodoPago> metodosPago;


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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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

    public BigDecimal getPresupMensual() {
        return presupMensual;
    }

    public void setPresupMensual(BigDecimal presupMensual) {
        this.presupMensual = presupMensual;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }
}



