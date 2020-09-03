package com.amazon.orderstatus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.orderstatus.model.OrderStatus;
import com.amazon.orderstatus.model.dto.OderStausDTO;
import com.amazon.orderstatus.repository.OrderStatusRepository;

@Service
public class OrderStatusService {

	@Autowired
	private OrderStatusRepository repository;
	
	public List<OrderStatus> findByIdCustomer(Integer idCustomer) {
		return repository.findByIdCustomer(idCustomer);
	}

	public OrderStatus create(OrderStatus orderStatus) {
		return repository.save(orderStatus);
	}

	public OrderStatus update(OderStausDTO orderStatusDTO, Integer idOrderstatus) {
		Optional<OrderStatus> entity = repository.findById(idOrderstatus);

		if (entity.isPresent()) {
			entity.get().setStatus(orderStatusDTO.getStatus());
			entity.get().setTrackingNumber(orderStatusDTO.getTrackingNumber());
			return repository.save(entity.get());
		} else {
			return null;
		}
	}

}
