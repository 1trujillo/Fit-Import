package com.fit_import.Fit_Import.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends org.springframework.data.jpa.repository.JpaRepository<com.fit_import.Fit_Import.model.Producto, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario


}
