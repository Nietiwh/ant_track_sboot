package com.example.ant_track_sboot.servicio;

import com.example.ant_track_sboot.modelo.Usuario;
import com.example.ant_track_sboot.repositorio.IUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServicio {

    private final IUsuarioRepositorio usuarioRepositorio;

    // Inyección por constructor (Recomendado)
    // Eliminamos @Autowired del campo de arriba
    public UsuarioServicio(IUsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // LISTAR TODO
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepositorio.findAll();
    }

    // GUARDAR
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    // BUSCAR POR ID
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Integer id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    // EDITAR
    @Transactional
    public Usuario editar(Integer id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = buscarPorId(id);

        // Actualización de campos
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setTipoDocumento(usuarioActualizado.getTipoDocumento());
        usuarioExistente.setDocumento(usuarioActualizado.getDocumento());
        usuarioExistente.setEdad(usuarioActualizado.getEdad());
        usuarioExistente.setGenero(usuarioActualizado.getGenero());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        usuarioExistente.setContacto(usuarioActualizado.getContacto());
        usuarioExistente.setPresupMensual(usuarioActualizado.getPresupMensual());
        usuarioExistente.setFechaRegistro(usuarioActualizado.getFechaRegistro());
        usuarioExistente.setGastos(usuarioActualizado.getGastos());
        usuarioExistente.setMetodosPago(usuarioActualizado.getMetodosPago());

        return usuarioRepositorio.save(usuarioExistente);
    }

    // ELIMINAR
    @Transactional
    public void eliminar(Integer id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepositorio.delete(usuario);
    }
}
