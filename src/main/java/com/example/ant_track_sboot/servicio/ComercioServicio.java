package com.example.ant_track_sboot.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ant_track_sboot.repositorio.IComercioRepositorio;


@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio comercioRepositorio;

    public ComercioServicio(IComercioRepositorio comercioRepositorio) {
        this.comercioRepositorio = comercioRepositorio;
    }

    

    //SERVICIO PARA GUARDAR USUARIO
    //SERVICIO PARA LISTAR TODOS LOS USUARIOS EN BD
    //SERVICIO PARA ELIMINAR UN USUARIO EN BD
    // SERVICIO PARA MODIFICAR UN USUARIO EN BD
    // SERVICIO PARA BUSCAR UN USUARIO POR ID EN BD


}
