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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.Customer;
import com.shopping.Entities.OrderDetails;
import com.shopping.service.CustomerService;
import com.shopping.service.OrderDetailsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:4200")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	
	@PostMapping("/createCustomer")
	ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.createCustomer(customer),HttpStatus.CREATED);
	}

	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		return customerService.deleteCustomer(id);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable int id)
	{
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/getCustomer/{pname}/{email}")
	public ResponseEntity<Customer> findByCustomerNameAndEmail(@PathVariable("pname") String customerName,@PathVariable("email") String email)
	{
		return new ResponseEntity<Customer>(customerService.findByCustomerNameAndEmail(customerName, email),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByName/{name}")
	List<Customer> getCustomerByName(@PathVariable("name") String customerName)
	{
		return customerService.getCustomerByName(customerName);
	}
	
	@GetMapping("/getCustomerByEmail/{email}")
	Customer getCustomerByEmail(@PathVariable("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
	
	@GetMapping("/getCustomerlogin/{email}/{pwd}")
	public ResponseEntity<Customer> findByEmailAndPassword(@PathVariable("email") String email,@PathVariable("pwd") String password)
	{
		return new ResponseEntity<Customer>(customerService.findByEmailAndPassword(email, password),HttpStatus.OK);
	}
	

}



