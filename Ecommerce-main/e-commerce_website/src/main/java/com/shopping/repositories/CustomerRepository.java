package com.shopping.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.Entities.Customer;
import com.shopping.Entities.OrderDetails;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByCustomerNameAndEmail(String customerName,String email);
	@Query("select c from Customer c where c.customerName=?1")
	List<Customer> getCustomerByName(String customerName);

	@Query("select c from Customer c where c.email=:email")
	Customer getCustomerByEmail(@Param("email") String email);
	
	Optional<Customer> findByEmailAndPassword(String email,String password);
//	List<OrderDetails> findByCustomerId(int customerId);
	}

