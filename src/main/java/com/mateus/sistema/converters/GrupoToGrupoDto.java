package com.mateus.sistema.converters;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.subgrupo.GrupoDTO;

@Component
public class GrupoToGrupoDto implements Converter<Grupo, GrupoDTO> {
	@Override
	public GrupoDTO convert(Grupo grupo) {
		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(grupo.getId());
		grupoDto.setDescricao(grupo.getDescricao());
		return grupoDto;
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}
}
