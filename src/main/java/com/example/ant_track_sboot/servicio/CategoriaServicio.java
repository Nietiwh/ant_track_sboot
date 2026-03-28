package com.example.ant_track_sboot.servicio;

import com.example.ant_track_sboot.modelo.Categoria;
import java.util.List;

public interface CategoriaServicio {

    Categoria guardar(Categoria categoria);

    Categoria buscarPorId(Long id);

    List<Categoria> buscarPorNombre(String nombre);

    List<Categoria> buscarTodos();

    Categoria editar(Long id, Categoria categoriaActualizada);

    void eliminar(Long id);
}
