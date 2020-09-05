package com.amazon.help.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazon.help.consumer.repository.HelpAMQPRepository;


@Controller
@RequestMapping("/")
public class HelpAMQPController {

    @Autowired
    private HelpAMQPRepository repository;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("messages", repository.findAll());
		return "index";
	}
}
