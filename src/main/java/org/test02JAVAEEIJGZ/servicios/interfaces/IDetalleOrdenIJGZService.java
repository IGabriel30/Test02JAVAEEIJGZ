package org.test02JAVAEEIJGZ.servicios.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.test02JAVAEEIJGZ.modelos.DetalleOrdenIJGZ;

public interface IDetalleOrdenIJGZService {
    Page<DetalleOrdenIJGZ> buscarTodosPaginados(Pageable pageable);

    List<DetalleOrdenIJGZ> obtenerTodos();

    DetalleOrdenIJGZ buscarPorId(Long id);

    DetalleOrdenIJGZ crearOEditar(DetalleOrdenIJGZ detalleOrdenIJGZ);

    void eliminarPorId(Long id);
}   
