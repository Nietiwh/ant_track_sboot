package com.example.ant_track_sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ant_track_sboot.modelo.Usuario;
import com.example.ant_track_sboot.servicio.UsuarioServicio;

@RestController
@RequestMapping("/anttrackapi/v1/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // CREAR USUARIO
    @PostMapping
    public ResponseEntity<Usuario> controladorGuardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            usuarioServicio.guardar_usuario(datos)
        );
    }

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<?> controladorListarTodo(){
        return ResponseEntity.ok(
            usuarioServicio.buscarTodos()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> controladorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(
            usuarioServicio.buscarPorId(id)
        );
    }

    // EDITAR USUARIO
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> controladorEditar(
            @PathVariable Integer id,
            @RequestBody Usuario datos){

        return ResponseEntity.ok(
            usuarioServicio.editar(id, datos)
        );
    }

    // ELIMINAR USUARIO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.ok(
            usuarioServicio.eliminar_usuario(id)
        );
    }

    // LOGIN (extra que te dejé en el servicio)
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(
            @RequestBody Usuario datos){

        return ResponseEntity.ok(
            usuarioServicio.login(datos.getCorreo(), datos.getPassword())
        );
    }
}