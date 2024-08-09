package org.test02JAVAEEIJGZ.modelos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
