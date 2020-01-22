package com.mateus.sistema.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.subgrupo.GrupoDTO;

public class GrupoDtoToGrupo implements Converter<GrupoDTO, Grupo> {
	@Override 
	
	public Grupo convert(GrupoDTO GrupoDto) {
		Grupo grupo = new Grupo();
		if (GrupoDto.getId() != null) {
			grupo.setId(new Long(GrupoDto.getId()));
		}
		grupo.setDescricao(GrupoDto.getDescricao());
		return grupo;
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
