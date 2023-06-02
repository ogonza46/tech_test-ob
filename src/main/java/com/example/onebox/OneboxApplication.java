package com.example.onebox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.onebox.Service.CartServiceImpl;

@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
public class OneboxApplication {
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(OneboxApplication.class, args);
	}
	
	@Scheduled(fixedRate = 60000) // Ejecutar cada minuto
	public void scheduleInactiveCartDeletion() {
	    cartServiceImpl.cleanInactiveCart();
	}

}
