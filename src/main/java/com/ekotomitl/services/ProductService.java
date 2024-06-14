package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Product;
import com.ekotomitl.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	// GET ALL
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}
	// GET ONE
	public Optional<Product> findProductById(Long id) {
		return productRepository.findById(id);
	}
	
	// POST
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	// PUT
	public Product replaceProduct(Product newProduct, Long id) {
		return productRepository.findById(id)
				.map(product -> {
					product.setProduct_name(newProduct.getProduct_name());
					product.setDescription(newProduct.getDescription());
					product.setPrice(newProduct.getPrice());
					product.setDiscount(newProduct.getDiscount());
					return productRepository.save(product);
				})
				.orElseGet(() -> {
					return productRepository.save(newProduct);
				});
	}
	
	// DELETE
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

}
