package com.example.ant_track_sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ant_track_sboot.modelo.MetodoPago;
import com.example.ant_track_sboot.servicio.MetodoPagoServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ant_track_sboot/metodoPago")
// Inyectar el servicio de MetodoPago
// Implementar los métodos para manejar las solicitudes HTTP (GET, POST,
// PUT, DELETE)
public class MetodoPagoControlador {

    @Autowired
    private MetodoPagoServicio metodoPagoServicio;
    // Para cada servicio ofrecido por el controlador se debe programar una función
    // Esa funcion recibira las peticiones del pedido y respondera con el
    // resultado de la operacion solicitada.
    // Función controladora del servicio de guardar un nuevo método de pago

    @PostMapping
    public ResponseEntity<?> controladorGuardarMetodoPago(@RequestBody MetodoPago datos) {
        return ResponseEntity.status(HttpStatus.OK).body(metodoPagoServicio.guardar(datos));
    };

    // Función controladora del servicio de listar todos los métodos de pago

    @GetMapping
    public ResponseEntity<?> controladorListarTodosMetodosPago() {
        return ResponseEntity.status(HttpStatus.OK).body(metodoPagoServicio.listarTodos());
    }
}
