package com.mateus.sistema.amqp.listeners;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.repository.produto.GrupoRepository;
@Component
public class GrupoMessageListener {

	private GrupoRepository grupoRepository;

    private static final Logger log = LogManager.getLogger(GrupoMessageListener.class);

    public GrupoMessageListener(GrupoRepository productRepository) {
        this.grupoRepository = productRepository;
    }

    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        Grupo grupo = grupoRepository.findById(id).orElse(null);
        grupo.setMessageReceived(true);
        grupo.setMessageCount(grupo.getMessageCount() + 1);

        grupoRepository.save(grupo);
        log.info("Message processed...");
    }
}
