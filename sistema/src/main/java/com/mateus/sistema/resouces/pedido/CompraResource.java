package com.mateus.sistema.resouces.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pedido.compra.CompraDTO;
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
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Compra>> findAll() {
		List<Compra> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
