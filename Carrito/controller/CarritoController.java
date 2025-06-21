package com.fit_import.Fit_Import.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fit_import.Fit_Import.model.CarritoItem;
import com.fit_import.Fit_Import.service.CarritoService;
import com.fit_import.Fit_Import.service.ProductoService;

@RestController
@RequestMapping("Api/Carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ProductoService productoService;

    @PostMapping("/agregar/{productoId}")
    public ResponseEntity<String> agregarProducto(@PathVariable Long productoId, @RequestParam int cantidad) {
        return productoService.obtenerProductoPorId(productoId).map(producto -> {
            carritoService.agrgarProducto(producto, cantidad);
            return ResponseEntity.ok("Producto agregado al carrito.");
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CarritoItem> verCarrito() {
        return carritoService.listarItems();
    }

    @DeleteMapping("/eliminar/{productoId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long productoId) {
        carritoService.eliminarProducto(productoId);
        return ResponseEntity.ok("Producto eliminado del carrito.");
    }

    @DeleteMapping("/vaciar")
    public ResponseEntity<String> vaciar() {
        carritoService.vaciarCarrito();
        return ResponseEntity.ok("Carrito vaciado.");
    }


}
