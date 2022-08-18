package com.digitalEvent.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalEvent.spring.datajpa.model.TypeEvent;
/**
 * Clase repositorio de tipo de evento 
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
public interface TypeEventRepository extends JpaRepository<TypeEvent, String> {
}
