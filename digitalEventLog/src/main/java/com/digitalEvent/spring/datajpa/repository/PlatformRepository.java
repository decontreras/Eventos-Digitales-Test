package com.digitalEvent.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalEvent.spring.datajpa.model.Platform;
/**
 * Clase repositorio tipo plataforma 
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
