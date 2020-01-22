package com.mateus.sistema.services.amqp;

import java.util.List;

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.subgrupo.GrupoDTO;

public interface GrupoService {
	List<Grupo> listAll();

	Grupo getById(Long id);

	Grupo saveOrUpdate(Grupo grupo);

	void delete(Long id);

	Grupo saveOrUpdateGrupoForm(GrupoDTO grupoDTO);

	void sendProductMessage(String id);
}
