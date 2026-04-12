
package com.example.ant_track_sboot.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ant_track_sboot.modelo.MetodoPago;
import com.example.ant_track_sboot.modelo.utils.Estados;
import com.example.ant_track_sboot.modelo.utils.Franquicia;
import com.example.ant_track_sboot.modelo.utils.MedioPago;
import com.example.ant_track_sboot.repositorio.IMetodoPagoRepositorio;


@Service
public class MetodoPagoServicio {

    @Autowired // Inyección de dependencia del repositorio
    IMetodoPagoRepositorio repositorio;

    // Aquí puedes agregar métodos para manejar la lógica de negocio relacionada con los métodos de pago
    //Servicio para guardar un nuevo método de pago
    //Servicio para actualizar un método de pago existente
    //Servicio para eliminar un método de pago por su ID
    //Servicio para buscar un método de pago por su ID
    //Servicio para listar todos los métodos de pago

    // 1. GUARDAR un nuevo método de pago
    public MetodoPago guardar(MetodoPago metodoPago) {
        return repositorio.save(metodoPago);
    }

    // 2. BUSCAR POR ID
    public MetodoPago buscarPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado con ID: " + id));
    }

    // 3. LISTAR TODOS los métodos de pago
    public List<MetodoPago> buscarTodos() {
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

