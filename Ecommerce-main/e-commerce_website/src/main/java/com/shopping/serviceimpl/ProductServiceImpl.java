package com.shopping.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Entities.Customer;
import com.shopping.Entities.DateSlot;
import com.shopping.Entities.Product;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repositories.DateSlotRepository;
import com.shopping.repositories.ProductRepository;
import com.shopping.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	DateSlotRepository dateSlotRepository; 

	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public String deleteProduct(int id) {
		String message=null;
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.deleteById(id);
			message=new String("Product record deleted successfully!");
		}
		else 
		{
			throw new ResourceNotFoundException("Product", "id", id);
			
		}
		return message;
	
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product existingProduct=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "id", id));
		existingProduct.setProductName(product.getProductName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setBrand(product.getBrand());
		
		
		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public Product getProductById(int id) {
		Product product=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "id", id));
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product findByProductIdAndBrandAndProductName(int id, String brand,String productName) {
		Optional<Product> product=productRepository.findByProductIdAndBrandAndProductName(id, brand, productName);
		Product p=null;
		if(product.isPresent())
		{
			p=product.get();
			return p;
		}
		else
			throw new ResourceNotFoundException("Invalid details please check the product Details");
		}

	@Override
	public String assignProductToDateslot(int productNo, int dateslotId) {
		Product product=productRepository.findById(productNo).get();
		DateSlot dateslot=dateSlotRepository.findById(dateslotId).get();
		
		List<Product> products=new ArrayList<>();
		products.add(product);
		dateslot.setProducts(products);
		product.setDateSlot(dateslot);
		productRepository.save(product);
		
		return "Dateslot is Added successfully!";
	}
	
	@Override
	public List<Product> searchProduct(String category) {
		List<Product> products=productRepository.findAll();
		List<Product> trn=new ArrayList<>();
		for(Product t:products) {
			if(t.getCategory().equalsIgnoreCase(category))
			{
				trn.add(t);
			}
		}
		return trn;
	}
	
	@Override
	public List<Product> searchProductByName(String productName){
		List<Product> products=productRepository.findAll();
		List<Product> trn=new ArrayList<>();
		for(Product t:products) {
			if(t.getProductName().equalsIgnoreCase(productName))
			{
				trn.add(t);
			}
		}
		return trn;
	}
		
}
