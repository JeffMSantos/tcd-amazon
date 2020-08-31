package com.amazon.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amazon.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where p.genre.id = ?1")
	List<Product> findByIdGenre(Integer id);

	@Query("select p from Product p where p.name like %?1%")
	List<Product> findByKeyword(String keyword);
}
