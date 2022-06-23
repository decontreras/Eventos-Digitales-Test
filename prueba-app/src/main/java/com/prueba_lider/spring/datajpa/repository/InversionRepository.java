package com.prueba_lider.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba_lider.spring.datajpa.model.Inversiones;

public interface InversionRepository extends JpaRepository<Inversiones, Long> {
}
