package com.digitalEvent.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalEvent.spring.datajpa.model.TypeEvent;
import com.digitalEvent.spring.datajpa.repository.TypeEventRepository;


/**
 * Controlador para la consulta de tipos de eventos
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TypeEventController {

	@Autowired
	TypeEventRepository typeEventRepository;
	
	/**
	 * Método para la consulta de tipos de eventos
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/typeEvents")
	public ResponseEntity<List<TypeEvent>> getAllTypeEvents() {
		try {
			List<TypeEvent> typeEvents = new ArrayList<TypeEvent>();

			typeEventRepository.findAll().forEach(typeEvents::add);

			if (typeEvents.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(typeEvents, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
