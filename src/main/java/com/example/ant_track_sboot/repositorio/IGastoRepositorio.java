package com.example.ant_track_sboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ant_track_sboot.modelo.Gasto;
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

    


    

    //buscar por cantidad

    
}
