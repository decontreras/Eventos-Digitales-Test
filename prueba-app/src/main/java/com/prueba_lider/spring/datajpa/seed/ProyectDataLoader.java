package com.prueba_lider.spring.datajpa.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba_lider.spring.datajpa.model.Proyecto;
import com.prueba_lider.spring.datajpa.repository.ProyectoRepository;
/**
 * Clase seed tipo proyecto para crear registros por defecto 
 *
 * @version 	23/06/2022
 * @author 	Daniel Contreras
 */
@Component
public class ProyectDataLoader implements CommandLineRunner {
	
	@Autowired
	ProyectoRepository proyectoRepository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
	}
	
	/**
	 * Método para crear proyecto por defecto
	 *
	 * @version 	23/06/2022
	 * @author 	Daniel Contreras
	 */
	private void loadUserData() {
		if (proyectoRepository.count() == 0) {
			Proyecto proye = new Proyecto("Default", (double) 2500000, true);
			proyectoRepository.save(proye);
		}
		System.out.println(proyectoRepository.count());
	}

}