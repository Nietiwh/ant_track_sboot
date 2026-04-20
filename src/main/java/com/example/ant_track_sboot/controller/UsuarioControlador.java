package com.example.ant_track_sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ant_track_sboot.modelo.Usuario;
import com.example.ant_track_sboot.servicio.UsuarioServicio;

@RestController
@RequestMapping("/neoappapi/v1/usuarios")
public class UsuarioControlador {

    //inyectar el servicio correspondiente
    @Autowired
    private UsuarioServicio servicio;


    //para cada servicio ofrecido se debe programar una funcion
    //esa funcion recibira las peticiones del pedido y respondera

    //funcion controladora del servicio de guardar usuario
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }

    //funcion controladora del servicio de listar todos los usuarios
    @GetMapping
    public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_usuario()
        );
    }
}
