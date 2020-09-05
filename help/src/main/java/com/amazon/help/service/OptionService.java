package com.amazon.help.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.help.model.Option;
import com.amazon.help.repository.OptionRepository;

@Service
public class OptionService {

	@Autowired
	private OptionRepository repository;

	public List<Option> findAllOption() {
		return repository.findAll();
	}

	public Option create(Option option) {
		return repository.save(option);
	}
}
