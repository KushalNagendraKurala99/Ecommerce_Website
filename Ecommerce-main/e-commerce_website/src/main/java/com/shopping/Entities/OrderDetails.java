package com.shopping.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
	@Id
	@GenericGenerator(name ="order_no" , strategy ="com.shopping.Entities.OrderIdGeneration")
	@GeneratedValue(generator = "order_no")
	private int orderId;
	
	@Column(name ="total_products",length = 6)
	private int noOfProducts;
	@Column(length = 200)
	private double totalprice;
	@Column(name ="order_date")
	private LocalDate bookingDate=LocalDate.now();
	@Column(name ="delivery_date")
	private LocalDate deliveryDate;
	@Column(length = 100)
	private String seller;
	@Column(length = 100)
	private String delivered;
	
	
	@OneToMany(mappedBy = "orderDetails",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("orderDetails")
	//private List<Products> products;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Product product;

	@Column(length = 50)
	private String status;

}



