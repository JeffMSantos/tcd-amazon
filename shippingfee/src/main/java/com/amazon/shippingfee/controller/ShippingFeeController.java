package com.amazon.shippingfee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.shippingfee.model.Shipping;
import com.amazon.shippingfee.service.ShippingFeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Shipping")
@RestController
@RequestMapping("/shipping")
public class ShippingFeeController {

	@Autowired
	ShippingFeeService shippingFeeService;
	
	@ApiOperation("calcular frete")
	@GetMapping
	Shipping calculateShipping(@RequestParam String zipCode) {
		return shippingFeeService.calculateShipping(zipCode);
	}
}
