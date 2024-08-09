package org.test02JAVAEEIJGZ.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.test02JAVAEEIJGZ.modelos.ProductoIJGZ;
import org.test02JAVAEEIJGZ.repositorios.IProductoIJGZRepository;
import org.test02JAVAEEIJGZ.servicios.interfaces.IProductoIJGZService;

@Service
public class ProductoIJGZService implements IProductoIJGZService{

    @Autowired
    private IProductoIJGZRepository productoIJGZRepository;

    @Override
    public Page<ProductoIJGZ> buscarTodosPaginados(Pageable pageable) {
        return productoIJGZRepository.findAll(pageable);
    }

    @Override
    public List<ProductoIJGZ> obtenerTodos() {
        return productoIJGZRepository.findAll();
    }

    @Override
    public Optional<ProductoIJGZ> buscarPorId(Integer id) {
        return productoIJGZRepository.findById(id);
    }

    @Override
    public ProductoIJGZ crearOEditar(ProductoIJGZ productoIJGZ) {
        return productoIJGZRepository.save(productoIJGZ);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoIJGZRepository.deleteById(id);
    }

}
