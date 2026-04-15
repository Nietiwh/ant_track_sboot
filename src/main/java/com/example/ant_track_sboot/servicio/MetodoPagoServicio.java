
package com.example.ant_track_sboot.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ant_track_sboot.modelo.MetodoPago;
import com.example.ant_track_sboot.modelo.utils.Estados;
import com.example.ant_track_sboot.modelo.utils.Franquicia;
import com.example.ant_track_sboot.modelo.utils.MedioPago;
import com.example.ant_track_sboot.repositorio.IMetodoPagoRepositorio;


@Service
public class MetodoPagoServicio {

    @Autowired // Inyección de dependencia del repositorio
    private IMetodoPagoRepositorio repositorio; 

    // Aquí puedes agregar métodos para manejar la lógica de negocio relacionada con los métodos de pago
    // Servicio para guardar un nuevo método de pago
    // Servicio para actualizar un método de pago existente
    // Servicio para eliminar un método de pago por su ID
    // Servicio para buscar un método de pago por su ID
    // Servicio para listar todos los métodos de pago

    // 1. GUARDAR un nuevo método de pago
    public MetodoPago guardar(MetodoPago metodoPago) {
        // Aquí puedes agregar validaciones o lógica adicional antes de guardar el método de pago
        if (metodoPago.getDescripcion() == null || metodoPago.getDescripcion().isEmpty()  
            || metodoPago.getDescripcion().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "La descripción del método de pago no puede estar vacía");
        }   // HttpStatus.BAD_REQUEST se utiliza para indicar que la solicitud del cliente es incorrecta 
            // o no cumple con los requisitos necesarios para ser procesada por el servidor. 
            // En este caso, se lanza esta excepción cuando la descripción del método de pago es nula,
            // vacía o solo contiene espacios en blanco, lo que no es válido para un método de pago.
        
            // Aquí también podrías agregar validaciones para otros campos, como id, formaPago, 
            // franquicia, estado.
         
            //Despues de las validaciones, se guarda el método de pago utilizando el repositorio y se 
            // devuelve el objeto guardado.
        return repositorio.save(metodoPago);   
    }

    // 2. BUSCAR POR ID
    public MetodoPago buscarPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Método de pago no encontrado con ID: " + id));
    }

    // 3. LISTAR TODOS los métodos de pago
    public List<MetodoPago> listarTodos() {
        return repositorio.findAll();
    }

    // 4. EDITAR un método de pago existente
    public MetodoPago editar(Long id, MetodoPago metodoPagoActualizado) {
        MetodoPago metodoPagoExistente = buscarPorId(id);

        metodoPagoExistente.setFormaPago(metodoPagoActualizado.getFormaPago());
        metodoPagoExistente.setFranquicia(metodoPagoActualizado.getFranquicia());
        metodoPagoExistente.setEstado(metodoPagoActualizado.getEstado());
        metodoPagoExistente.setDescripcion(metodoPagoActualizado.getDescripcion());
        metodoPagoExistente.setUsuario(metodoPagoActualizado.getUsuario());

        return repositorio.save(metodoPagoExistente);
    }

    // 5. ELIMINAR un método de pago por su ID
    public void eliminar(Long id) {
        MetodoPago metodoPago = buscarPorId(id);
        repositorio.delete(metodoPago);
    }

    // 6. BUSCAR POR DESCRIPCIÓN EXACTA
    public List<MetodoPago> buscarPorDescripcion(String descripcion) {
        return repositorio.findByDescripcion(descripcion);
    }

    // 7. BUSCAR POR DESCRIPCIÓN QUE CONTENGA UN TEXTO
    public List<MetodoPago> buscarPorDescripcionContaining(String descripcion) {
        return repositorio.findByDescripcionContaining(descripcion);
    }

    // 8. BUSCAR POR ESTADO (ACTIVO / INACTIVO)
    public List<MetodoPago> buscarPorEstado(Estados estado) {
        return repositorio.findByEstado(estado.name());
    }

    // 9. BUSCAR POR FRANQUICIA
    public List<MetodoPago> buscarPorFranquicia(Franquicia franquicia) {
        return repositorio.findByFranquicia(franquicia.name());
    }

    // 10. BUSCAR POR FORMA DE PAGO
    public List<MetodoPago> buscarPorFormaPago(MedioPago formaPago) {
        return repositorio.findByFormaPago(formaPago.name());
    }
}

