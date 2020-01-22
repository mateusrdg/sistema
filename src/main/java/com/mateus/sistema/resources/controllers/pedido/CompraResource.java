package com.mateus.sistema.resources.controllers.pedido;

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

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pedido.compra.CompraDTO;
import com.mateus.sistema.dto.response.pedido.compra.CompraResponseDTO;
import com.mateus.sistema.services.pedido.compra.CompraService;

@RestController
@RequestMapping(value = "/compras")
public class CompraResource {
	@Autowired 
	private CompraService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CompraResponseDTO> find(@PathVariable Long id){
		Compra obj = service.find(id);
		CompraResponseDTO objDTO = new CompraResponseDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody CompraDTO objDto){
		Compra obj = service.fromDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CompraResponseDTO>> findAll() {
		List<Compra> list = service.findAll();
		List<CompraResponseDTO> listDTO = list.stream().map(obj -> new CompraResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
