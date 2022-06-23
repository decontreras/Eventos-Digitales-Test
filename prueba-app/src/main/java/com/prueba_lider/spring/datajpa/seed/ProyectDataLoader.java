package com.prueba_lider.spring.datajpa.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba_lider.spring.datajpa.model.Proyecto;
import com.prueba_lider.spring.datajpa.repository.ProyectoRepository;

@Component
public class ProyectDataLoader implements CommandLineRunner {
	
	@Autowired
	ProyectoRepository proyectoRepository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
	}

	private void loadUserData() {
		if (proyectoRepository.count() == 0) {
			Proyecto proye = new Proyecto("Default", (double) 2500000, true);
			proyectoRepository.save(proye);
		}
		System.out.println(proyectoRepository.count());
	}

}