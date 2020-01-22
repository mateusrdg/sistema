package com.mateus.sistema.services.amqp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.mateus.sistema.SistemaApplication;
import com.mateus.sistema.converters.GrupoDtoToGrupo;
import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.subgrupo.GrupoDTO;
import com.mateus.sistema.repository.produto.GrupoRepository;

public class GrupoServiceImpl implements GrupoService {

	private static final Logger log = LoggerFactory.getLogger(GrupoServiceImpl.class);

	private GrupoRepository grupoRepository;
	private GrupoDtoToGrupo grupoDtoToGrupo;
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public GrupoServiceImpl(GrupoRepository grupoRepository, GrupoDtoToGrupo grupoDtoToGrupo,
			RabbitTemplate rabbitTemplate) {
		this.grupoRepository = grupoRepository;
		this.grupoDtoToGrupo = grupoDtoToGrupo;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public List<Grupo> listAll() {
		List<Grupo> products = new ArrayList<>();
		grupoRepository.findAll().forEach(products::add); // fun with Java 8
		return products;
	}

	@Override
	public Grupo getById(Long id) {
		return grupoRepository.findById(id).orElse(null);
	}

	@Override
	public Grupo saveOrUpdate(Grupo grupo) {
		grupoRepository.save(grupo);
		return grupo;
	}

	@Override
	public void delete(Long id) {
		grupoRepository.deleteById(id);
	}

	@Override
	public Grupo saveOrUpdateGrupoForm(GrupoDTO grupoDto) {
		Grupo savedProduct = saveOrUpdate(grupoDtoToGrupo.convert(grupoDto));
		System.out.println("Saved Product Id: " + savedProduct.getId());
		return savedProduct;
	}

	@Override
	public void sendProductMessage(String id) {
		Map<String, String> actionmap = new HashMap<>();
		actionmap.put("id", id);
		log.info("Sending the index request through queue message");
		rabbitTemplate.convertAndSend(SistemaApplication.SFG_MESSAGE_QUEUE, actionmap);
	}

}
