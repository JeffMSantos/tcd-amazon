package com.amazon.help.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.help.consumer.model.Message;


public interface HelpAMQPRepository extends JpaRepository<Message, Long> {

}
