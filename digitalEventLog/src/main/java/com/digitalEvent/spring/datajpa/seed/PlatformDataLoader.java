package com.digitalEvent.spring.datajpa.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digitalEvent.spring.datajpa.model.Platform;
import com.digitalEvent.spring.datajpa.repository.PlatformRepository;
/**
 * Clase seed tipo plataforma para crear registros por defecto 
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@Component
public class PlatformDataLoader implements CommandLineRunner {
	
	@Autowired
	PlatformRepository platformRepository;

	@Override
	public void run(String... args) throws Exception {
		loadPlatformData();
	}
	
	/**
	 * Método para crear plataformas por defecto
	 *
	 * @version 	17/08/2022
	 * @author 	Daniel Contreras
	 */
	private void loadPlatformData() {
		if (platformRepository.count() == 0) {
			Platform platform = new Platform("PACTO", "Plataforma de generación de pagarés.");
			platformRepository.save(platform);
			platform = new Platform("DEPO", "Plataforma de bóveda de valores.");
			platformRepository.save(platform);
			platform = new Platform("BAKO", "Plataforma de backoffice.");
			platformRepository.save(platform);
			platform = new Platform("PLATGI", "Plataforma digital.");
			platformRepository.save(platform);
		}
		System.out.println(platformRepository.count());
	}

}