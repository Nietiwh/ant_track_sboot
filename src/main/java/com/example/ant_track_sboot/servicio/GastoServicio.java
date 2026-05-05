package com.example.ant_track_sboot.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ant_track_sboot.DTO.GastoDTO;
import com.example.ant_track_sboot.modelo.Categoria;
import com.example.ant_track_sboot.modelo.Comercio;
import com.example.ant_track_sboot.modelo.Gasto;
import com.example.ant_track_sboot.modelo.MetodoPago;
import com.example.ant_track_sboot.modelo.Usuario;
import com.example.ant_track_sboot.repositorio.IGastoRepositorio;

@Service
public class GastoServicio {

    private IGastoRepositorio gastoRepositorio;
    private final CategoriaServicio categoriaServicio;
    private final MetodoPagoServicio metodoPagoServicio;
    private final ComercioServicio comercioServicio;
    private final UsuarioServicio usuarioServicio;

  
 
    public GastoServicio(
        IGastoRepositorio gastoRepositorio,
        CategoriaServicio categoriaServicio,
        MetodoPagoServicio metodoPagoServicio,
        ComercioServicio comercioServicio,
        UsuarioServicio usuarioServicio
    ) {
        this.gastoRepositorio = gastoRepositorio;
        this.categoriaServicio = categoriaServicio;
        this.metodoPagoServicio = metodoPagoServicio;
        this.comercioServicio = comercioServicio;
        this.usuarioServicio = usuarioServicio;
    }
     

    //1. 1 guardar validadando gasto

    public Gasto guardarGasto(GastoDTO dto){ 

         //parametros con ID para que haga la tabal solo con id, no con objetos

        Categoria categoria = categoriaServicio.buscarPorId(dto.categoriaId);
        MetodoPago metodoPago = metodoPagoServicio.buscarPorId(dto.metodoPagoId);
        Comercio comercio = comercioServicio.buscar_comercio_id(dto.comercioId);
        Usuario usuario = usuarioServicio.buscarPorId(dto.usuarioId);

        if(dto.getDescripcion() == null || dto.getDescripcion().isBlank() 
            || dto.getDescripcion().isEmpty() ){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "la descripcion e necesaria"
            );
            
        }

        //validando numero
        if(dto.getValor() == null || dto.getValor() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "debe se un numero, no letras y mayor que 0"
            );
        }

        Gasto gasto = new Gasto(
            dto.descripcion,
            dto.valor,
            categoria,
            metodoPago,
            comercio,
            usuario
        );


    return gastoRepositorio.save(gasto);
        

    }

    // 2. BUSCAR TODOS
   
    public List<Gasto> buscarTodos() {
        return gastoRepositorio.findAll();
    }

    // 3. BUSCAR POR ID
     
    public Gasto buscarPorId(Long id) {
        
        Optional<Gasto> gasto = gastoRepositorio.findById(id);
       
        if (!gasto.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "no existe el gasto buscado"
            );
        }
        return gasto.get(); //funcion del optional

       
    }

    // 4. BUSCAR POR ATRIBUTO (nombre parcial)
   
    public List<Gasto> buscarPorNombre(String nombre) {
        return gastoRepositorio.findByDescripcionContaining(nombre);
    }

  

    // 5. EDITAR
   
    public Gasto editar(Long id, Gasto gastoActualizado) {

        Optional<Gasto> gasto = gastoRepositorio.findById(id);
       
        if (!gasto.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "no existe el gasto buscado"
            );
        }


        Gasto gastoExistente = gasto.get();

        gastoExistente.setDescripcion(gastoActualizado.getDescripcion());
        gastoExistente.setValor(gastoActualizado.getValor());
          

        return gastoRepositorio.save(gastoExistente);
    }

    // 6. ELIMINAR solo para desarrollo
  
    public void eliminar(Long id) {
        Gasto gasto = buscarPorId(id);
        gastoRepositorio.delete(gasto);
    }
}


    

