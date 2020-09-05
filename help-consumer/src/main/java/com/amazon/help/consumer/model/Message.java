package com.amazon.help.consumer.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String message;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String message) {
		this.message = message;
	}
}
