package com.example.ant_track_sboot.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ant_track_sboot.modelo.Usuario;
import com.example.ant_track_sboot.repositorio.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // CREAR USUARIO
    public Usuario guardar_usuario(Usuario datos){

        if(datos.getNombre() == null || datos.getNombre().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre obligatorio");
        }

        if(datos.getPassword() == null || datos.getPassword().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password obligatorio");
        }

        datos.setPassword(passwordEncoder.encode(datos.getPassword()));

        return usuarioRepositorio.save(datos);
    }

    // LISTAR
    public List<Usuario> buscarTodos(){
        return usuarioRepositorio.findAll();
    }

    // BUSCAR
    public Usuario buscarPorId(Integer id){
        return usuarioRepositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no existe"));
    }

    // EDITAR
    public Usuario editar(Integer id, Usuario datos){

        Usuario u = buscarPorId(id);

        u.setNombre(datos.getNombre());
        u.setCorreo(datos.getCorreo());
        u.setDocumento(datos.getDocumento());

        // actualizar password solo si viene
        if(datos.getPassword() != null && !datos.getPassword().isBlank()){
            u.setPassword(passwordEncoder.encode(datos.getPassword()));
        }

        return usuarioRepositorio.save(u);
    }

    // ELIMINAR
    public boolean eliminar_usuario(Integer id){

        if(!usuarioRepositorio.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe");
        }

        usuarioRepositorio.deleteById(id);
        return true;
    }

    // LOGIN
    public Usuario login(String correo, String password){

        Usuario usuario = usuarioRepositorio.findByCorreo(correo)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if(usuario.getPassword() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe crear contraseña");
        }

        if(!passwordEncoder.matches(password, usuario.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password incorrecto");
        }

        return usuario;
    }
}