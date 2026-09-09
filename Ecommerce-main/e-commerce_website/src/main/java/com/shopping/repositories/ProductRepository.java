package com.shopping.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductIdAndBrandAndProductName(int id, String brand, String productName);

}
