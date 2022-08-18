package com.digitalEvent.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalEvent.spring.datajpa.model.Event;

/**
 * Clase repositorio tipo eventos 
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
