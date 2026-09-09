package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.OrderDetails;
import com.shopping.Entities.Product;
import com.shopping.service.OrderDetailsService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/orderProduct/{productNo}/{customerId}")
	public ResponseEntity<OrderDetails> orderProduct(@PathVariable("productNo") int productNo,@PathVariable("customerId") int customer,@RequestBody OrderDetails orderDetails)
	{
		return new ResponseEntity<OrderDetails>(orderDetailsService.orderProduct(productNo, customer, orderDetails),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/cancelOrder/{orderId}")
	public String cancelProduct(@PathVariable("orderId") int orderId)
	{
		return orderDetailsService.cancelProduct(orderId);
	}
	
	@GetMapping("/getOrdersByCustomerId/{customerId}")
	 public List<OrderDetails> getOrdersByCustomerId(@PathVariable int customerId) {
	        return orderDetailsService.getOrdersByCustomerId(customerId);
	    }
	
	@GetMapping("/getAllOrders")
	public List<OrderDetails> getAllOrders() {
		return orderDetailsService.getAllOrders();
	}
	


}
