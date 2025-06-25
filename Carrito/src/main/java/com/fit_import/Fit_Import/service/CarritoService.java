package com.fit_import.Fit_Import.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fit_import.Fit_Import.model.CarritoItem;
import com.fit_import.Fit_Import.repository.CarritoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Crea constructor con final fields
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoItem agregar(CarritoItem item) {
        return carritoRepository.save(item);
    }

    public List<CarritoItem> listarTodo() {
        return carritoRepository.findAll();
    }

    public Optional<CarritoItem> buscarPorId(Long id) {
        return carritoRepository.findById(id);
    }

    public void eliminar(Long id) {
        carritoRepository.deleteById(id);
    }
}
