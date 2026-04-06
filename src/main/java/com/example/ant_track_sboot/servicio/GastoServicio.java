package com.example.ant_track_sboot.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ant_track_sboot.modelo.Categoria;
import com.example.ant_track_sboot.modelo.Gasto;
import com.example.ant_track_sboot.repositorio.IGastoRepositorio;

@Service
public class GastoServicio {

    private final IGastoRepositorio gastoRepositorio;
    public GastoServicio gastoServicio;

    //implementacion
     //inyeccion CONSTRUCTOR
    public GastoServicio(IGastoRepositorio gastoRepositorio) {
        this.gastoRepositorio = gastoRepositorio;
    }
     // 4. BUSCAR TODOS
   
    public List<Gasto> buscarTodos() {
        return gastoRepositorio.findAll();
    }

    // 1. GUARDAR
   
    public Gasto guardar(Gasto gasto) {
        return gastoRepositorio.save(gasto);
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


    

