package com.fit_import.Fit_Import.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit_import.Fit_Import.model.Producto;
import com.fit_import.Fit_Import.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizaProducto(long id, Producto productoActualizado){
        return productoRepository.findById(id).map(producto -> {
                producto.setNombre(productoActualizado.getNombre());
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setCategoria(productoActualizado.getCategoria());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setCantidad(productoActualizado.getCantidad());
                return productoRepository.save(producto);
            })
            .orElse(null);
    }
    
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> obtenerTodosLosProductos() {
    return productoRepository.findAll();
}



}
