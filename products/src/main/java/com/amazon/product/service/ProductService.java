package com.amazon.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.product.model.Product;
import com.amazon.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product create(Product product) {
		return repository.save(product);
	}

	public List<Product> findByIdGenre(Integer id) {
		return repository.findByIdGenre(id);
	}

	public Optional<Product> findById(Integer id) {
		Optional<Product> p = repository.findById(id);
		if (p.isPresent())
			countViews(p.get());
		return p;
	}

	public List<Product> findByKeyword(String keyword) {
		return repository.findByKeyword(keyword);
	}

	public void countViews(Product p) {
		p.setPreview(p.getPreview() + 1);
		repository.save(p);
	}

	public List<Product> findAllViewsToCategory() {
		//List<Product> products = repository.findAll();
		//if (products.size() > 0) {
			return repository.findAll().stream().sorted((f1, f2) -> Long.compare(f2.getPreview(), f1.getPreview()))
					.collect(Collectors.toList());
		//} else {
		//	return null;
	//	}
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
