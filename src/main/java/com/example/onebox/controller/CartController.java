package com.example.onebox.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onebox.Service.CartService;
import com.example.onebox.model.Cart;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartController {
	
	@Autowired
	private CartService cartServiceImpl;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws Exception{
		Cart newCart = cartServiceImpl.createCart(cart);
		return new ResponseEntity<>(newCart, HttpStatus.CREATED);
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Cart> emptyCart(){
		Cart cart = new Cart();
		cartServiceImpl.setCartInfo(cart);
		Cart newCart = cartServiceImpl.saveCart(cart);
		return new ResponseEntity<>(newCart, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<Cart> getCart(@PathVariable String id) {
		Optional<Cart> cart = cartServiceImpl.findByIdWithProducts(id);
		if(cart.isPresent()){
			cartServiceImpl.updateActivity(cart.get());
			return ResponseEntity.ok(cart.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody Cart cart) throws Exception{
		Optional<Cart> updatedCart = cartServiceImpl.updateCart(id, cart);
		if(updatedCart.isPresent()) {
			cartServiceImpl.updateActivity(updatedCart.get());
			return ResponseEntity.ok(updatedCart.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
