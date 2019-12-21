package com.mateus.sistema.resources.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.services.produto.GrupoService;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoResource {
	@Autowired 
	private GrupoService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Grupo> find(@PathVariable Long id){
		Grupo obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Grupo>> findAll() {
		List<Grupo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
