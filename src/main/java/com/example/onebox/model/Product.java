package com.example.onebox.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private int amount;
	
	@ManyToMany
	@JoinTable(
	    name = "cart_products",
	    joinColumns = @JoinColumn(name = "product_id"),
	    inverseJoinColumns = @JoinColumn(name = "cart_uuid")
	)
	@JsonIgnore
	private List<Cart> carts;	
}
