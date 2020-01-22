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

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.venda.VendaDTO;
import com.mateus.sistema.dto.response.pedido.venda.VendaResponseDTO;
import com.mateus.sistema.services.pedido.venda.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	@Autowired 
	private VendaService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<VendaResponseDTO> find(@PathVariable Long id){
		Venda obj = service.find(id);
		VendaResponseDTO objDTO = new VendaResponseDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody VendaDTO objDto){
		Venda obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@Valid @RequestBody VendaDTO objDto, @PathVariable Long id){
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VendaResponseDTO>> findAll() {
		List<Venda> list = service.findAll();
		List<VendaResponseDTO> listDTO = list.stream().map(obj -> new VendaResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
}
