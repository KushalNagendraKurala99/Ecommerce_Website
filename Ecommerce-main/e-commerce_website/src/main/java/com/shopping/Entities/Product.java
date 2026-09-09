package com.shopping.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int productId;
	@Column(name = "name", length =30)
	private String productName;
	private double price;
	@Column(length =60)
	private String category;
	@Column(length = 60)
	private String brand;
	private int availableproduct;
@ManyToOne
@JoinColumn(name="dateSlot")
@JsonIgnoreProperties("products")
private DateSlot dateSlot;
}