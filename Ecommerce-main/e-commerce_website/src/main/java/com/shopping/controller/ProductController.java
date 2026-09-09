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
import com.shopping.Entities.Product;
import com.shopping.service.ProductService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/createProduct")
	ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.createProduct(product),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return productService.deleteProduct(id);
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.updateProduct(id, product),HttpStatus.OK);
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAlProducts()
	{
		return productService.getAllProduct();
	}
	
	@GetMapping("/getProduct/{id}/{brand}/{productName}")
	public ResponseEntity<Product> findByProductIdAndBrandAndProductName(@PathVariable("id") int id, @PathVariable("brand") String brand, @PathVariable("productName") String productName)
	{
		return new ResponseEntity<Product>(productService.findByProductIdAndBrandAndProductName(id, brand, productName),HttpStatus.OK);
	}
	
	@PostMapping("/assignProductToDateslot/{productNo}/{dateslotId}")
	public String assignTrainToTimeslot(@PathVariable("productNo") int productNo,@PathVariable("dateslotId") int dateslotId)
	{
		return productService.assignProductToDateslot(productNo, dateslotId);
	}
	
	@GetMapping("/searchProduct/{category}")
	public List<Product> searchProduct(@PathVariable("category") String category)
	{
		return productService.searchProduct(category);
	}
	
	@GetMapping("/searchProductByName/{productName}")
	public List<Product>searchProductByName(@PathVariable("productName") String productName)
	{
		return productService.searchProductByName(productName);
	}



}
