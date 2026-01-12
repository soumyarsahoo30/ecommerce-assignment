package com.ecommerce.order.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InventoryBatch {
	
	private Long batchId;
	private Long productId;
	private String productName;
	private int quantity;
	private LocalDate expiryDate;

}
