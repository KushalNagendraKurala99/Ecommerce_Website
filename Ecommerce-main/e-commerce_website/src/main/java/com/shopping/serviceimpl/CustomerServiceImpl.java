package com.shopping.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Entities.Customer;
import com.shopping.Entities.OrderDetails;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repositories.CustomerRepository;
import com.shopping.repositories.OrderDetailsRepository;
import com.shopping.repositories.ProductRepository;
import com.shopping.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	

	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
		
		@Override
		public String deleteCustomer(int id) {
			String message=null;
			Optional<Customer> customer=customerRepository.findById(id);
			if(customer.isPresent()) {
				customerRepository.deleteById(id);
				message=new String("Customer record deleted successfully!");
			}
			else 
			{
				throw new ResourceNotFoundException("Customer", "id", id);
				
			}
			return message;
		}

		@Override
		public Customer updateCustomer(int id, Customer customer) {
			
			Customer existingCustomer=customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer", "id", id));
			existingCustomer.setCustomerName(customer.getCustomerName());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setAge(customer.getAge());
			existingCustomer.setGender(customer.getGender());
			existingCustomer.setPhno(customer.getPhno());
			existingCustomer.setPassword(customer.getPassword());
			existingCustomer.setAddress(customer.getAddress());
			
			customerRepository.save(existingCustomer);
			return existingCustomer;
		}
		
		@Override
		public Customer getCustomerById(int id) {
			Customer customer=customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer", "id", id));
			return customer;
		}


		@Override
		public List<Customer> getAllCustomer() {
			List<Customer> customers=customerRepository.findAll();
			return customers;
		}

		@Override
		public Customer findByCustomerNameAndEmail(String customerName, String email) {
		Optional<Customer> customer=customerRepository.findByCustomerNameAndEmail(customerName, email);
		Customer p=null;
		if(customer.isPresent())
		{
			p=customer.get();
			return p;
		}
		else
			throw new ResourceNotFoundException("Invalid details please check Customer Name and Email");
		}

		@Override
		public List<Customer> getCustomerByName(String customerName) {
			List<Customer> customers=customerRepository.getCustomerByName(customerName);
			return customers;
		}

		@Override
		public Customer getCustomerByEmail(String email) {
			
			return customerRepository.getCustomerByEmail(email);
		}

		@Override
		public Customer findByEmailAndPassword(String email, String password) {
			Optional<Customer> customer=customerRepository.findByEmailAndPassword(email, password);
			Customer c=null;
			if(customer.isPresent())
			{
				c=customer.get();
				return c;
			}
			else
				throw new ResourceNotFoundException("Invalid details please check Customer Email and Password");
			}

//		@Override
//		public List<OrderDetails> getOrderDetailsByCustomerId(int customerId) {
//			List<OrderDetails> orders=customerRepository.findByCustomerId(customerId);
//			return orders;
//		}
		
	}

