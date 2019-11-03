package com.mateus.sistema.resouces.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.dto.pedido.venda.VendaDTO;
import com.mateus.sistema.services.pedido.OrcamentoService;

@RestController
@RequestMapping(value = "/orcamentos")
public class OrcamentoResource {
	@Autowired 
	private OrcamentoService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<VendaDTO> find(@PathVariable Long id){
		Orcamento obj = service.find(id);
		VendaDTO objDTO = new VendaDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Orcamento>> findAll() {
		List<Orcamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
