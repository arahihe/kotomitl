package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.SellerPayment;
import com.ekotomitl.repositories.SellerPaymentRepository;

@Service
public class SellerPaymentService {
	@Autowired
	private SellerPaymentRepository sellerPaymentRepository;
	
	// GET
	public List<SellerPayment> findAllPayments() {
		return sellerPaymentRepository.findAll();
	}
	
	public Optional<SellerPayment> findSellerPaymentById(Long id) {
		return sellerPaymentRepository.findById(id);
	}
	
	// POST
	public SellerPayment saveSellerPayment(SellerPayment sellerPayment) {
		return sellerPaymentRepository.save(sellerPayment);
	}
	
	// PUT
	public SellerPayment replaceSellerPayment(SellerPayment newSellerPayment, Long id) {
		return sellerPaymentRepository.findById(id)
				.map(sellerPayment -> {
					sellerPayment.setPayment_date(newSellerPayment.getPayment_date());
					sellerPayment.setAmount(newSellerPayment.getAmount());
					sellerPayment.setStatus(newSellerPayment.getStatus());
					return sellerPaymentRepository.save(sellerPayment);
				})
				.orElseGet(() -> {
					return sellerPaymentRepository.save(newSellerPayment);
				});
	}
	
	// DELETE
	public void deleteSellerPaymentById(Long id) {
		sellerPaymentRepository.deleteById(id);
	}
}