package com.mateus.sistema.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Cidade;
import com.mateus.sistema.domain.Endereco;
import com.mateus.sistema.domain.Estado;
import com.mateus.sistema.domain.Pais;
import com.mateus.sistema.repository.CidadeRepository;
import com.mateus.sistema.repository.EnderecoRepository;
import com.mateus.sistema.repository.EstadoRepository;
import com.mateus.sistema.repository.PaisRepository;

@Service
public class DBService {
	@Autowired
	private PaisRepository paisRepo;
	@Autowired 
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired 
	private EnderecoRepository enderecoRepo;
	
	
	public void instantiateTestDatabase() {
		Pais pais = new Pais(null, "Brasil", "10", "BR");
		paisRepo.saveAll(Arrays.asList(pais));
		
		Estado estado1 = new Estado(null, "Ceara", "11", "CE", pais);
		Estado estado2 = new Estado(null, "Pernanbuco", "12", "PE", pais);
		estadoRepo.saveAll(Arrays.asList(estado1, estado2));
				
		Cidade cidade1 = new Cidade(null, "Forataleza", "12345", estado1);
		Cidade cidade2 = new Cidade(null, "Sobral", "64548", estado1);
		Cidade cidade3 = new Cidade(null, "Recife", "32548", estado2);
		cidadeRepo.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Endereco endereco1 = new Endereco(null, "Gaspar Lemos", "275", "60440530", "casa", "Pici", cidade1);
		Endereco endereco2 = new Endereco(null, "Rua A", "111", "11111111", "casa", "Bairro A", cidade2);
		Endereco endereco3 = new Endereco(null, "Rua B", "222", "22222222", "apt", "Bairro B", cidade3);
		Endereco endereco4 = new Endereco(null, "Rua C", "333", "33333333", "", "Bairro C", cidade1);
		enderecoRepo.saveAll(Arrays.asList(endereco1, endereco2, endereco3, endereco4));
		
	}
}
