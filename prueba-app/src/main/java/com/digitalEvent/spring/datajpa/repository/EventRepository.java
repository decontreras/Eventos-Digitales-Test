package com.prueba_lider.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_lider.spring.datajpa.model.Inversiones;
/**
 * Clase repositorio tipo inversión 
 *
 * @version 	23/06/2022
 * @author 	Daniel Contreras
 */
public interface InversionRepository extends JpaRepository<Inversiones, Long> {
}
