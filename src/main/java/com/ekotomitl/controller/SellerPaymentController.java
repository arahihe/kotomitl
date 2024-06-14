package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.SellerPayment;
import com.ekotomitl.services.SellerPaymentService;

@RestController
@RequestMapping("/api/sellerpayment")
public class SellerPaymentController {
	@Autowired
	private SellerPaymentService sellerPaymentService; 
	
	// GET
	@GetMapping
	public List<SellerPayment> getAllPayments() {
		return sellerPaymentService.findAllPayments();
	}
	@GetMapping("/{id}")
	public ResponseEntity<SellerPayment> getSellerPaymentById(@PathVariable Long id) {
		return sellerPaymentService.findSellerPaymentById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public SellerPayment createSellerPayment(@RequestBody SellerPayment sellerPayment) {
		return sellerPaymentService.saveSellerPayment(sellerPayment);
	}
	
	// PUT
	@PutMapping("/{id}")
	public SellerPayment updateSellerPayment(@RequestBody SellerPayment newSellerPayment, @PathVariable Long id) {
		return sellerPaymentService.replaceSellerPayment(newSellerPayment, id);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSellerPayment(@PathVariable Long id) {
		return sellerPaymentService.findSellerPaymentById(id)
				.map(sellerPayment -> {
					sellerPaymentService.deleteSellerPaymentById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
