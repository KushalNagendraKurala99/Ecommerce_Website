package com.shopping.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(length = 50)
	private String productName;
	private double price;
	@Column(length = 50)
	private String category;
	@Column(length = 50)
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("products")
	OrderDetails orderDetails;
	
	

}


