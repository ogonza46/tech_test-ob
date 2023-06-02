package com.example.onebox.Service;

import java.util.Optional;

import com.example.onebox.model.Cart;

public interface CartService {
	
	Optional<Cart> findByIdWithProducts(String uuid);
	
	Optional<Cart> findByUUID(String uuid);
	
	Cart createCart(Cart cart);
	
	public void setCartInfo(Cart cart);
	
	Cart saveCart(Cart cart);
	
	Optional<Cart> updateCart(String uuid, Cart cart);
	
	void deleteCart(String uuid);

	String generateUUID();
	
	void updateActivity(Cart cart);
	
	void cleanInactiveCart();
}
