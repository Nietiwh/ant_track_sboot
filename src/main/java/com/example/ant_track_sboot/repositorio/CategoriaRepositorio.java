package com.example.ant_track_sboot.repositorio;//Define el paquete donde está tu repositorio

import org.springframework.data.jpa.repository.JpaRepository;//Importa la interfaz JpaRepository de Spring Data JPA
import org.springframework.stereotype.Repository;//Importa la anotación @Repository.Marca la interfaz como un componente de Spring que maneja persistencia
import com.example.ant_track_sboot.modelo.Categoria;//Importa la entidad Categoria sobre la cual va a operar.
import java.util.List;//algunos métodos de consulta devuelven listas de categorías

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    // Buscar por nombre exacto
    Categoria findByNombre(String nombre);

    // Buscar por coincidencia parcial en el nombre
    List<Categoria> findByNombreContaining(String nombre);

    // Listar solo categorías activas
    List<Categoria> findByActivaTrue();

    // Filtrar por prioridad
    List<Categoria> findByPrioridad(int prioridad);

    // Filtrar categorías necesarias
    List<Categoria> findByEsNecesariaTrue();
}