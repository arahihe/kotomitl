package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Orders;
import com.ekotomitl.repositories.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	
	// GET ALL
	public List<Orders> findAllOrders() {
		return ordersRepository.findAll();
	}
	// GET ONE
	public Optional<Orders> findOrdersById(Long id) {
		return ordersRepository.findById(id);
	}
	
	// POST
	public Orders saveOrder(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	// PUT
	public Orders replaceOrders(Orders newOrders, Long id) {
		return ordersRepository.findById(id)
			      .map(orders -> {
			    	  orders.setOrder_date(newOrders.getOrder_date());
			    	  orders.setTotal(newOrders.getTotal());
			    	  orders.setStatus(newOrders.getStatus());
			    	  return ordersRepository.save(orders);
			      })
			      .orElseGet(() -> {
			    	  return ordersRepository.save(newOrders);
			      });
	}
	
	// DELETE
	public void deleteOrderById(Long id) {
		ordersRepository.deleteById(id);
	}
}
