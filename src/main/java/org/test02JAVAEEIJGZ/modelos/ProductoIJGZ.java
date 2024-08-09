package org.test02JAVAEEIJGZ.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "productosIJGZ")
public class ProductoIJGZ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido.")
    private String nombreIJGZ;

     @OneToMany(mappedBy = "productosIJGZ", cascade = CascadeType.ALL)
    private List<DetalleOrdenIJGZ> detallesOrdenIJGZ;


    public List<DetalleOrdenIJGZ> getDetallesOrdenIJGZ() {
        return detallesOrdenIJGZ;
    }

    public void setDetallesOrdenIJGZ(List<DetalleOrdenIJGZ> detallesOrdenIJGZ) {
        this.detallesOrdenIJGZ = detallesOrdenIJGZ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreIJGZ() {
        return nombreIJGZ;
    }

    public void setNombreIJGZ(String nombreIJGZ) {
        this.nombreIJGZ = nombreIJGZ;
    }
}
