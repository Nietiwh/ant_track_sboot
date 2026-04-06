package com.example.ant_track_sboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ant_track_sboot.modelo.Gasto;

@Repository
public interface IGastoRepositorio extends JpaRepository<Gasto, Long >{

    //implemanta todo el  crud
    
}
