package com.fit_import.fit_import;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit_import.Fit_Import.controller.ProductoController;
import com.fit_import.Fit_Import.model.Producto;
import com.fit_import.Fit_Import.service.ProductoService;
import com.github.javafaker.Faker;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    private Producto producto;
    private Faker faker;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        faker = new Faker();
        objectMapper = new ObjectMapper();

        producto = new Producto();
        producto.setId(1L);
        producto.setNombre(faker.commerce().productName());
        producto.setDescripcion(faker.lorem().sentence());
        producto.setCategoria("Test");
        producto.setPrecio(50.0);
        producto.setCantidad(10);
    }

    @Test
    void testObtenerPorId() throws Exception {
        when(productoService.obtenerProductoPorId(1L)).thenReturn(Optional.of(producto));

        mockMvc.perform(get("/inventario/productos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value(producto.getNombre()));
    }

    @Test
    void testObtenerPorIdNoExiste() throws Exception {
        when(productoService.obtenerProductoPorId(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/inventario/productos/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCrearProducto() throws Exception {
        when(productoService.crearProducto(any(Producto.class))).thenReturn(producto);

        mockMvc.perform(post("/inventario/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value(producto.getNombre()));
    }

    @Test
    void testActualizarProducto() throws Exception {
        when(productoService.actualizaProducto(eq(1L), any(Producto.class))).thenReturn(producto);

        mockMvc.perform(put("/inventario/productos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value(producto.getNombre()));
    }

    @Test
    void testActualizarProductoNoEncontrado() throws Exception {
        when(productoService.actualizaProducto(eq(1L), any(Producto.class))).thenReturn(null);

        mockMvc.perform(put("/inventario/productos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testEliminarProducto() throws Exception {
        doNothing().when(productoService).eliminarProducto(1L);

        mockMvc.perform(delete("/inventario/productos/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testObtenerTodos() throws Exception {
        when(productoService.obtenerTodosLosProductos()).thenReturn(Arrays.asList(producto));

        mockMvc.perform(get("/inventario/productos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value(producto.getNombre()));
    }
}
