package com.example.ant_track_sboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ant_track_sboot.modelo.Gasto;

public interface GastoRepositorio extends JpaRepository<Gasto, Long >{

    //implemanta todo el  crud
    
}
