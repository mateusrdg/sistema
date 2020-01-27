package com.mateus.sistema.amqp.converters;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.mateus.sistema.amqp.commands.GrupoForm;
import com.mateus.sistema.domain.produto.Grupo;


@Component
public class GrupoFormToGrupo implements Converter<GrupoForm, Grupo> {
	@Override

	public Grupo convert(GrupoForm grupoForm) {
		return new Grupo(((grupoForm.getId() == null) ? null : grupoForm.getId()), grupoForm.getDescricao());
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
