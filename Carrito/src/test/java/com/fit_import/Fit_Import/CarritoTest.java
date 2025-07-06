package com.fit_import.Fit_Import;

import com.fit_import.Fit_Import.model.CarritoItem;
import com.fit_import.Fit_Import.repository.CarritoRepository;
import com.fit_import.Fit_Import.service.CarritoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarritoServiceTest {

    @Mock
    private CarritoRepository carritoRepository;

    @InjectMocks
    private CarritoService carritoService;

    @Test
    void testAgregarItem() {
        CarritoItem item = new CarritoItem();
        item.setId(1L);
        item.setNombre("Mancuerna");
        item.setCantidad(2);
        item.setProductoId(1001L);
        item.setUsuarioId(501L);
        item.setFechaAgregado("2025-06-29");

        when(carritoRepository.save(item)).thenReturn(item);

        CarritoItem resultado = carritoService.agregar(item);

        assertNotNull(resultado);
        assertEquals("Mancuerna", resultado.getNombre());
        assertEquals(1001L, resultado.getProductoId());
        assertEquals(501L, resultado.getUsuarioId());
        assertEquals("2025-06-29", resultado.getFechaAgregado());
        verify(carritoRepository, times(1)).save(item);
    }

    @Test
    void testListarTodo() {
        CarritoItem item1 = new CarritoItem(1L, 2001L, 3, 501L, "2025-06-28", "Cuerda");
        CarritoItem item2 = new CarritoItem(2L, 2002L, 1, 502L, "2025-06-28", "Esterilla");

        when(carritoRepository.findAll()).thenReturn(List.of(item1, item2));

        List<CarritoItem> resultado = carritoService.listarTodo();

        assertEquals(2, resultado.size());
        assertEquals("Cuerda", resultado.get(0).getNombre());
        assertEquals("Esterilla", resultado.get(1).getNombre());
    }

    @Test
    void testBuscarPorIdExiste() {
        CarritoItem item = new CarritoItem(10L, 3001L, 5, 503L, "2025-06-28", "Bicicleta");

        when(carritoRepository.findById(10L)).thenReturn(Optional.of(item));

        Optional<CarritoItem> resultado = carritoService.buscarPorId(10L);

        assertTrue(resultado.isPresent());
        assertEquals("Bicicleta", resultado.get().getNombre());
        assertEquals(5, resultado.get().getCantidad());
    }

    @Test
    void testBuscarPorIdNoExiste() {
        when(carritoRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<CarritoItem> resultado = carritoService.buscarPorId(999L);

        assertFalse(resultado.isPresent());
    }

    @Test
    void testEliminar() {
        Long id = 5L;

        carritoService.eliminar(id);

        verify(carritoRepository, times(1)).deleteById(id);
    }
}
