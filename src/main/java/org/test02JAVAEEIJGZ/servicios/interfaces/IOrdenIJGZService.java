package org.test02JAVAEEIJGZ.servicios.interfaces;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.test02JAVAEEIJGZ.modelos.OrdenIJGZ;

public interface IOrdenIJGZService {
    Page<OrdenIJGZ> buscarTodosPaginados(Pageable pageable);

    List<OrdenIJGZ> obtenerTodos();

    Optional<OrdenIJGZ> buscarPorId(Long id);

    OrdenIJGZ crearOEditar(OrdenIJGZ marca);

    void eliminarPorId(Long id);
}
