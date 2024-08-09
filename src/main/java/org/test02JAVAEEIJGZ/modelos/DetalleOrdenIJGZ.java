package org.test02JAVAEEIJGZ.modelos;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detallesOrdenesIJGZ")
public class DetalleOrdenIJGZ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productoIJGZ_id")
    private ProductoIJGZ productoIJGZ;

    @ManyToOne
    @JoinColumn(name = "ordenIJGZ_id")
    private OrdenIJGZ ordenIJGZ;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidadIJGZ;

    @NotNull(message = "El precio es requerido")
    private BigDecimal precioIJGZ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoIJGZ getProductoIJGZ() {
        return productoIJGZ;
    }

    public void setProductoIJGZ(ProductoIJGZ productoIJGZ) {
        this.productoIJGZ = productoIJGZ;
    }

    public OrdenIJGZ getOrdenIJGZ() {
        return ordenIJGZ;
    }

    public void setOrdenIJGZ(OrdenIJGZ ordenIJGZ) {
        this.ordenIJGZ = ordenIJGZ;
    }

    public Integer getCantidadIJGZ() {
        return cantidadIJGZ;
    }

    public void setCantidadIJGZ(Integer cantidadIJGZ) {
        this.cantidadIJGZ = cantidadIJGZ;
    }

    public BigDecimal getPrecioIJGZ() {
        return precioIJGZ;
    }

    public void setPrecioIJGZ(BigDecimal precioIJGZ) {
        this.precioIJGZ = precioIJGZ;
    }
}
