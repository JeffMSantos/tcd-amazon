package com.amazon.orderstatus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.orderstatus.model.OrderStatus;
import com.amazon.orderstatus.model.dto.OderStausDTO;
import com.amazon.orderstatus.service.OrderStatusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("OrderStatus")
@RestController
@RequestMapping("orderstatus")
public class OrderStatusController {

	private final OrderStatusService service;

	OrderStatusController(OrderStatusService orderStatusService) {
		this.service = orderStatusService;
	}
	
	@ApiOperation("criar OrderStatus")
	@PostMapping
	OrderStatus create(@RequestBody OrderStatus orderStatus) {
		return service.create(orderStatus);
	}
	
	@ApiOperation("acompanhar os dados do seu pedido")
	@GetMapping("/customer")
	List<OrderStatus> findByGenre(@RequestParam Integer idCustomer) {
		return service.findByIdCustomer(idCustomer);
	}
	
	@ApiOperation("Atualizar dados do pedido")
	@PatchMapping
	OrderStatus update(@RequestBody OderStausDTO orderStatusDTO, @RequestParam Integer idOrderstatus) {
		return service.update(orderStatusDTO, idOrderstatus);
	}
}
