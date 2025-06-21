package com.fit_import.Fit_Import.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fit_import.Fit_Import.model.CarritoItem;
import com.fit_import.Fit_Import.model.Producto;

@Service
public class CarritoService {
    private Map<Long, CarritoItem> carrito = new HashMap<>();

    public List<CarritoItem> listarItems() {
        return new ArrayList<>(carrito.values());
    }

    public void agrgarProducto(Producto producto, int cantidad){
        if (carrito.containsKey(producto.getId())) {
            CarritoItem itemExistente = carrito.get(producto.getId());
            itemExistente.setCantidad(itemExistente.getCantidad() + cantidad);
        } else {
            CarritoItem nuevoItem = new CarritoItem(producto, cantidad);
            carrito.put(producto.getId(), nuevoItem);
        }
    }

    public void eliminarProducto(Long productoId) {
        carrito.remove(productoId);
    }

    public void vaciarCarrito() {
        carrito.clear();
    }








}
