package com.shopping.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Entities.Customer;
import com.shopping.Entities.OrderDetails;
import com.shopping.Entities.Product;
import com.shopping.Entities.Products;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repositories.CustomerRepository;
import com.shopping.repositories.OrderDetailsRepository;
import com.shopping.repositories.ProductRepository;
import com.shopping.repositories.ProductsRepository;
import com.shopping.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private OrderDetailsService orderDetailsService; 
 

	@Override
	public OrderDetails orderProduct(int productNo, int customer, OrderDetails orderDetails) {
		Product product=productRepository.findById(productNo).get();
		Customer customer1=customerRepository.findById(customer).get();
		int total_product=product.getAvailableproduct()-orderDetails.getNoOfProducts();
		product.setAvailableproduct(total_product);
		
		//update total fare in ticket table
		orderDetails.setTotalprice(product.getPrice()*orderDetails.getNoOfProducts());
		orderDetails.setCustomer(customer1);
		orderDetails.setProduct(product);
////		List<Products> productsList=orderDetails.getProducts();
////		orderDetails.setProducts(productsList);
//		
//		//setting ticket id to otherspassenger(f.k)
//		Products products=null;
//		//othersPassenger.setTicket(ticketDetails);
//		
//		if(!productsList.isEmpty())
//		{
//			for(Products p:productsList)
//			{
//				products=p;
//				if(p!=null) {
//					products.setOrderDetails(orderDetails);
//					products.setStatus("Confirmed");
//				}
//			}
//		}
		orderDetails.setStatus("Orderd");
		 OrderDetails ordered=orderDetailsRepository.save(orderDetails) ;
		 return ordered;
	}

	@Override
	public String cancelProduct(int orderId) {
		String message=null;
		Optional<OrderDetails> opOrder=orderDetailsRepository.findById(orderId);
		if(opOrder.isPresent())
		{
			int nop=opOrder.get().getNoOfProducts();
			OrderDetails pdetails=opOrder.get();
			pdetails.getProduct().setAvailableproduct(+nop);
			pdetails.setStatus("Cancelled");
			
//			List<Products> proList=pdetails.getProducts();
//			for(Products p:proList)
//			{
//				//if(p.getTicketDetails().getTicketId()==tdetails.getTicketId())
//				productsRepository.delete(p);
//			}
			orderDetailsRepository.save(pdetails);
			message="Your Order is Cancelled";
			
		}
		else
			throw new ResourceNotFoundException("Order","id",orderId);
		
		
		return message;
	}
	@Override
	public List<OrderDetails> getOrdersByCustomerId(int customerId) {
        return orderDetailsRepository.findByCustomerCustomerId(customerId);
    }

	@Override
	public List<OrderDetails> getAllOrders() {
		List<OrderDetails> orders=orderDetailsRepository.findAll();
		return orders;
	}

}
