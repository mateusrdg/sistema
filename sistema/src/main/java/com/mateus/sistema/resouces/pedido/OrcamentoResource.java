package com.mateus.sistema.resouces.pedido;

import java.util.List;
import java.util.stream.Collectors;

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
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VendaDTO>> findAll() {
		List<Orcamento> list = service.findAll();
		List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
