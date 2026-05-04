package com.example.ant_track_sboot.modelo;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import com.example.ant_track_sboot.modelo.utils.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(nullable = false, length = 20)
    private String documento;

    @Column(nullable = false)
    private Integer edad;

    private String genero;

    @Column(nullable = false, unique = true)
    private String correo;

    private String contacto;

    @Column(nullable = false)
    private BigDecimal presupMensual;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    // 🔐 PASSWORD
    @Column(nullable = true)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<MetodoPago> metodosPago;

    // GETTERS Y SETTERS

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public BigDecimal getPresupMensual() { return presupMensual; }
    public void setPresupMensual(BigDecimal presupMensual) { this.presupMensual = presupMensual; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}