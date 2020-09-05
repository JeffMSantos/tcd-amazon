package com.amazon.help.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.help.model.Help;
import com.amazon.help.model.Option;
import com.amazon.help.model.dto.HelpDTO;
import com.amazon.help.service.HelpService;
import com.amazon.help.service.OptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Help")
@RestController
@RequestMapping("/help")
public class HelpController {

	private HelpService helpService;
	private OptionService optionService;

	HelpController(HelpService helpService, OptionService optionService) {
		this.helpService = helpService;
		this.optionService = optionService;
	}

	@ApiOperation("listar opções de chamado")
	@GetMapping("/options")
	List<Option> findAllOption() {
		return optionService.findAllOption();
	}

	@ApiOperation("listar chamados")
	@GetMapping("/")
	List<Help> findAllHelp() {
		return helpService.findAllHelp();
	}
	
	@ApiOperation("criar chamado")
	@PostMapping
	Help create(@RequestBody Help help) {
		return helpService.create(help);
	}
	
	@ApiOperation("criar opções de chamado")
	@PostMapping("/options")
	Option create(@RequestBody Option option) {
		return optionService.create(option);
	}
	
	@ApiOperation("Atualizar status do chamado")
	@PatchMapping
	Help update(@RequestBody HelpDTO helpDTO, @RequestParam Integer id) {
		return helpService.update(helpDTO, id);
	}
}
