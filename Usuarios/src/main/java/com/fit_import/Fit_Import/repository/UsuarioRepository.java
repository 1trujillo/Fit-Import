package com.fit_import.Fit_Import.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fit_import.Fit_Import.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
