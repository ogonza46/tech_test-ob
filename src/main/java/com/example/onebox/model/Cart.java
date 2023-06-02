package com.example.onebox.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "uuid")
	private String uuid;
	@OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_uuid"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
	private List<Product> products;
	private LocalDateTime lastActiveTime;
}
