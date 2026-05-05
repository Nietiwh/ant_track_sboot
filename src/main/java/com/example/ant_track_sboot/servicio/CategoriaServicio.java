package com.example.ant_track_sboot.servicio;

import com.example.ant_track_sboot.modelo.Categoria;
import com.example.ant_track_sboot.repositorio.ICategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service //le dice a Spring que esta clase es un servicio.
public class CategoriaServicio{

    @Autowired //anotación para inyección de dependencias.
    private ICategoriaRepositorio categoriaRepositorio;

    //inyeccion CONSTRUCTOR
    public CategoriaServicio(ICategoriaRepositorio categoriaRepository) {
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
        Optional <Categoria> categoriaBuscar = categoriaRepositorio.findById(id);
        if(categoriaBuscar.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            return categoriaBuscar.get();
        }
    }

   
    // 5. EDITAR
   
    public Categoria editar(Long id, Categoria categoriaActualizada) {
        Categoria categoriaExistente = buscarPorId(id);

        categoriaExistente.setNombre(categoriaActualizada.getNombre());
        categoriaExistente.setDescripcion(categoriaActualizada.getDescripcion());
        categoriaExistente.setPresupuestoMaximoMensual(categoriaActualizada.getPresupuestoMaximoMensual());
        categoriaExistente.setGastoMensual(categoriaActualizada.getGastoMensual());

        return categoriaRepositorio.save(categoriaExistente);
    }

    // 6. ELIMINAR
  
    public boolean eliminar(Long id) {
     Optional<Categoria> categoriaBuscar = categoriaRepositorio.findById(id);
     if(categoriaBuscar.isPresent()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
     }else{
        categoriaRepositorio.deleteById(id);
        return true;
     }
    }
}