package com.prueba_lider.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_lider.spring.datajpa.model.Usuarios;
/**
 * Clase repositorio tipo usuario 
 *
 * @version 	23/06/2022
 * @author 	Daniel Contreras
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findByNameContaining(String name);
}
