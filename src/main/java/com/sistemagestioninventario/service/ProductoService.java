
package com.sistemagestioninventario.service;

import com.sistemagestioninventario.model.Producto;
import com.sistemagestioninventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No existe un producto con ID: " + id));
    }

    @Transactional(readOnly = true)
    public Producto buscarPorCodigo(String codigo) {
        return productoRepository.findByCodigo(codigo)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No existe un producto con código: " + codigo));
    }

    public Producto registrarProducto(Producto producto) {
        if (productoRepository.findByCodigo(producto.getCodigo()).isPresent()) {
            throw new IllegalArgumentException(
                    "Ya existe un producto con ese código");
        }

        producto.setId(null);
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto datos) {
        Producto existente = buscarPorId(id);

        productoRepository.findByCodigo(datos.getCodigo())
                .filter(p -> !p.getId().equals(id))
                .ifPresent(p -> {
                    throw new IllegalArgumentException(
                            "El código ya pertenece a otro producto");
                });

        existente.setCodigo(datos.getCodigo());
        existente.setNombre(datos.getNombre());
        existente.setCategoria(datos.getCategoria());
        existente.setPrecio(datos.getPrecio());
        existente.setStock(datos.getStock());
        existente.setStockMinimo(datos.getStockMinimo());

        return productoRepository.save(existente);
    }

    public void eliminarProducto(Long id) {
        Producto producto = buscarPorId(id);
        productoRepository.delete(producto);
    }

    @Transactional(readOnly = true)
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Transactional(readOnly = true)
    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoriaIgnoreCase(categoria);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarStockBajo() {
        return productoRepository.findByStockLessThanEqual(
                Integer.MAX_VALUE
        ).stream()
         .filter(p -> p.getStock() <= p.getStockMinimo())
         .toList();
    }
}
