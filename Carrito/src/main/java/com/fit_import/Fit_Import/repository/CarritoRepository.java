package com.fit_import.Fit_Import.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fit_import.Fit_Import.model.CarritoItem;

public interface CarritoRepository extends JpaRepository<CarritoItem, Long> {
}