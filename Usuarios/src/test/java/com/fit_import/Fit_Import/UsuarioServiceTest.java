package com.fit_import.fit_import;

import com.fit_import.Fit_Import.model.Usuario;
import com.fit_import.Fit_Import.repository.UsuarioRepository;
import com.fit_import.Fit_Import.service.UsuarioService;
import com.github.javafaker.Faker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Faker faker;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        faker = new Faker();

        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre(faker.name().firstName());
        usuario.setApellido(faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        // Agrega más atributos según tu modelo
    }

    @Test
    void testGuardarUsuario() {
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario guardado = usuarioService.guardar(usuario);

        assertNotNull(guardado);
        assertEquals(usuario.getNombre(), guardado.getNombre());
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void testBuscarPorId_Existe() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(usuario.getEmail(), resultado.get().getEmail());
    }

    @Test
    void testBuscarPorId_NoExiste() {
        when(usuarioRepository.findById(2L)).thenReturn(Optional.empty());

        Optional<Usuario> resultado = usuarioService.buscarPorId(2L);

        assertFalse(resultado.isPresent());
    }

    @Test
    void testListarTodos() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        List<Usuario> lista = usuarioService.listarTodos();

        assertEquals(1, lista.size());
        verify(usuarioRepository).findAll();
    }
}

