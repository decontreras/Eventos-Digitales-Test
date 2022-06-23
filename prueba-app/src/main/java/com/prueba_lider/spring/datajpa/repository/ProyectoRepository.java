package com.prueba_lider.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_lider.spring.datajpa.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
