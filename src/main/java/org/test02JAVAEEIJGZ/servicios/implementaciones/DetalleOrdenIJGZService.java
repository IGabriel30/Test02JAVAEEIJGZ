package org.test02JAVAEEIJGZ.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.test02JAVAEEIJGZ.modelos.DetalleOrdenIJGZ;
import org.test02JAVAEEIJGZ.repositorios.IDetalleOrdenIJGZRepository;
import org.test02JAVAEEIJGZ.servicios.interfaces.IDetalleOrdenIJGZService;

@Service
public class DetalleOrdenIJGZService implements IDetalleOrdenIJGZService {
     @Autowired
    private IDetalleOrdenIJGZRepository detalleOrdenIJGZRepository;

    @Override
    public Page<DetalleOrdenIJGZ> buscarTodosPaginados(Pageable pageable) {
        return detalleOrdenIJGZRepository.findAll(pageable);
    }

    @Override
    public List<DetalleOrdenIJGZ> obtenerTodos() {
        return detalleOrdenIJGZRepository.findAll();
    }

    @Override
    public DetalleOrdenIJGZ buscarPorId(Long id) {
        Optional<DetalleOrdenIJGZ> detalleOrdenOptional = detalleOrdenIJGZRepository.findById(id);
        if (detalleOrdenOptional.isPresent()) {
            return detalleOrdenOptional.get();
        } else {
            throw new RuntimeException("Detalle de Orden no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public DetalleOrdenIJGZ crearOEditar(DetalleOrdenIJGZ detalleOrdenIJGZ) {
        return detalleOrdenIJGZRepository.save(detalleOrdenIJGZ);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (detalleOrdenIJGZRepository.existsById(id)) {
            detalleOrdenIJGZRepository.deleteById(id);
        } else {
            throw new RuntimeException("Detalle de Orden no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
