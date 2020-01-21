package com.mateus.sistema.resources.produto;

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

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.subgrupo.GrupoDTO;
import com.mateus.sistema.dto.response.produto.GrupoResponseDTO;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody GrupoDTO objDto){
		Grupo obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@Valid @RequestBody GrupoDTO objDto, @PathVariable Long id){
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GrupoResponseDTO>> findAll() {
		List<Grupo> list = service.findAll();
		List<GrupoResponseDTO> listDTO = list.stream().map(obj -> new GrupoResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
