package com.mateus.sistema.resouces.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.services.produto.SubgrupoService;

@RestController
@RequestMapping(value = "/subgrupos")
public class SubgrupoResource {
	@Autowired 
	private SubgrupoService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Subgrupo> find(@PathVariable Long id){
		Subgrupo obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Subgrupo>> findAll() {
		List<Subgrupo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
