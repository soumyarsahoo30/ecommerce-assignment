package com.ecommerce.inventory.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class InventoryBatch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long batchId;
	private Long productId;
	private String productName;
	private int quantity;
	private LocalDate expiryDate;

}
