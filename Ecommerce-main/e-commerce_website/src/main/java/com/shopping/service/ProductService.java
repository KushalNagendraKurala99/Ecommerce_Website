package com.shopping.service;


import java.util.List;

import com.shopping.Entities.Customer;
import com.shopping.Entities.Product;

public interface ProductService {
	Product createProduct(Product product);
	String deleteProduct(int id);
	Product updateProduct(int id,Product product);
	Product getProductById(int id);
	List<Product> getAllProduct();
	Product findByProductIdAndBrandAndProductName(int id ,String productName,String brand);
	String assignProductToDateslot(int productNo,int Id);
	List<Product> searchProduct(String category);
	List<Product> searchProductByName(String productName);

}
