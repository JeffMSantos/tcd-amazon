package com.amazon.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.customer.model.Customer;
import com.amazon.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Customer")
@RestController
@RequestMapping("customers")
public class CustumerController {

	private final CustomerService service;

	CustumerController(CustomerService customeService) {
		this.service = customeService;
	}
	
	@ApiOperation("adicionar itens na lista de desejos")
	@PostMapping("/wishlist")
	Customer saveWhisList(@RequestBody Customer customer) {
		return service.saveWhisList(customer);
	}
}
