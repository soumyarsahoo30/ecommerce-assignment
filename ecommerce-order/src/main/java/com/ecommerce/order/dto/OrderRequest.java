package com.ecommerce.order.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderRequest {

	private Long productId;
    private String productName;
    private int quantity;
    
}
