package com.shopping.service;

import java.util.List;

import com.shopping.Entities.Customer;
import com.shopping.Entities.OrderDetails;


public interface CustomerService {
	Customer createCustomer(Customer customer);
	String deleteCustomer(int id);
	Customer updateCustomer(int id,Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomer();
	Customer findByCustomerNameAndEmail(String customerName,String email);
	List<Customer> getCustomerByName(String customerName);
	Customer getCustomerByEmail(String email);
	Customer findByEmailAndPassword(String email,String password);
//	List<OrderDetails> getOrderDetailsByCustomerId(int customerId);
}
