package com.prueba_lider.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba_lider.spring.datajpa.model.Proyecto;
import com.prueba_lider.spring.datajpa.repository.ProyectoRepository;

/**
 * Controlador para la gesión de proyectos
 *
 * @version 	23/06/2022
 * @author 	Daniel Contreras
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoRepository proyectoRepository;
	
	/**
	 * Método para la consulta de proyectos
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/proyectos")
	public ResponseEntity<?> getProyectos() {
		try {
			List<Proyecto> proyectos = new ArrayList<Proyecto>();

			proyectoRepository.findAll().forEach(proyectos::add);

			if (proyectos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(proyectos, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

}
