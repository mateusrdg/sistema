package com.mateus.sistema.dto.pessoa;

import com.mateus.sistema.domain.pessoa.Pessoa;
import com.mateus.sistema.dto.EntidadeId;

public class PessoaIdDTO extends EntidadeId{
	private static final long serialVersionUID = 1L;
	
	public PessoaIdDTO() {	
	}
	
	public PessoaIdDTO(Pessoa pessoa) {	
		super(pessoa.getId());
	}
	
}
