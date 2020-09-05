package com.amazon.help.service;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.amazon.help.config.HelpAMQPConfig;
import com.amazon.help.model.Help;
import com.amazon.help.model.dto.HelpDTO;
import com.amazon.help.repository.HelpRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HelpService {

	@Autowired
	private HelpRepository repository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public List<Help> findAllHelp() {
		return repository.findAll();
	}

	public Help create(Help help) {
		Help entity = repository.save(help);
		sendToRabbit(entity);
		return entity;
	}

	public Help update(HelpDTO helpDTO, Integer id) {
		Optional<Help> entity = repository.findById(id);

		if (entity.isPresent()) {
			entity.get().setStatus(helpDTO.getStatus());
			return repository.save(entity.get());
		} else {
			return null;
		}
	}

	@Async
	public void sendToRabbit(Help help) {
		try {
			String json = new ObjectMapper().writeValueAsString(help);
			rabbitTemplate.convertAndSend(HelpAMQPConfig.EXCHANGE_NAME, "", json);
		} catch (JsonProcessingException e) {
			e.getMessage();
		}
	}
}
