package com.mateus.sistema.resources.pedido;

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
import com.mateus.sistema.dto.pedido.compra.CompraNewDTO;
import com.mateus.sistema.services.pedido.CompraService;

@RestController
@RequestMapping(value = "/compras")
public class CompraResource {
	@Autowired 
	private CompraService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CompraDTO> find(@PathVariable Long id){
		Compra obj = service.find(id);
		CompraDTO objDTO = new CompraDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody CompraNewDTO objDto){
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
	public ResponseEntity<List<CompraDTO>> findAll() {
		List<Compra> list = service.findAll();
		List<CompraDTO> listDTO = list.stream().map(obj -> new CompraDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
