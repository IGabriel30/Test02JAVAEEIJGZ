package org.test02JAVAEEIJGZ.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "ordenIJGZ")
public class OrdenIJGZ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "La fecha no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIJGZ;

    @OneToMany(mappedBy = "ordenIJGZ", cascade = CascadeType.ALL)
    private List<DetalleOrdenIJGZ> detallesOrdenIJGZ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaIJGZ() {
        return fechaIJGZ;
    }

    public void setFechaIJGZ(LocalDate fechaIJGZ) {
        this.fechaIJGZ = fechaIJGZ;
    }

    public List<DetalleOrdenIJGZ> getDetallesOrdenIJGZ() {
        return detallesOrdenIJGZ;
    }

    public void setDetallesOrdenIJGZ(List<DetalleOrdenIJGZ> detallesOrdenIJGZ) {
        this.detallesOrdenIJGZ = detallesOrdenIJGZ;
    }
}
