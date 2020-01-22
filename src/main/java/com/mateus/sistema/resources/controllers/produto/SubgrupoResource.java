package com.mateus.sistema.resources.controllers.produto;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.dto.produto.subgrupo.SubgrupoDTO;
import com.mateus.sistema.dto.response.produto.SubgrupoResponseDTO;
import com.mateus.sistema.services.produto.SubgrupoService;

@RestController
@RequestMapping(value = "/subgrupos")
public class SubgrupoResource {
	@Autowired 
	private SubgrupoService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<SubgrupoResponseDTO> find(@PathVariable Long id){
		Subgrupo obj = service.find(id);
		SubgrupoResponseDTO objDTO = new SubgrupoResponseDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SubgrupoDTO objDto){
		Subgrupo obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@Valid @RequestBody SubgrupoDTO objDto, @PathVariable Long id){
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SubgrupoResponseDTO>> findAll() {
		List<Subgrupo> list = service.findAll();
		List<SubgrupoResponseDTO> listDTO = list.stream().map(obj -> new SubgrupoResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
