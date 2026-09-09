package com.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
