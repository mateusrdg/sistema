package com.mateus.sistema.resources.controllers.caixa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.caixa.CaixaMovimentacao;
import com.mateus.sistema.dto.caixa.CaixaMovimentacaoDTO;
import com.mateus.sistema.services.caixa.CaixaMovimentacaoService;

@RestController
@RequestMapping(value = "/caixamovimentacoes")
public class CaixaMovimentacaoResource {
	@Autowired 
	private CaixaMovimentacaoService service;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CaixaMovimentacaoDTO> find(@PathVariable Long id){
		CaixaMovimentacao obj = service.find(id);
		CaixaMovimentacaoDTO objDTO = new CaixaMovimentacaoDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CaixaMovimentacao>> findAll() {
		List<CaixaMovimentacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
