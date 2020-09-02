package com.amazon.product.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazon.product.model.Product;
import com.amazon.product.model.dto.CustomerDTO;
import com.amazon.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private DiscoveryClient discoveryClient;

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
		return repository.findAll().stream().sorted((f1, f2) -> Long.compare(f2.getPreview(), f1.getPreview()))
				.collect(Collectors.toList());
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Async
	public void saveWishList(CustomerDTO customerDTO) throws URISyntaxException {
		List<ServiceInstance> instances = discoveryClient.getInstances("customers");

		if (instances.size() == 0) {
			throw new RuntimeException();
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String baseUrl = instances.get(0).getUri().toString() + "/customers/wishlist";
			URI uri = new URI(baseUrl);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "Application/json");

			HttpEntity<CustomerDTO> request = new HttpEntity<>(customerDTO, headers);

			restTemplate.postForEntity(uri, request, String.class);

		}
	}
}
