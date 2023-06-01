package com.example.onebox.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	private UUID id;
	private List<Product> products;
	private Date lastTimeActive;
}
