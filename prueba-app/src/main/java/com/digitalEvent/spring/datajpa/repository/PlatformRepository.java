package com.prueba_lider.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_lider.spring.datajpa.model.Proyecto;
/**
 * Clase repositorio tipo proyecto 
 *
 * @version 	23/06/2022
 * @author 	Daniel Contreras
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
