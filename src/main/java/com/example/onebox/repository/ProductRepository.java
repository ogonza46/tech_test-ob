package com.example.onebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onebox.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
