package com.mateus.sistema.resouces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.sistema.domain.Produto;
import com.mateus.sistema.dto.ProdutoDTO;
import com.mateus.sistema.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	@Autowired 
	private ProdutoService service;
	
	private List<ProdutoDTO> listDto = new ArrayList<ProdutoDTO>();;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoDTO> find(@PathVariable Integer id){
		Produto obj = service.find(id);
		ProdutoDTO objDTO = new ProdutoDTO(obj);
		return ResponseEntity.ok(objDTO);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = service.findAll();
		for (Produto obj : list) {
			listDto.addAll(Arrays.asList(new ProdutoDTO(obj)));
		}
		return ResponseEntity.ok().body(listDto);
	}
	
}
