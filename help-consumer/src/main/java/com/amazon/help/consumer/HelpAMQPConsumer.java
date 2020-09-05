package com.amazon.help.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazon.help.consumer.config.HelpAMQPConfig;
import com.amazon.help.consumer.model.Message;
import com.amazon.help.consumer.repository.HelpAMQPRepository;

@Component
public class HelpAMQPConsumer {

	private static final Logger logger = LoggerFactory.getLogger(HelpAMQPConsumer.class);

	@Autowired
	private HelpAMQPRepository repository;

	@RabbitListener(queues = HelpAMQPConfig.QUEUE)
	public void consumer(Message message) {
		logger.info("Consumindo mensagem da fila...");

		Message m = new Message(message.getMessage());
		repository.save(m);
	}
}
