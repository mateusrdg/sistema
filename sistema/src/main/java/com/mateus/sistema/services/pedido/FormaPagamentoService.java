package com.mateus.sistema.services.pedido;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.FormaPagamento;
import com.mateus.sistema.dto.pedido.FormaPagamentoDTO;
import com.mateus.sistema.dto.pedido.FormaPagamentoIdDTO;
import com.mateus.sistema.repository.pedido.FormaPagamentoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository repo;
	
	public FormaPagamento find(Long id) {
		Optional<FormaPagamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Forma de pagamento não encontrada! Id: " + id + ", Tipo: " + FormaPagamento.class.getName()));
	}
	
	public FormaPagamento fromDto (FormaPagamentoDTO objDto) {
		return new FormaPagamento(objDto.getId(), objDto.getDescricao(), objDto.getTipo());
	}

	public FormaPagamento fromDto(FormaPagamentoIdDTO formaPagamento) {
		return find(formaPagamento.getId());
	}
}
