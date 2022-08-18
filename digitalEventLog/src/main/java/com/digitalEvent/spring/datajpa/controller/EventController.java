package com.digitalEvent.spring.datajpa.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.digitalEvent.spring.datajpa.DTO.EventDTO;
import com.digitalEvent.spring.datajpa.model.Event;
import com.digitalEvent.spring.datajpa.model.Platform;
import com.digitalEvent.spring.datajpa.model.TypeEvent;
import com.digitalEvent.spring.datajpa.repository.EventRepository;
import com.digitalEvent.spring.datajpa.repository.PlatformRepository;
import com.digitalEvent.spring.datajpa.repository.TypeEventRepository;

/**
 * Controlador para la gestión de eventos
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	TypeEventRepository typeEventRepository;
	
	@Autowired
	PlatformRepository platformRepository;

	/**
	 * Método para la consulta de eventos
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {
		try {
			List<Event> events = new ArrayList<Event>();

			eventRepository.findAll().forEach(events::add);

			if (events.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(events, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Método para la consulta de eventos por id
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
		Optional<Event> events = eventRepository.findById(id);

		if (events.isPresent()) {
			return new ResponseEntity<>(events.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método para la creación de eventos
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@PostMapping("/events")
	public ResponseEntity<?> createEvent(@RequestBody EventDTO event) {
		try {
			Optional<Platform> platform = platformRepository.findById(event.getPlatform_id());
			Optional<TypeEvent> typeEvent = typeEventRepository.findById(event.getEvent_id());
			Event _event = eventRepository
					.save(new Event(typeEvent.get(), platform.get(), event.getQuantity(), event.getAmount(), event.getDate()));
			return new ResponseEntity<>(_event, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Método para la edición de eventos
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@PutMapping("/events/{id}")
	public ResponseEntity<?> editEvent(@RequestBody EventDTO event, @PathVariable("id") Long id) {
		try {
			Optional<Platform> platform = platformRepository.findById(event.getPlatform_id());
			Optional<TypeEvent> typeEvent = typeEventRepository.findById(event.getEvent_id());
			Optional<Event> _event_optional = eventRepository.findById(id);
			Event _event = _event_optional.get();
			_event.setAmount(event.getAmount());
			_event.setEvent(typeEvent.get());
			_event.setPlatform(platform.get());
			_event.setQuantity(event.getQuantity());
			_event.setDate(event.getDate());
			_event = eventRepository.save(_event);
			return new ResponseEntity<>(_event, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Método para la eliminación de eventos por id
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	@DeleteMapping("/events/{id}")
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") Long id) {
		try {
			eventRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
