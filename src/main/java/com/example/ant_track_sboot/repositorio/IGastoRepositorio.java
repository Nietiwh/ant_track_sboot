package com.example.ant_track_sboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ant_track_sboot.modelo.Gasto;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface IGastoRepositorio extends JpaRepository<Gasto, Long >{

    //implemanta todo el  crud clasico

    //buscar por nombre de gasto que contengan(esperamos una lista)

    List<Gasto> findByDescripcion(String descripcion);

    

    // estoe  spara buscar por una sola cosa Optional<Gasto> findByDocumento(String documento);
    
    //buscar por nombre de gasto que contengan(esperamos una lista)

    List<Gasto> findByDescripcionContaining(String descripcion);

    List<Gasto> findByUsuarioId(Long idUsuario);


     // ─────────────────────────────────────────────
    // 1. Gastos de un usuario en un rango de fechas
    //    Uso: base para el resumen mensual
    // ─────────────────────────────────────────────
    List<Gasto> findByUsuarioIdAndFechaBetween(
            Long usuarioId,
            LocalDateTime inicio,
            LocalDateTime fin
    );

    // ─────────────────────────────────────────────
    // 2. Gasto total agrupado por Categoria
    //    Uso: gráfico de pie / barras por categoría
    //    Retorna: Object[] { Categoria, Double suma }
    // ─────────────────────────────────────────────
    @Query("SELECT g.categoria, SUM(g.valor) " +
           "FROM Gasto g " +
           "WHERE g.usuario.id = :usuarioId " +
           "AND g.fecha BETWEEN :inicio AND :fin " +
           "GROUP BY g.categoria")
    List<Object[]> findGastoAgrupadoPorCategoria(
            @Param("usuarioId") Long usuarioId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    // ─────────────────────────────────────────────
    // 3. Gasto total agrupado por mes en un año
    //    Uso: gráfico de línea o barras anual
    //    Retorna: Object[] { Integer mes, Double suma }
    // ─────────────────────────────────────────────
    @Query("SELECT MONTH(g.fecha), SUM(g.valor) " +
           "FROM Gasto g " +
           "WHERE g.usuario.id = :usuarioId " +
           "AND YEAR(g.fecha) = :anio " +
           "GROUP BY MONTH(g.fecha) " +
           "ORDER BY MONTH(g.fecha) ASC")
    List<Object[]> findGastoAgrupadoPorMes(
            @Param("usuarioId") Long usuarioId,
            @Param("anio") int anio
    );

    // ─────────────────────────────────────────────
    // 4. Gasto total agrupado por MetodoPago
    //    Uso: gráfico de pie por método de pago
    //    Retorna: Object[] { MetodoPago, Double suma }
    // ─────────────────────────────────────────────
    @Query("SELECT g.metodoPago, SUM(g.valor) " +
           "FROM Gasto g " +
           "WHERE g.usuario.id = :usuarioId " +
           "AND g.fecha BETWEEN :inicio AND :fin " +
           "GROUP BY g.metodoPago")
    List<Object[]> findGastoAgrupadoPorMetodoPago(
            @Param("usuarioId") Long usuarioId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    // ─────────────────────────────────────────────
    // 5. Gasto total agrupado por Comercio
    //    Uso: top comercios donde más gasta
    //    Retorna: Object[] { Comercio, Double suma }
    //    Ordenado de mayor a menor
    // ─────────────────────────────────────────────
    @Query("SELECT g.comercio, SUM(g.valor) " +
           "FROM Gasto g " +
           "WHERE g.usuario.id = :usuarioId " +
           "AND g.fecha BETWEEN :inicio AND :fin " +
           "GROUP BY g.comercio " +
           "ORDER BY SUM(g.valor) DESC")
    List<Object[]> findGastoAgrupadoPorComercio(
            @Param("usuarioId") Long usuarioId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    


    

    //buscar por cantidad

    
}
