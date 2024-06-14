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

import com.ekotomitl.models.Orders;
import com.ekotomitl.services.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	// GET
	@GetMapping
	public List<Orders> getAllOrders() {
		return ordersService.findAllOrders();
	}
	@GetMapping("{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
		return ordersService.findOrdersById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public Orders createOrder(@RequestBody Orders orders) {
		return ordersService.saveOrder(orders);
	}
	
	// PUT
	@PutMapping("{id}")
	public Orders updateOrders(@RequestBody Orders newOrders, @PathVariable Long id) {
		return ordersService.replaceOrders(newOrders, id);
	}
	
	// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		return ordersService.findOrdersById(id)
				.map(orders -> {
					ordersService.deleteOrderById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
