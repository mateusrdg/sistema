package com.mateus.sistema.services.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class VendaValidator {
	@Autowired
	private ProdutoEstoqueRepository peRepo;

	
}
