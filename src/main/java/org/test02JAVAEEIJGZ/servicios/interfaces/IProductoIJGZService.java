package org.test02JAVAEEIJGZ.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.test02JAVAEEIJGZ.modelos.ProductoIJGZ;

public interface IProductoIJGZService {
    Page<ProductoIJGZ> buscarTodosPaginados(Pageable pageable);

    List<ProductoIJGZ> obtenerTodos();

    Optional<ProductoIJGZ> buscarPorId(Integer id);

    ProductoIJGZ crearOEditar(ProductoIJGZ productoIJGZ);

    void eliminarPorId(Integer id);
}
