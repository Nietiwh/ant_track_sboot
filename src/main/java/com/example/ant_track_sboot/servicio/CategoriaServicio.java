package com.example.ant_track_sboot.servicio;

import com.example.ant_track_sboot.modelo.Categoria;
import com.example.ant_track_sboot.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //le dice a Spring que esta clase es un servicio.
public class CategoriaServicio{

    @Autowired //anotación para inyección de dependencias.
    private CategoriaRepositorio categoriaRepositorio;

    //inyeccion CONSTRUCTOR
    public CategoriaServicio(CategoriaRepositorio categoriaRepository) {
        this.categoriaRepositorio = categoriaRepository;
    }

    // 4. BUSCAR TODOS
   
    public List<Categoria> buscarTodos() {
        return categoriaRepositorio.findAll();
    }

    // 1. GUARDAR
   
    public Categoria guardar(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    // 2. BUSCAR POR ID
     //indica que este método viene de la interfaz.
    public Categoria buscarPorId(Long id) {
        return categoriaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
    }

    // 3. BUSCAR POR ATRIBUTO (nombre parcial)
   /* 
    public List<Categoria> buscarPorNombre(String nombre) {
        return categoriaRepositorio.findByNombreContaining(nombre);
    }*/

  

    // 5. EDITAR
   
    public Categoria editar(Long id, Categoria categoriaActualizada) {
        Categoria categoriaExistente = buscarPorId(id);

        categoriaExistente.setNombre(categoriaActualizada.getNombre());
        categoriaExistente.setDescripcion(categoriaActualizada.getDescripcion());
        categoriaExistente.setPresupuestoMaximoMensual(categoriaActualizada.getPresupuestoMaximoMensual());
        categoriaExistente.setEsNecesaria(categoriaActualizada.isEsNecesaria());
        categoriaExistente.setPrioridad(categoriaActualizada.getPrioridad());
        categoriaExistente.setActiva(categoriaActualizada.isActiva());
        categoriaExistente.setAlertaActiva(categoriaActualizada.isAlertaActiva());
        categoriaExistente.setGastoMensual(categoriaActualizada.getGastoMensual());

        return categoriaRepositorio.save(categoriaExistente);
    }

    // 6. ELIMINAR
  
    public void eliminar(Long id) {
        Categoria categoria = buscarPorId(id);
        categoriaRepositorio.delete(categoria);
    }
}