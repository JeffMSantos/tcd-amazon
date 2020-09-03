package com.amazon.orderstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amazon.orderstatus.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

	@Query("select o from OrderStatus o where o.idCustomer = ?1")
	List<OrderStatus> findByIdCustomer(Integer idCustomer);

}
