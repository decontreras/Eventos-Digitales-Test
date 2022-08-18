package com.digitalEvent.spring.datajpa.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digitalEvent.spring.datajpa.model.TypeEvent;
import com.digitalEvent.spring.datajpa.repository.TypeEventRepository;

/**
 * Clase seed de tipo de evento para crear registros por defecto 
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@Component
public class TypeEventDataLoader implements CommandLineRunner {
	
	@Autowired
	TypeEventRepository typeEventRepository;

	@Override
	public void run(String... args) throws Exception {
		loadTypeEventData();
	}
	
	/**
	 * Método para crear plataformas por defecto
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	private void loadTypeEventData() {
		if (typeEventRepository.count() == 0) {
			TypeEvent typeEvent = new TypeEvent("F001", "Consulta de información bursátil", 20.5);
			typeEventRepository.save(typeEvent);
			typeEvent = new TypeEvent("F002", "Emisión de título valor", 200.0);
			typeEventRepository.save(typeEvent);
			typeEvent = new TypeEvent("F003", "Generación de reportes operativos", 55.9);
			typeEventRepository.save(typeEvent);
			typeEvent = new TypeEvent("F004", "Custodia de título valor", 100.0);
			typeEventRepository.save(typeEvent);
			typeEvent = new TypeEvent("F005", "Complementación de operación", 32.0);
			typeEventRepository.save(typeEvent);
		}
		System.out.println(typeEventRepository.count());
	}

}