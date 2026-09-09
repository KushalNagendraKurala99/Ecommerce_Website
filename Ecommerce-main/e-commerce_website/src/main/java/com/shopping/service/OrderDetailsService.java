package com.shopping.service;

import java.util.List;

import com.shopping.Entities.Customer;
import com.shopping.Entities.OrderDetails;
import com.shopping.Entities.Product;

public interface OrderDetailsService {
	OrderDetails orderProduct(int productNo,int customer,OrderDetails orderDetails);
	String cancelProduct(int orderId);
	List<OrderDetails> getAllOrders();

	List<OrderDetails> getOrdersByCustomerId(int customerId);

}
