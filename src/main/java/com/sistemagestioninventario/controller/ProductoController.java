
package com.sistemagestioninventario.controller;

import com.sistemagestioninventario.model.Producto;
import com.sistemagestioninventario.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @GetMapping("/codigo/{codigo}")
    public Producto buscarPorCodigo(@PathVariable String codigo) {
        return productoService.buscarPorCodigo(codigo);
    }

    @GetMapping("/buscar")
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        return productoService.buscarPorNombre(nombre);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(
            @PathVariable String categoria) {
        return productoService.buscarPorCategoria(categoria);
    }

    @GetMapping("/stock-bajo")
    public List<Producto> listarStockBajo() {
        return productoService.listarStockBajo();
    }

    @PostMapping
    public ResponseEntity<Producto> registrarProducto(
            @Valid @RequestBody Producto producto) {
        Producto guardado = productoService.registrarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
