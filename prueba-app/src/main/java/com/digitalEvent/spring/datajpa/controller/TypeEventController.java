package com.prueba_lider.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba_lider.spring.datajpa.model.Usuarios;
import com.prueba_lider.spring.datajpa.repository.UsuariosRepository;

/**
 * Controlador para la gestión de usuarios
 *
 * @version 	23/06/2022
 * @author 	Daniel Contreras
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UsuariosController {

	@Autowired
	UsuariosRepository UsuariosRepository;
	
	/**
	 * Método para la consulta de usuarios
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuarios>> getAllUsuarios(@RequestParam(required = false) String name) {
		try {
			List<Usuarios> usuarios = new ArrayList<Usuarios>();

			if (name == null)
				UsuariosRepository.findAll().forEach(usuarios::add);
			else
				UsuariosRepository.findByNameContaining(name).forEach(usuarios::add);

			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Método para la consulta de usuarios por id
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> getUsuarioById(@PathVariable("id") Long id) {
		Optional<Usuarios> usuarioData = UsuariosRepository.findById(id);

		if (usuarioData.isPresent()) {
			return new ResponseEntity<>(usuarioData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método para la creación de usuarios
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@PostMapping("/usuarios")
	public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios Usuarios) {
		try {
			Usuarios _usuario = UsuariosRepository
					.save(new Usuarios(Usuarios.getName(), Usuarios.getLastName(), Usuarios.isComplete(), (double) (Usuarios.isComplete() ? 8500000 : 4000000) ));
			return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Método para la modificación de usuarios
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> updateUsuario(@PathVariable("id") Long id, @RequestBody Usuarios Usuarios) {
		Optional<Usuarios> usuarioData = UsuariosRepository.findById(id);

		if (usuarioData.isPresent()) {
			Usuarios _usuario = usuarioData.get();
			_usuario.setName(Usuarios.getName());
			_usuario.setLastName(Usuarios.getLastName());
			_usuario.setComplete(Usuarios.isComplete());
			_usuario.setMonthlyIncome((double) (_usuario.isComplete() ? 8500000 : 4000000));
			return new ResponseEntity<>(UsuariosRepository.save(_usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método para la eliminación de usuarios por id
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") Long id) {
		try {
			UsuariosRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Método para la eliminación de usuarios
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	@DeleteMapping("/usuarios")
	public ResponseEntity<HttpStatus> deleteAllUsuarios() {
		try {
			UsuariosRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
