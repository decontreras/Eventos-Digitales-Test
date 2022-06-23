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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba_lider.spring.datajpa.DTO.inversionDTO;
import com.prueba_lider.spring.datajpa.model.Inversiones;
import com.prueba_lider.spring.datajpa.model.Usuarios;
import com.prueba_lider.spring.datajpa.model.Proyecto;
import com.prueba_lider.spring.datajpa.repository.InversionRepository;
import com.prueba_lider.spring.datajpa.repository.ProyectoRepository;
import com.prueba_lider.spring.datajpa.repository.UsuariosRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InversionController {

	@Autowired
	InversionRepository inversionRepository;

	@Autowired
	UsuariosRepository UsuariosRepository;
	
	@Autowired
	ProyectoRepository proyectoRepository;

	@GetMapping("/inversiones")
	public ResponseEntity<List<Inversiones>> getAllInversiones() {
		try {
			List<Inversiones> inversiones = new ArrayList<Inversiones>();

			inversionRepository.findAll().forEach(inversiones::add);

			if (inversiones.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(inversiones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/inversiones/{id}")
	public ResponseEntity<Inversiones> getInversionById(@PathVariable("id") Long id) {
		Optional<Inversiones> inversionData = inversionRepository.findById(id);

		if (inversionData.isPresent()) {
			return new ResponseEntity<>(inversionData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/inversiones")
	public ResponseEntity<?> createInversion(@RequestBody inversionDTO inversion) {
		try {
			Optional<Proyecto> proyectData = proyectoRepository.findById(inversion.getProyect_id());
			if (!proyectData.get().getState()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El proyecto se encuentra cerrado");
			}
			Optional<Usuarios> usuarioData = UsuariosRepository.findById(inversion.getUser_id());
			double porcentInvest = (inversion.getAmount() * 100)/usuarioData.get().getMonthlyIncome();
			if ((usuarioData.get().isComplete() && porcentInvest > 25) || (!usuarioData.get().isComplete() && porcentInvest > 20)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(usuarioData.get().isComplete() ? 
								"Como inversionista completo, puede invertir maximo 25% de sus ingresos mensuales" : 
									"Como inversionista basico, puede invertir maximo 20% de sus ingresos mensuales");
			}
			List<Inversiones> inversiones = new ArrayList<Inversiones>();
			inversionRepository.findAll().forEach(inversiones::add);
			double totalRecaudo = inversiones.stream().mapToDouble(o -> o.getProyeto().getId() == proyectData.get().getId() ?  o.getAmount() : 0).sum();
			double faltante = proyectData.get().getRequest() - totalRecaudo;
			if (inversion.getAmount() > faltante) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("El monto a invertir excede la caacidad de recaudo del Proyecto, el monto maximo que uede invertir es, $" + faltante);
			}
			Inversiones _inversion = inversionRepository
					.save(new Inversiones(usuarioData.get(), proyectData.get(), inversion.getAmount()));
			if (totalRecaudo + inversion.getAmount() == proyectData.get().getRequest()) {
				Proyecto _proyecto = proyectData.get();
				_proyecto.setState(false);
				proyectoRepository.save(_proyecto);
			}
			return new ResponseEntity<>(_inversion, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/inversiones/{id}")
	public ResponseEntity<HttpStatus> deleteInversion(@PathVariable("id") Long id) {
		try {
			inversionRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/inversiones")
	public ResponseEntity<HttpStatus> deleteAllInversiones() {
		try {
			inversionRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
