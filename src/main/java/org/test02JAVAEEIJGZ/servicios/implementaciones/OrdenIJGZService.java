package org.test02JAVAEEIJGZ.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.test02JAVAEEIJGZ.modelos.OrdenIJGZ;
import org.test02JAVAEEIJGZ.repositorios.IOrdenIJGZRepository;
import org.test02JAVAEEIJGZ.servicios.interfaces.IOrdenIJGZService;

@Service
public class OrdenIJGZService implements IOrdenIJGZService {

    @Autowired
    private IOrdenIJGZRepository ordenIJGZRepository;

    @Override
    public Page<OrdenIJGZ> buscarTodosPaginados(Pageable pageable) {
        return ordenIJGZRepository.findAll(pageable);
    }

    @Override
    public List<OrdenIJGZ> obtenerTodos() {
        return ordenIJGZRepository.findAll();
    }

    @Override
    public Optional<OrdenIJGZ> buscarPorId(Long id) {
        return ordenIJGZRepository.findById(id);
    }

    @Override
    public OrdenIJGZ crearOEditar(OrdenIJGZ marca) {
        return ordenIJGZRepository.save(marca);
    }

    @Override
    public void eliminarPorId(Long id) {
        ordenIJGZRepository.deleteById(id);
    }

}
