package com.mateus.sistema.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mateus.sistema.domain.pessoa.Cliente;
import com.mateus.sistema.dto.pessoa.cliente.ClienteNewDTO;
import com.mateus.sistema.repository.pessoa.ClienteRepository;
import com.mateus.sistema.resources.exceptions.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getEnderecos().isEmpty()) {
			list.add(new FieldMessage("enderecos", "insira pelo menos 1 endereço"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());

		if (aux != null) {
			list.add(new FieldMessage("email", "E-mail já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
