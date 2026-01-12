package com.ecommerce.inventory.service.factory;

public interface InventoryHandler {
	
	void updateInventory(Long productId, int quantity);

}
