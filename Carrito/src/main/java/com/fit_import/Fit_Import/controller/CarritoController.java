package com.fit_import.Fit_Import.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fit_import.Fit_Import.model.CarritoItem;
import com.fit_import.Fit_Import.service.CarritoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
@Tag(name = "Carrito Controller", description = "Operaciones relacionadas con el carrito de compras")
public class CarritoController {

    private final CarritoService carritoService;

    @Operation(summary = "Agregar un nuevo ítem al carrito", 
               description = "Crea un nuevo CarritoItem y lo guarda en la base de datos")
    @ApiResponse(responseCode = "200", description = "Ítem agregado exitosamente")
    @PostMapping
    public ResponseEntity<CarritoItem> agregar(@RequestBody CarritoItem item) {
        return ResponseEntity.ok(carritoService.agregar(item));
    }

    @Operation(summary = "Listar todos los ítems del carrito", 
               description = "Devuelve una lista con todos los ítems actuales del carrito")
    @ApiResponse(responseCode = "200", description = "Lista devuelta correctamente")
    @GetMapping
    public List<CarritoItem> listar() {
        return carritoService.listarTodo();
    }

    @Operation(summary = "Obtener un ítem por su ID", 
               description = "Busca un ítem del carrito según su ID")
    @ApiResponse(responseCode = "200", description = "Ítem encontrado")
    @ApiResponse(responseCode = "404", description = "Ítem no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<CarritoItem> obtener(@PathVariable Long id) {
        return carritoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un ítem del carrito", 
               description = "Elimina el ítem correspondiente al ID especificado")
    @ApiResponse(responseCode = "204", description = "Ítem eliminado exitosamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        carritoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
