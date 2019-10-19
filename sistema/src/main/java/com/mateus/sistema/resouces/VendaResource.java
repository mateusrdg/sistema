package com.mateus.sistema.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.dto.pedido.venda.VendaDTO;
import com.mateus.sistema.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	@Autowired 
	private VendaService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<VendaDTO> find(@PathVariable Long id){
		Venda obj = service.find(id);
		VendaDTO objDTO = new VendaDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Venda>> findAll() {
		List<Venda> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
