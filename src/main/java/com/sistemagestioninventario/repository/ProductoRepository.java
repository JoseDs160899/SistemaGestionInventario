
package com.sistemagestioninventario.repository;

import com.sistemagestioninventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByCodigo(String codigo);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaIgnoreCase(String categoria);

    @Query("SELECT p FROM Producto p WHERE p.stock <= p.stockMinimo")
    List<Producto> findProductosConStockBajo();
}
