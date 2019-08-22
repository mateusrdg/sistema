package com.mateus.sistema.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Estado;
import com.mateus.sistema.domain.Pais;
import com.mateus.sistema.repository.EstadoRepository;
import com.mateus.sistema.repository.PaisRepository;

@Service
public class DBService {
	@Autowired
	private PaisRepository paisRepo;
	
	@Autowired 
	private EstadoRepository EstadoRepo;
	
	public void instantiateTestDatabase() {
		Pais pais = new Pais(null, "Brasil", "10", "BR");
		paisRepo.saveAll(Arrays.asList(pais));
		
		Estado estado1 = new Estado(null, "Ceara", "11", "CE", pais);
		Estado estado2 = new Estado(null, "Pernanbuco", "12", "PE", pais);
				
		EstadoRepo.saveAll(Arrays.asList(estado1, estado2));
		
	}
}
