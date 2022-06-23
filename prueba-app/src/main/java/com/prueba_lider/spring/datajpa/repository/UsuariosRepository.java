package com.prueba_lider.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_lider.spring.datajpa.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findByNameContaining(String name);
}
