package com.example.onebox.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onebox.model.Cart;
import com.example.onebox.model.Product;
import com.example.onebox.repository.CartRepository;
import com.example.onebox.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Cart createCart(Cart cart) {
		setCartInfo(cart);
		List<Product> newList = new ArrayList<>();
		for(Product p : cart.getProducts()) {
			productRepository.saveAndFlush(p);
			newList.add(p);
		}
		cart.setProducts(newList);
		return saveCart(cart);
	}

	@Override
	public void setCartInfo(Cart cart) {
		cart.setUuid(generateUUID());
		cart.setLastActiveTime(LocalDateTime.now());
	}

	@Override
	public Optional<Cart> findByIdWithProducts(String uuid) {
		return cartRepository.findByIdWithProducts(uuid);
	}

	@Override
	public Optional<Cart> updateCart(String uuid, Cart cart) {
		Optional<Cart> existingCart = findByUUID(uuid);
		if(existingCart.isPresent()) {
			List<Product> newList = new ArrayList<>();
			for(Product p : cart.getProducts()) {
				productRepository.saveAndFlush(p);
				newList.add(p);
			}
			existingCart.get().setProducts(newList);
		}
		
		return Optional.ofNullable(saveCart(existingCart.get()));
	}

	@Override
	public void deleteCart(String uuid) {
		Optional<Cart> cart  = findByUUID(uuid);
		
		cartRepository.delete(cart.get());	
	}

	@Override
	public Optional<Cart> findByUUID(String uuid) {
		return cartRepository.findByUuid(uuid);
	}

	@Override
	public String generateUUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}

	@Override
	public void updateActivity(Cart cart) {
		cart.setLastActiveTime(LocalDateTime.now());
	}

	@Override
	public void cleanInactiveCart() {
		LocalDateTime tenMinutesAgo = LocalDateTime.now().minusMinutes(10);
	    List<Cart> inactiveCarts = cartRepository.findByLastActiveTimeBefore(tenMinutesAgo);
	    
	    for (Cart cart : inactiveCarts) {
	        cartRepository.delete(cart);
	    }
	}
	
}
