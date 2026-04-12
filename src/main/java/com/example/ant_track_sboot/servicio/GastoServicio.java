package com.example.ant_track_sboot.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ant_track_sboot.modelo.Gasto;
import com.example.ant_track_sboot.repositorio.IGastoRepositorio;

@Service
public class GastoServicio {

    @Autowired  //conecta la interface con el servicio
    private IGastoRepositorio gastoRepositorio;
  

    //implementacion
     //inyeccion CONSTRUCTOR
    public GastoServicio(IGastoRepositorio gastoRepositorio) {
        this.gastoRepositorio = gastoRepositorio;
    }
     // 1. BUSCAR TODOS
   
    public List<Gasto> buscarTodos() {
        return gastoRepositorio.findAll();
    }

    // 1. GUARDAR
   
    public Gasto guardar(Gasto gasto) {
        return gastoRepositorio.save(gasto);
    }

    // 2. BUSCAR POR ID
     //indica que este método viene de la interfaz.
    public Gasto buscarPorId(Long id) {
        return gastoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
    }

    // 3. BUSCAR POR ATRIBUTO (nombre parcial)
   
    public List<Gasto> buscarPorNombre(String nombre) {
        return gastoRepositorio.findByDescripcionContaining(nombre);
    }

  

    // 5. EDITAR
   
    public Gasto editar(Long id, Gasto gastoActualizado) {
        Gasto gastoExistente = buscarPorId(id);

        gastoExistente.setDescripcion(gastoActualizado.getDescripcion());
        gastoExistente.setValor(gastoActualizado.getValor());
        gastoExistente.setFecha(gastoActualizado.getFecha());
       

        return gastoRepositorio.save(gastoExistente);
    }

    // 6. ELIMINAR
  
    public void eliminar(Long id) {
        Gasto gasto = buscarPorId(id);
        gastoRepositorio.delete(gasto);
    }
}


    

