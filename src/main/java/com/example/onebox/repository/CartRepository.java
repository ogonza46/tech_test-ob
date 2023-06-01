package com.example.onebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onebox.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
