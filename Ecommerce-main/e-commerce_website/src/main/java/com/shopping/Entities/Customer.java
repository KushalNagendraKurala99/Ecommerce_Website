package com.shopping.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int customerId;
	@Column(name = "name", length =30)
	private String customerName;
	private int age;
	@Column(length =20)
	private String gender;
	@Column(length = 60,unique = true)
	private String email;
	@Column(length = 10,unique = true)
	private String phno;
	@Column(length = 10,unique = true)
	private String password;
	@Column(length = 20)
	private String address;
	
	
	@ManyToOne
	@JoinColumn(name="order_Id")
	@JsonIgnoreProperties("products")
	OrderDetails order;
}


