package com.amazon.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.customer.model.Customer;
import com.amazon.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Customer saveWhisList(Customer customer) {

		Optional<Customer> entity = repository.findById(customer.getId());

		if (entity.isPresent()) {
			entity.get().setName(customer.getName());
			customer.getWishList().stream().forEach(wish -> {
				entity.get().getWishList().add(wish);
			});
			return repository.save(entity.get());
		} else {
			return repository.save(customer);
		}
	}
}
