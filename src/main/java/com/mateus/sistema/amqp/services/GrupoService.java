package com.mateus.sistema.amqp.services;

import java.util.List;

import com.mateus.sistema.amqp.commands.GrupoForm;
import com.mateus.sistema.domain.produto.Grupo;

public interface GrupoService {
	List<Grupo> listAll();

	Grupo getById(Long id);

	Grupo saveOrUpdate(Grupo grupo);

	void delete(Long id);

	Grupo saveOrUpdateGrupoForm(GrupoForm grupoDTO);

	void sendProductMessage(String id);
}
