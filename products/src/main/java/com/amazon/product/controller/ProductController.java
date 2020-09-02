package com.amazon.product.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.product.model.Product;
import com.amazon.product.model.dto.CustomerDTO;
import com.amazon.product.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Product")
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService service;

	ProductController(ProductService productService) {
		this.service = productService;
	}

	@ApiOperation("criar produto")
	@PostMapping
	Product create(@RequestBody Product product) {
		return service.create(product);
	}
	
	@ApiOperation("listar produtos")
	@GetMapping("/")
	List<Product> findAll() {
		return service.findAll();
	}

	@ApiOperation("visualizar os produtos de um determinado gênero")
	@GetMapping("/genre")
	List<Product> findByGenre(@RequestParam Integer id) {
		return service.findByIdGenre(id);
	}

	@ApiOperation("visualizar os detalhes de cada produto")
	@GetMapping()
	Optional<Product> findById(@RequestParam Integer id) {
		return service.findById(id);
	}
	
	@ApiOperation("buscar um produto por palavra chave")
	@GetMapping("/keyword")
	List<Product> findByGenre(@RequestParam String keyword) {
		return service.findByKeyword(keyword);
	}
	
	@ApiOperation("produtos mais vistos por categoria")
	@GetMapping("/views/category")
	List<Product> findAllViewsToCategory() {
		return service.findAllViewsToCategory();
	}
	
	@ApiOperation("delete produto por id")
	@DeleteMapping
	void deleteById(@RequestParam Integer id) {
		service.deleteById(id);
	}
	
	@ApiOperation("adicionar itens na lista de desejos")
	@PostMapping("/wishlist")	
	void saveWishList(@RequestBody CustomerDTO customerDTO) throws URISyntaxException {
		service.saveWishList(customerDTO);
	}
}
