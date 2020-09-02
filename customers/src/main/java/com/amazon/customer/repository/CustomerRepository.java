package com.amazon.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
