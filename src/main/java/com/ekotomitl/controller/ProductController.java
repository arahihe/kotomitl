package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.Product;
import com.ekotomitl.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// GET
	@GetMapping
	public List<Product> getAllProduct() {
		return productService.findAllProduct();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable Long id) {
		return productService.findProductById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	try {	
		Product createProduct = productService.saveProduct(product);
		return ResponseEntity.ok(createProduct);
	} catch (Exception e) {
		// manejo de exepciones
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	
	// PUT
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		return productService.replaceProduct(newProduct, id);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		return productService.findProductById(id)
				.map(product -> {
					productService.deleteProductById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
