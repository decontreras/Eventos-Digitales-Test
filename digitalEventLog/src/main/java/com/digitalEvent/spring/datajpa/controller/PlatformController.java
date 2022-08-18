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

import com.digitalEvent.spring.datajpa.model.Platform;
import com.digitalEvent.spring.datajpa.repository.PlatformRepository;

/**
 * Controlador para la consulta de plataformas
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PlatformController {

	@Autowired
	PlatformRepository platformRepository;
	
	/**
	 * Método para la consulta de plataformas
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/platforms")
	public ResponseEntity<?> getPlatforms() {
		try {
			List<Platform> platforms = new ArrayList<Platform>();

			platformRepository.findAll().forEach(platforms::add);

			if (platforms.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(platforms, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

}
