package com.example.ant_track_sboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ant_track_sboot.modelo.Usuario;

/**
 * Repositorio para la entidad Usuario.
 * Proporciona métodos CRUD automáticos gracias a JpaRepository.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    // No es necesario agregar métodos aquí a menos que necesites consultas personalizadas (Query Methods)
}
